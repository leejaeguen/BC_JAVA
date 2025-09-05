package com.worms.section02.javaconfig;

import com.worms.common.Account;
import com.worms.common.MemberDTO;
import com.worms.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfigurarion {
    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20, "110-234-4567890");
    }

    @Bean
    public MemberDTO memberGenarator() {
        /* 설명. 생성자 주입(의존관계의 다른 bean 주입) */
//        return new MemberDTO(1, "홍길동", "010-222-3333"
//                            , "worms@naver.com", accountGenerator());

        /* 설명. setter주입 */
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("유관순");
        member.setPhone("010-111-2222");
        member.setEmail("Yu@gmail.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}
