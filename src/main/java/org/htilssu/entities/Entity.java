package org.htilssu.entities;

import java.util.LinkedList;

public class Entity extends AssetEntity {
    private static final LinkedList<Entity> entities = new LinkedList<>();
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
        entities.add(this);
    }

    public static LinkedList<Entity> getAllEntities() {
        return entities;
    }

    public void update() {
    }
}
