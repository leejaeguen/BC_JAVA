package com.worms.userservice.dto;

import lombok.Data;

@Data
public class RequestLoginDTO {
    private String email;
    private String pwd;
}
