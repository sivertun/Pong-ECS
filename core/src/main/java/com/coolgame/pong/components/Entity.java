package com.coolgame.pong.components;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    private final int uid;
    private static int nextUid = 1;
    private final Map<Class<? extends Component>, Component> components;

    public Entity() {
        components = new HashMap<>();
        uid = nextUid;
        nextUid++;
    }

    public int getUid() {
        return uid;
    }

    public boolean hasComponent(Class<? extends Component> componentClass) {
        return components.containsKey(componentClass);
    }

    public void addComponent(Component component) {
        components.put(component.getClass(), component);
    }

    public Component getComponent(Class<? extends Component> componentClass) {
        return components.get(componentClass);
    }

    public void removeComponent(Class<? extends Component> componentClass) {
        components.remove(componentClass);
    }
}
