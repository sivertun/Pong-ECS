package com.coolgame.pong.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerMovementComponent extends Component {
    // Index mapping: 0 = up, 1 = down, 2 = left, 3 = right
    private final ArrayList<Integer> keyMap;
    private final Vector2 velocity;
    private final float speed; // Movement speed for scaling velocity

    public PlayerMovementComponent(Vector2 init,float speed, HashMap<String, Integer> keymap) {
        this.velocity = init;
        this.speed = speed;
        this.keyMap = mapKeys(keymap);
    }

    /**
     * Maps movement keys from a HashMap to an ordered ArrayList.
     */
    private ArrayList<Integer> mapKeys(HashMap<String, Integer> keymap) {
        ArrayList<Integer> mappedKeys = new ArrayList<>();
        mappedKeys.add(keymap.getOrDefault("up", -1));    // Index 0
        mappedKeys.add(keymap.getOrDefault("down", -1));  // Index 1
        return mappedKeys;
    }

    public float getXVelocity() {
        return velocity.x;
    }

    public float getYVelocity() {
        return velocity.y;
    }

    public void setXVelocity(float x) {
        velocity.x = x;
    }

    public void setYVelocity(float y) {
        velocity.y = y;
    }

    public void reverseXVelocity() {
        velocity.x *= -1;
    }

    public void reverseYVelocity() {
        velocity.y *= -1;
    }

    @Override
    public void update() {
        // Here, you could apply velocity to an entity's position if needed
    }

    @Override
    public void render(SpriteBatch sb) {
        // No rendering logic needed for velocity
    }

    @Override
    public void onKeyPress(int keycode) {
        // Handle movement keys
        if (keycode == keyMap.get(0)) {
            velocity.y = speed; // Move up
        } else if (keycode == keyMap.get(1)) {
            velocity.y = -speed; // Move down
        }
    }

    @Override
    public void onKeyRelease(int keycode) {
        // Stop movement when key is released
        if (keycode == keyMap.get(0) || keycode == keyMap.get(1)) {
            velocity.y = 0; // Stop vertical movement
        }
    }
}
