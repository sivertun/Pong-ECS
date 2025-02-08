package com.coolgame.pong.system;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.coolgame.pong.components.Entity;
import com.coolgame.pong.components.PositionComponent;
import com.coolgame.pong.components.TextureComponent;

import java.util.List;

public class RenderSystem implements System{
    private static RenderSystem instance;
    private static SpriteBatch sb;

    private RenderSystem() {
        sb = new SpriteBatch();
    }

    public static RenderSystem getInstance() {
        if (instance == null) {
            instance = new RenderSystem();
        }
        return instance;
    }

    @Override
    public void update(List<Entity> entities, float dt) {
        for (Entity entity : entities) {
            if (entity.hasComponent(PositionComponent.class)) {
                PositionComponent positionComponent = (PositionComponent) entity.getComponent(PositionComponent.class);
                if (entity.hasComponent(TextureComponent.class)) {
                    sb.draw(((TextureComponent) entity.getComponent(TextureComponent.class)).getTexture(), positionComponent.getXPosition(), positionComponent.getYPosition());
                }
            }
        }
    }
}
