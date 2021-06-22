package ru.onoprienko.simplecalc;

import java.io.IOException;

import ru.onoprienko.simplecalc.core.Calculator;
import ru.onoprienko.simplecalc.core.Facade;
import ru.onoprienko.simplecalc.core.Formatter;
import ru.onoprienko.simplecalc.core.Parser;
import ru.onoprienko.simplecalc.core.Reader;

public class Main {
    public static void main(String[] args) throws IOException {
        Facade simpleCalcFacade = new Facade(new Reader(), new Calculator(), new Formatter(), new Parser());
        simpleCalcFacade.calculate();

    }
}
