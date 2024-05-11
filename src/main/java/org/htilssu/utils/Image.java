package org.htilssu.utils;

import org.jetbrains.annotations.NotNull;

import java.awt.image.BufferedImage;

public class Image {

    /**
     * Thay &#x111;&#x1ED5;i k&iacute;ch th&#x1B0;&#x1EDB;c &#x1EA3;nh
     *
     * @param originalImage &#x1EA3;nh g&#x1ED1;c
     * @param targetWidth   chi&#x1EC1;u r&#x1ED9;ng m&#x1EDB;i
     * @param targetHeight  chi&#x1EC1;u cao m&#x1EDB;i
     * @return &#x1EA3;nh m&#x1EDB;i v&#x1EDB;i k&iacute;ch th&#x1B0;&#x1EDB;c m&#x1EDB;i
     */
    @NotNull
    public static BufferedImage resizeImage(@NotNull BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    @NotNull
    public static BufferedImage resizeImage(@NotNull BufferedImage originalImage, double multiplier) {
        int targetWidth = (int) (originalImage.getWidth() * multiplier);
        int targetHeight = (int) (originalImage.getHeight() * multiplier);
        return resizeImage(originalImage, targetWidth, targetHeight);
    }

}
