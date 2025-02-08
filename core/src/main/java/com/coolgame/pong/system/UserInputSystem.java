package com.coolgame.pong.system;

import com.coolgame.pong.components.Entity;

import java.util.List;

public class UserInputSystem implements System {
    private static UserInputSystem instance;

    private UserInputSystem() {

    }

    public static UserInputSystem getInstance() {
        if (instance == null) {
            instance = new UserInputSystem();
        }
        return instance;
    }

    @Override
    public void update(List<Entity> entities) {

    }
}
