package com.worms.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private int sequence;
    private String name;
    private String phone;
    private String email;
    private Account personalAccount;

}
