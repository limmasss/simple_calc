package ru.onoprienko.simplecalc.core;

import java.io.IOException;

import ru.onoprienko.simplecalc.data.DataTransferObject;
import ru.onoprienko.simplecalc.data.Format;
import ru.onoprienko.simplecalc.data.Operation;

public class Parser {

    private static final String SPACE = " ";

    public DataTransferObject getData(String inputLine) throws IOException {

        String[] inputSymbols = inputLine.split(SPACE);

        int firstNumber;
        int secondNumber;
        Format format;
        Operation operation = null;

        if (inputSymbols[0].matches("[0-9]{" + inputSymbols[0].length() + "}")
                && inputSymbols[2].matches("[0-9]{" + inputSymbols[2].length() + "}")) {
            firstNumber = Integer.parseInt(inputSymbols[0]);
            secondNumber = Integer.parseInt(inputSymbols[2]);
            format = Format.ARABIC;
        } else if (inputSymbols[0].matches("[IVXLCDM]{" + inputSymbols[0].length() + "}")
                && inputSymbols[2].matches("[IVXLCDM]{" + inputSymbols[2].length() + "}")) {
            firstNumber = parseArabicNumber(inputSymbols[0]);
            secondNumber = parseArabicNumber(inputSymbols[2]);
            format = Format.ROMAN;
        } else
            throw new IOException("You've input wrong numbers!");

        if (!inputSymbols[1].matches("[+\\-*/]{1}")) {
            throw new IOException("You've input wrong operation!");
        } else {
            switch (inputSymbols[1]) {
            case "+":
                operation = Operation.ADDITION;
                break;
            case "-":
                operation = Operation.SUBSTRACTION;
                break;
            case "*":
                operation = Operation.MULTIPLICATION;
                break;
            case "/":
                operation = Operation.DIVISION;
                break;
            }
        }

        if (firstNumber > 10 || secondNumber > 10) {
            throw new IOException("You should enter numbers less than 11");
        }

        return new DataTransferObject(firstNumber, secondNumber, operation, format);
    }

    public int parseArabicNumber(String romanNumber) {

        int previousNumeral = 0;
        int currentNumeral = 0;
        int arabicNumber = 0;

        for (int i = 0; i < romanNumber.length(); i++) {
            char numeral = romanNumber.charAt(i);

            switch (numeral) {
            case 'I':
                currentNumeral = 1;
                break;
            case 'V':
                currentNumeral = 5;
                break;
            case 'X':
                currentNumeral = 10;
                break;
            case 'L':
                currentNumeral = 50;
                break;
            case 'C':
                currentNumeral = 100;
                break;
            case 'D':
                currentNumeral = 500;
                break;
            case 'M':
                currentNumeral = 1000;
                break;
            }

            if (currentNumeral > previousNumeral) {
                arabicNumber += currentNumeral - (2 * previousNumeral);
            } else {
                arabicNumber += currentNumeral;
            }
            previousNumeral = currentNumeral;
        }
        return arabicNumber;
    }
}
