package com.devmind.adnotari;

import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        var message = "ahdgajdha transient asudgad";
        var matcher = Pattern.compile("transient").matcher(message);
        System.out.println(matcher.find());
    }

}
