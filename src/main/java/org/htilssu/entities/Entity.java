package org.htilssu.entities;

import java.awt.*;

public abstract class Entity extends AssetEntity {
    public double X;
    public double Y;
    /**
     * Sát thương mà {@link Entity} gây ra
     */
    public double damage;
    public EntityType type = EntityType.NONE;
    public double currentHealth;
    /**
     * Tốc độ di chuyển của {@link Entity}
     */
    public double speed = 1;
    public double maxHealth;

    Entity() {
        EntityManager.addEntity(this);
    }

    public Entity(double x, double y, double damage, EntityType type, double speed, double maxHealth) {
        X = x;
        Y = y;
        this.damage = damage;
        this.type = type;
        this.speed = speed;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        EntityManager.addEntity(this);
    }

    /**
     * Update các thông tin của entity dựa vào TPS
     */
    public abstract void update();


    /**
     * Render entity lên màn hình
     *
     * @param g đối tượng {@link Graphics} để vẽ
     */
    public abstract void render(Graphics g);

    public void remove() {
        EntityManager.removeEntity(this);
    }
}
