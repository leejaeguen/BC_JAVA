package com.worms.userservice.dto;

import lombok.Data;

/* 설명. 회원가입 시 사영자의 입력값을 받아낼 커맨드 객체용 클래스 */
@Data
public class ResponseRegistUserDTO {
    private String email;
    private String name;
    private String userId;  // 회원가입 이후 생성된 회원 고유 번호
}
