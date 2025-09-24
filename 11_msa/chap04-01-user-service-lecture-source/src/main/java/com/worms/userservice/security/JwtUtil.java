package com.worms.userservice.security;


import com.worms.userservice.service.UserService;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtUtil {

    private final Key key;
    private final UserService userService;

    public JwtUtil(@Value("${token.secret}")Key key, UserService userService) {
        this.key = key;
        this.userService = userService;
    }

    /* 설명. 비밀키 및 각종 예외처리를 통해 토큰 유효성 검사 */
    public boolean valicateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | io.jsonwebtoken.MalformedJwtException e) {
            log.info("유효하지 않은 JWT Token(서명/형식 오류)");
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            log.info("만료기간이 지남");
        } catch (io.jsonwebtoken.UnsupportedJwtException e) {
            log.info("지원하지 않는 JWT Token");
        } catch (IllegalArgumentException e) {
            log.info("토큰의 클레임이 비어있음");
        }


        return false;
    }

    /* 설명. 유효성 검증이 된 토큰에서 인증 객체(Authentication)를 반환 */
    public Authentication getAuthentication(String token) {

        Claims claims = parseClaims(token);

        /* 설명. 토큰에 들어있던 이메일(sub)로 DB에서 회원 조회하고 UserDetails로 가져옴 */
        UserDetails userDetails = userService.loadUserByUsername(claims.getSubject());

        /* 설명. 토큰에 들어있는 권한들을 List<GrantedAuthority>로 꺼내보기 */
        /* 설명. 1. 토큰에 권한이 들어 있을 때 */
        Collection<GrantedAuthority> authorities = null;
        if(claims.get("auth") != null){
            throw new RuntimeException("권한이 들어있지 않은 토큰입니다.");
        } else {
            authorities =
                    Arrays.stream(claims.get("auth").toString()
                            .replace("[", "")
                            .replace("]", "")
                            .split(", "))
                            .map(role -> new SimpleGrantedAuthority(role))
                            .collect(Collectors.toList());
        }

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
        
        /* 설명. 2. Service 계층의 loadUserByUsername() 메소드 반환값(UserDetails)를 활용할 때 */
//        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities.getAuthorities);
    }

    /* 설명. 문자열 토큰에서 payload에 담긴 클레임들만 추출 */
    private Claims parseClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
