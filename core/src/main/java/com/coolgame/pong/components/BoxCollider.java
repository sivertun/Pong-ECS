package com.coolgame.pong.components;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BoxCollider implements Component{
    Rectangle boundingBox;

    public BoxCollider(int sizeX, int sizeY) {
        boundingBox = new Rectangle(0, 0, sizeX, sizeY);
    }

    public void setPosition(int x, int y) {
        boundingBox.setPosition(x, y);
    }

    public boolean collidesWith(Rectangle collider) {
        return collider.overlaps(boundingBox);
    }
}
