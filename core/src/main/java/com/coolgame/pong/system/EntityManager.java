package com.coolgame.pong.system;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.coolgame.pong.components.Entity;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void update(float dt) {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public void render(SpriteBatch sb) {
        for (Entity entity : entities) {
            entity.render(sb);
        }
    }

    public void dispose() {
        entities.clear();
    }
}
