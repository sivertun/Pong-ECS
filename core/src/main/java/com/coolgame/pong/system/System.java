package com.coolgame.pong.system;

import com.coolgame.pong.components.Entity;

import java.util.List;

public interface System {
    public void update(List<Entity> entities, float deltaTime);
}
