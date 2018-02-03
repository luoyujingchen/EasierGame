package com.example.luoyu.easiergame.tools;

import android.graphics.Color;

/**
 * Created by luoyu on 2018/2/3.
 */

public class MColor {
    int red;
    int green;
    int blue;

    MColor(int color) {
        red = getRedFromInt(color);
        green = getGreenFromInt(color);
        blue = getBlueFromInt(color);
    }

    private static int getRedFromInt(int i) {
        return Color.red(i);
    }

    private static int getGreenFromInt(int i) {
        return Color.green(i);
    }

    private static int getBlueFromInt(int i) {
        return Color.blue(i);
    }


    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }


}
