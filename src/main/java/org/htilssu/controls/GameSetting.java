package org.htilssu.controls;

import java.awt.*;

public final class GameSetting {
    private static final int TILE_SIZE_ORIGIN = 64;
    public static short FPS = 60;
    public static short TPS = 90;
    public static float soundVolume = 0.5f;
    public static float moveDistance = 200;
    public static double SCALE = 2;
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static int TILE_SIZE_SCALE = (int) (TILE_SIZE_ORIGIN * SCALE);
}
