package com.example.curs13springboot;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public int getResult(MathServiceDto mathServiceDto) {
        int firstNumber = mathServiceDto.getFirstNumber();
        int secondNumber = mathServiceDto.getSecondNumber();
        String operation = mathServiceDto.getOperation();

        return switch (operation) {
            case "difference" -> firstNumber - secondNumber;
            case "sum" -> firstNumber + secondNumber;
            case "multiply" ->  firstNumber * secondNumber;
            case "divide" -> firstNumber / secondNumber;
            case "power" ->  (int) Math.pow(firstNumber, secondNumber);
            default -> 0;
        };
    }




}
