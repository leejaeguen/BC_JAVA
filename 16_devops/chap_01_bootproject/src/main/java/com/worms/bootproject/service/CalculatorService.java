package com.worms.bootproject.service;
import com.worms.bootproject.dto.CalculatorDTO;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService {
    public int plusTwoNumbers(CalculatorDTO calculatorDTO) {
        return calculatorDTO.getNum1() + calculatorDTO.getNum2();
    }
}
