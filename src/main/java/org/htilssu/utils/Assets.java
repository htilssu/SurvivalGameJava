package org.htilssu.utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Assets {

    private static final String url = Path.getResourcePath() + "/assets";
    private static final HashMap<String, BufferedImage> images = new HashMap<>();

    /**
     * Return a {@link BufferedImage} that encoded asset content, asset content must in assets folder {@code "/resource/assets"}
     *
     * @param assetUrl must  start with '/'
     * @return a {@code BufferedImage} object contain decoded content of asset or {@code null}
     */
    public static BufferedImage loadImage(String assetUrl) {
        assetUrl = handleAssetUrl(assetUrl);
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

    /**
     * Load âm thanh từ file âm thanh được chỉ định, file âm thanh phải nằm trong thư mục {@code "/resource/assets"}
     *
     * @param assetUrl phải bắt đầu bằng '/'
     */
    public static AudioInputStream loadAudio(String assetUrl) {
        try {
            InputStream ip = getInputStream(assetUrl);

            return AudioSystem.getAudioInputStream(ip);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.fillInStackTrace();
            return null;
        }
    }

    /**
     * Lấy {@code InputStream} của asset, asset phải nằm trong thư mục {@code "/resource/assets"}
     *
     * @param assetUrl phải bắt đầu bằng '/'
     * @return {@code InputStream} của asset hoặc {@code null}
     */
    private static InputStream getInputStream(String assetUrl) {
        assetUrl = handleAssetUrl(assetUrl);
        return Assets.class.getResourceAsStream("/assets" + assetUrl);
    }

    public static BufferedImage getAsset(String assetName) {
        return images.get(assetName);
    }

    public static void loadAssets() {
        images.put("player", loadImage("/player.png"));
        images.put("background", loadImage("/background.png"));
        images.put("bullet", loadImage("/bullet.png"));
        images.put("enemy", loadImage("/enemy.png"));
        images.put("explosion", loadImage("/explosion.png"));
    }
}
