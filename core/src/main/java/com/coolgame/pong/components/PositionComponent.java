package com.coolgame.pong.components;

import com.badlogic.gdx.math.Vector2;

public class PositionComponent implements Component{
    Vector2 position;

    public PositionComponent(float posX, float posY) {
        position = new Vector2(posX, posY);
    }

    public float getXPosition() {
        return position.x;
    }

    public float getYPosition() {
        return position.y;
    }

    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public void setXPosition(float x) {
        position.x = x;
    }

    public void setYPosition(float y) {
        position.y = y;
    }
}
