package org.htilssu.entities;

import org.htilssu.utils.Assets;

import java.awt.image.BufferedImage;

public class AssetEntity {

    public byte loopCycle = 7;
    public BufferedImage asset;
    public float assetIndex = 0;
    public short widthOffset = 64;
    public short heightOffset = 64;

    public BufferedImage getSubAsset() {
        BufferedImage subAsset = asset.getSubimage(widthOffset * (int) (assetIndex / loopCycle), 0, widthOffset, heightOffset);
        assetIndex = (assetIndex + 1) % ((float) asset.getWidth() * loopCycle / widthOffset);
        return subAsset;
    }

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
