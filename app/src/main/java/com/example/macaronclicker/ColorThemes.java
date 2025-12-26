package com.example.macaronclicker;

import android.graphics.drawable.Drawable;

public enum ColorThemes {
    RASPBERRY("#fdacc8"),
    LEMON("#d2b54e"),
    PISTACHIO("#7eb36d"),
    UBE("#a35fc1");

    private String colour;
    private int macaronPic;
    private int macaronPicSmall;
    ColorThemes(String colour){
        this.colour = colour;
        switch (colour){
            // Raspberry
            case ("#fdacc8"):
                this.macaronPic = R.drawable.macaron;
                this.macaronPicSmall = R.drawable.macaron_small;
                break;

                //Lemon
            case("#d2b54e"):
                this.macaronPic = R.drawable.macaron_yellow;
                this.macaronPicSmall = R.drawable.macaron_small_yellow;
                break;

                //Pistachio
            case("#7eb36d"):
                this.macaronPic = R.drawable.macaron_green;
                this.macaronPicSmall = R.drawable.macaron_small_green;
                break;

                //Ube
            case("#a35fc1"):
                this.macaronPic = R.drawable.macaron_purple;
                this.macaronPicSmall = R.drawable.macaron_small_purple;
                break;
        }
    }

    public String get(){
        return colour;
    }

    public int getMacaronPic(){
        return macaronPic;
    }

    public int getMacaronPicSmall(){
        return macaronPicSmall;
    }
}
