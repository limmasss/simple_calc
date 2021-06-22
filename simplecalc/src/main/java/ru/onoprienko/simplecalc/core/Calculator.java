package ru.onoprienko.simplecalc.core;

import ru.onoprienko.simplecalc.data.DataTransferObject;
import ru.onoprienko.simplecalc.data.Operation;

public class Calculator {
    public DataTransferObject calculate(DataTransferObject dto) {

        Operation operation = dto.getOperation();
        int firstNumber = dto.getFirstNumber();
        int secondNumber = dto.getSecondNumber();

        switch (operation) {
        case ADDITION:
            dto.setResult(firstNumber + secondNumber);
            break;
        case SUBSTRACTION:
            dto.setResult(firstNumber - secondNumber);
            break;
        case MULTIPLICATION:
            dto.setResult(firstNumber * secondNumber);
            break;
        case DIVISION:
            dto.setResult(firstNumber / secondNumber);
            break;
        }
        return dto;
    }
}
