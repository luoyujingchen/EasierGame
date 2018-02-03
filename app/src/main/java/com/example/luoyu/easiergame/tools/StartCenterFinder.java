package com.example.luoyu.easiergame.tools;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;

import static com.example.luoyu.easiergame.tools.ComTool.getBlueFromInt;
import static com.example.luoyu.easiergame.tools.ComTool.getGreenFromInt;
import static com.example.luoyu.easiergame.tools.ComTool.getRedFromInt;

/**
 * 找小人的底盘中心点
 */
public class StartCenterFinder {

    static final int[] centers = new int[] { -13948087, -13948087, -13948087, -13948087, -13947830, -13882036,
            -13816755, -13816755, -13750960, -13750960, -13684910, -13684653, -13618603, -13553065, -13552808,
            -13487014, -13420964, -13420964, -13420964, -13420706, -13420192, -13354656, -13158303, -13158303,
            -13223582, -13157789, -13026973, -13026973, -13092509, -13157789, -13092509, -13026973, -13092510,
            -13158302, -13092766, -13026973, -13026973, -13026973, -13026973, -13026973, -13026973, -13092766,
            -13158303, -13158303, -13092510, -13092510, -13026973, -13092510, -13158303, -13026973, -13026973,
            -13092766, -13092510, -13026973, -13092766, -13158303, -13158303, -13092767, -13027489, -13027489,
            -13027489, -13027489, -13027489, -13027489, -13027490, -13027747, -13027749, -13027496, -13027496,
            -12961961, -12962219, -12962218, -12896682, -12830381, -12830381 };

    public static Point findStartCenter(Bitmap bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int centerX = 0;
        int centerY = 0;

        for (int h = 0; h < height; h++)
            for (int w = 0; w < width; w++) {
                int color = bufferedImage.getPixel(w, h);
                if (color == centers[0]) {
                    if (checkIsCenter(bufferedImage, h, w)) {
                        centerX = w + 38;
                        centerY = h;

                        return new Point(centerX, (centerY + 3));
                    }
                }
            }
        return new Point(0, -1);
    }

    private static boolean checkIsCenter(Bitmap bufferedImage, int h, int w) {
        for (int i = w; i < w + 75; i++) {
            int color = bufferedImage.getPixel(i, h);
//            Color centerColor = new Color(centers[i - w]);
//            Color newColor = new Color(color);
            if (Math.abs(getRedFromInt(color) - getRedFromInt(centers[i - w])) > 5
                    || Math.abs(getGreenFromInt(color) - getGreenFromInt(centers[i - w])) > 5
                    || Math.abs(getBlueFromInt(color) - getBlueFromInt(centers[i - w])) > 5) {
                return false;
            }
        }
        return true;
    }


}