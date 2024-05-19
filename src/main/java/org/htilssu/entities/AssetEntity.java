package org.htilssu.entities;

import org.htilssu.utils.Assets;

import java.awt.image.BufferedImage;

public class AssetEntity {

    public byte loopCycle = 2;
    public BufferedImage asset;
    public float assetIndex = 0;
    public short widthOffset = 64;
    public short heightOffset = 64;

    public BufferedImage getSubAsset() {
        BufferedImage subAsset = asset.getSubimage(widthOffset * (int) (assetIndex / loopCycle), 0, widthOffset, heightOffset);
        assetIndex = (assetIndex + 1) % ((float) asset.getWidth() * loopCycle / widthOffset);
        return subAsset;
    }

    /**
     * Set l&#x1EA1;i offset &#x111;&#x1EC3; l&#x1EA5;y subAsset
     *
     * @param widthOffset  chi&#x1EC1;u r&#x1ED9;ng c&#x1EE7;a subAsset
     * @param heightOffset chi&#x1EC1;u cao c&#x1EE7;a subAsset
     */
    public void setOffset(short widthOffset, short heightOffset) {
        this.widthOffset = widthOffset;
        this.heightOffset = heightOffset;
    }

    /**
     * Load asset from path
     *
     * @param path path to asset
     */
    public void loadAsset(String path) {
        asset = Assets.loadImage(path);
    }
}
