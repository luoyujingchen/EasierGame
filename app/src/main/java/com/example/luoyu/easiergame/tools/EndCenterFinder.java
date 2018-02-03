package com.example.luoyu.easiergame.tools;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;

import java.io.File;
import java.io.IOException;

import static com.example.luoyu.easiergame.tools.ComTool.getBlueFromInt;
import static com.example.luoyu.easiergame.tools.ComTool.getGreenFromInt;
import static com.example.luoyu.easiergame.tools.ComTool.getRedFromInt;


/**
 * 找白点,也就是连跳的中心点
 */
public class EndCenterFinder {

    // 设定中心点的颜色
    static final int red = 0xfa;
    static final int green = 0xfa;
    static final int blue = 0xfa;

    static float scaleX = 1;

    public static Point findEndCenter(Bitmap bufferedImage, Point startCenterPoint) {
        int width = bufferedImage.getWidth();
        int centerX = 0;
        int centerY = 0;
        int height = bufferedImage.getHeight() * 2 / 3;
        for (int h = 200; h < height && h < startCenterPoint.y; h++) {
            for (int w = 0; w < width; w++) {
                int color = bufferedImage.getPixel(w, h);
//                Color newColor = new Color(color);
                if (Math.abs(getRedFromInt(color) - red) <= 5 && Math.abs(getGreenFromInt(color) - green) <= 5
                        && Math.abs(getBlueFromInt(color) - blue) <= 5) {

                    Point endCenter = findWhiteCenter(bufferedImage, w, h, startCenterPoint);
                    if (endCenter == null) {
                        return null;
                    }
                    if (startCenterPoint.x > bufferedImage.getWidth() / 2) {// 在右边,所以如果找到的点也在右边就丢掉
                        if (endCenter.x > startCenterPoint.x) {
                            return new Point(0, -1);
                        }
                    } else if (startCenterPoint.x < bufferedImage.getWidth() / 2) {
                        if (endCenter.x < startCenterPoint.x) {
                            return new Point(0, -1);
                        }
                    }
                    return endCenter;
                }
            }
        }
        return new Point((int) (centerX * scaleX), (int) ((centerY - 1)));
    }

    static Point findWhiteCenter(Bitmap bufferedImage, int x, int y, Point startCenterPoint) {
        int minX = x, minY = y, maxX = x, maxY = y;
        for (int w = x; w < bufferedImage.getWidth(); w++) {
            int color = bufferedImage.getPixel(w, y);
//            Color newColor = new Color(color);
            if (Math.abs(getRedFromInt(color) - red) <= 5 && Math.abs(getGreenFromInt(color) - green) <= 5
                    && Math.abs(getBlueFromInt(color) - blue) <= 5) {
                maxX = x + (w - x) / 2;
            } else {
                break;
            }
        }

        for (int h = y; h < startCenterPoint.y; h++) {
            int color = bufferedImage.getPixel(x, h);
//            Color newColor = new Color(color);
            if (Math.abs(getRedFromInt(color) - red) <= 5 && Math.abs(getGreenFromInt(color) - green) <= 5
                    && Math.abs(getBlueFromInt(color) - blue) <= 5) {
                maxY = h;
            }
        }
        int centerY = minY + (maxY - minY) / 2;
        if (maxY - minY < 18) {
            return null;
        }
        return new Point((int) (maxX * scaleX), (int) ((centerY)));
    }

    public static void main(String[] args) throws IOException {

//        Bitmap bufferedImage = ImageIO.read(new File("/Users/tangshuai/Desktop/tmp/665_908.png"));
//        Point point = StartCenterFinder.findStartCenter(bufferedImage);
//        System.out.println(point);
//
//        Point point2 = findEndCenter(bufferedImage, point);
//        System.out.println(point2);

    }
}