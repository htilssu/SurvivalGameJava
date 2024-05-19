package org.htilssu.entities;

public class Camera {
    public float x;
    public float y;
    public float width;
    public float height;
    Player player;

    public Camera(Player player) {
        this.player = player;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
