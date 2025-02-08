package com.coolgame.pong.system;

import com.coolgame.pong.components.Entity;
import com.coolgame.pong.components.PositionComponent;

import java.util.List;

public class RenderSystem implements System{
    private static RenderSystem instance;

    private RenderSystem() {

    }

    public static RenderSystem getInstance() {
        if (instance == null) {
            instance = new RenderSystem();
        }
        return instance;
    }

    @Override
    public void update(List<Entity> entities) {
        for (Entity entity : entities) {
            if (entity.hasComponent(PositionComponent.class) && entity.hasComponent())
        }
    }
}
