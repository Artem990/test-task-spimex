package com.spimex.demospimex.util;

import java.text.DecimalFormat;

public class Util {
    public static String doubleToDecimal(double num){
        return new DecimalFormat("0.00").format(num);
    }

}
