package com.worms.transactional.section01.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderMenu {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
}
