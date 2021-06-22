package ru.onoprienko.simplecalc.core;

import ru.onoprienko.simplecalc.data.DataTransferObject;
import ru.onoprienko.simplecalc.data.Format;

public class Formatter {

    public String format(DataTransferObject dto) {
        String result = "";
        if (dto.getFormat().equals(Format.ARABIC)) {
            result = String.valueOf(dto.getResult());
        } else {
            result = formatRoman(dto.getResult());
        }
        return result;
    }

    private String formatRoman(int result) {
        String res = "";
        while (result > 0) {
            if (result > 999) {
                res += "M";
                result -= 1000;
            } else {
                if (result / 900 == 1) {
                    res += "CM";
                    result -= 900;
                } else {
                    if (result > 499) {
                        res += "D";
                        result -= 500;
                    } else if (result / 400 == 1) {
                        res += "CD";
                        result -= 400;
                    } else {
                        if (result > 99) {
                            res += "С";
                            result -= 100;
                        } else {
                            if (result / 90 == 1) {
                                res += "XC";
                                result -= 90;
                            } else {
                                if (result > 49) {
                                    res += "L";
                                    result -= 50;
                                } else if (result / 40 == 1) {
                                    res += "XL";
                                    result -= 40;
                                } else {
                                    if (result > 9) {
                                        res += "X";
                                        result -= 10;
                                    } else {
                                        if (result > 4) {
                                            res += "V";
                                            result -= 5;
                                        } else if (result == 4) {
                                            res += "IV";
                                            result -= 4;
                                        } else {
                                            res += "I";
                                            result -= 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
