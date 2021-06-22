package ru.onoprienko.simplecalc.core;

import java.io.IOException;

import ru.onoprienko.simplecalc.data.DataTransferObject;

public class Facade {

    private Reader reader;
    private Calculator calculator;
    private Formatter formatter;
    private Parser parser;

    public Facade(Reader reader, Calculator calculator, Formatter formatter, Parser parser) {
        this.reader = reader;
        this.calculator = calculator;
        this.formatter = formatter;
        this.parser = parser;
    }

    public void calculate() throws IOException {
        String inputLine = reader.read();
        DataTransferObject dto = parser.getData(inputLine);
        dto = calculator.calculate(dto);
        System.out.println(formatter.format(dto));
    }
}
