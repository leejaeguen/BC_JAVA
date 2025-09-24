package com.worms.userservice.service;

import com.worms.userservice.aggregate.UserEntity;
import com.worms.userservice.dto.UserDTO;
import com.worms.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void registUser(UserDTO userDTO) {

        /* 설명. 회원 가입 할 인원에게 고유 아이디 생성 */
        userDTO.setUserId(UUID.randomUUID().toString());

        /* 설명. ModelMapper를 활용할 때 필드명이 정확히 일치해야 하는 경우 추가 설정해 주어야 한다. */
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        log.info("Service 계층에서 DTO -> Entity: {}", userEntity);

        /* 설명. UserDTO로 넘어온 사용자의 암호(평문)를 BCrypt 암호화 해서(다이제스트) UserEntity에 전달 */
        userEntity.setEncryptPwd(bCryptPasswordEncoder.encode(userDTO.getPwd()));

        userRepository.save(userEntity);
    }

    /* 설명. spring security 사용 시 프로바이더에서 활용 할 로그인용 메소드(UserDetails 타입을 반환하는 메소드) */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        /* 설명. 넘어온 email과 일치하는 email을 가진 회원을 조회해서 UserEntity로 반환(조회)받음 */
        UserEntity loginUser = userRepository.findByEmail(email);   // 쿼리 메소드를 활용한 email where절 활용

        /* 설명. 사용자가 로그인 시 아이디(이메일)를 잘못 입력 했다면 */
        if(loginUser == null) {
            throw new UsernameNotFoundException(email + " 이메일 아이디의 유저는 존재하지 않습니다.");
        }

        /* 설명. DB에서 조회 된 해당 email의 회원이 가진 권한들을 가져와 List<GrantedAuthority>로 전환 */
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ENTERPRISE"));

        return new User(loginUser.getEmail(), loginUser.getEncryptPwd(), true,
                true, true, true, grantedAuthorities);
    }
}