package org.htilssu.entities;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class EntityManager {
    private static final List<Entity> entities = new LinkedList<>();

    public static void update() {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public static void render(Graphics g) {
        for (Entity entity : entities) {
            entity.render(g);
        }
    }

    public static void addEntity(Entity entity) {
        entities.add(entity);
    }

    public static void removeEntity(Entity entity) {
        entities.remove(entity);
    }
}
