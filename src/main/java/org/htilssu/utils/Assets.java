package org.htilssu.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Assets {

    private static final String url = Path.getResourcePath() + "/assets";

    /**
     * Return a {@link BufferedImage} that encoded asset content, asset content must in assets folder {@code "/resource/assets"}
     *
     * @param assetUrl must  start with '/'
     * @return a {@code BufferedImage} object contain decoded content of asset or {@code null}
     */
    public static BufferedImage loadImage(String assetUrl) {
        assetUrl = handleAssetUrl(assetUrl);
        //load asset by IO
        /*try {
            return ImageIO.read(new File(url + assetUrl));
        } catch (IOException e) {
            return null;
        }*/

        try {
            InputStream ip = Assets.class.getResourceAsStream("/assets" + assetUrl);
            if (ip != null) return ImageIO.read(ip);
        } catch (IOException e) {
            return null;
        }

        return null;
    }

    /**
     * X&#x1EED; l&yacute; assetUrl truy&#x1EC1;n v&agrave;o, assetUrl ph&#x1EA3;i b&#x1EAF;t &#x111;&#x1EA7;u b&#x1EB1;ng '/'
     * <p>
     * N&#x1EBF;u {@code assetUrl} kh&ocirc;ng b&#x1EAF;t &#x111;&#x1EA7;u b&#x1EB1;ng '/' th&igrave;
     * th&ecirc;m v&agrave;o &#x111;&#x1EA7;u
     */
    private static String handleAssetUrl(String assetUrl) {
        if (!assetUrl.startsWith("/")) {
            assetUrl = "/" + assetUrl;
        }
        return assetUrl;
    }
}
