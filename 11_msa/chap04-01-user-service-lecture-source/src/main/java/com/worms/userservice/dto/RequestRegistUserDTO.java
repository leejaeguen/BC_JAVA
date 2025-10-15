package com.worms.userservice.dto;

import lombok.Data;

@Data
public class RequestRegistUserDTO {
    private  String name;
    private String email;
    private String pwd;
}
