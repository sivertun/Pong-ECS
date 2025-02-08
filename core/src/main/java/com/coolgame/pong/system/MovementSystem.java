package com.coolgame.pong.system;

import com.coolgame.pong.components.Entity;
import com.coolgame.pong.components.PositionComponent;
import com.coolgame.pong.components.VelocityComponent;

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
    public void update(List<Entity> entities, float deltaTime) {
        for (Entity entity : entities) {
            if (entity.hasComponent(PositionComponent.class) && entity.hasComponent(VelocityComponent.class)) {
                PositionComponent positionComponent = (PositionComponent) entity.getComponent(PositionComponent.class);
                VelocityComponent velocityComponent = (VelocityComponent) entity.getComponent(VelocityComponent.class);

                positionComponent.setXPosition(velocityComponent.getXVelocity() * deltaTime);
                positionComponent.setYPosition(velocityComponent.getYVelocity() * deltaTime);
            }
        }
    }
}
