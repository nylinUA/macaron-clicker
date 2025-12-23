package com.example.macaronclicker;

public enum ColorThemes {
    RASPBERRY("#1f2326"),
    LEMON("#d2b54e"),
    PISTACHIO("#7eb36d"),
    UBE("#a35fc1");

    private String colour;
    ColorThemes(String colour){
        this.colour = colour;
    }

    public String get(){
        return colour;
    }
}
