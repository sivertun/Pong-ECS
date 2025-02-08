package com.coolgame.pong.system;

import com.coolgame.pong.components.Entity;

import java.util.List;

public class MovementSystem implements System{
    private static MovementSystem instance;

    private MovementSystem() {

    }

    public static MovementSystem getInstance() {
        if (instance == null) {
            instance = new MovementSystem();
        }
        return instance;
    }

    @Override
    public void update(List<Entity> entities) {

    }
}
