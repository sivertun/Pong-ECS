package com.coolgame.pong.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class VelocityComponent extends Component{
    Vector2 velocity;

    public VelocityComponent(float velX, float velY) {
        velocity = new Vector2(velX, velY);
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

    }

    @Override
    public void render(SpriteBatch sb) {

    }
}
