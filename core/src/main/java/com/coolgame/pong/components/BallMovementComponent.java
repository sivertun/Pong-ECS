package com.coolgame.pong.components;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BallMovementComponent extends Component {
    private Vector2 velocity;
    private float speed; // Movement speed for scaling velocity

    public BallMovementComponent(Vector2 init, float speed) {
        this.velocity = init;
        this.speed = speed;
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

    }

    @Override
    public void onKeyRelease(int keycode) {

    }
}
