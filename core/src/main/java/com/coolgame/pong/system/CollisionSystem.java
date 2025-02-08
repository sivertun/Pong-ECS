package com.coolgame.pong.system;

import com.coolgame.pong.components.Entity;

import java.util.List;

public class CollisionSystem implements System{
    private static CollisionSystem instance;

    private CollisionSystem() {

    }

    public static CollisionSystem getInstance() {
        if (instance == null) {
            instance = new CollisionSystem();
        }
        return instance;
    }

    @Override
    public void update(List<Entity> entities, float deltaTime) {

    }
}
