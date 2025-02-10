package com.coolgame.pong.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.HashMap;
import java.util.Map;

public class Entity {
    private Vector2 position;
    private Map<Class<? extends Component>, Component> components;

    public Entity(Vector2 position) {
        this.position = position;
        this.components = new HashMap<>();
    }

    public <T extends Component> void addComponent(T component) {
        components.put(component.getClass(), component);
        component.setEntity(this);
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        return componentClass.cast(components.get(componentClass));
    }

    public void keyDown(int keyCode){
        for (Component component : components.values()) {
            component.onKeyPress(keyCode);
        }
    }

    public void keyUp(int keyCode){
        for (Component component : components.values()) {
            component.onKeyRelease(keyCode);
        }
    }

    public void update() {
        for (Component component : components.values()) {
            component.update();
        }
    }

    public void render(SpriteBatch sb) {
        for (Component component : components.values()) {
            component.render(sb);
        }
    }

    public Vector2 getPosition() {
        return position;
    }
}
