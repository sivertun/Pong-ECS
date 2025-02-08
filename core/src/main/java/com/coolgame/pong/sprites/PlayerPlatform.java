package com.coolgame.pong.sprites;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PlayerPlatform {
    public static final Texture platformTexture = new Texture("platform.png");
    private final Vector2 position;
    private final float speed = 200f;
    private final OrthographicCamera camera;
    private float targetYPosition;
    private Rectangle bounds;

    public PlayerPlatform(OrthographicCamera camera, Vector2 position) {
        this.camera = camera;
        this.position = position;
        this.targetYPosition = position.y;
        bounds = new Rectangle(position.x, position.y, platformTexture.getWidth(), platformTexture.getHeight());
    }

    public void handleInput(Float yPos) {
        if (yPos == null) {
            targetYPosition = position.y;
        } else {
            targetYPosition = yPos;
        }
    }

    public void update(float dt) {
        // Don't understand why I need this, but I do if I am testing on desktop in android studio. Cause this method will be called with dt = 0.0 once on startup
        if (dt == 0.0f) {
            return;
        }
        float distanceLeft = targetYPosition - position.y;
        if (Math.abs(distanceLeft) < speed*dt) {
            position.y = targetYPosition;
        } else {
            if (distanceLeft > 0) {
                position.y += speed*dt;
            } else {
                position.y += speed*dt*-1;
            }
        }
        collideFloorCeil();
        bounds.setPosition(position.x, position.y - platformTexture.getHeight()/2);
    }

    private void collideFloorCeil() {
        if (position.y < 0 + platformTexture.getHeight()/2) {
            position.y = platformTexture.getHeight()/2;
        } else if(position.y > camera.viewportHeight - platformTexture.getHeight()/2) {
            position.y = camera.viewportHeight - platformTexture.getHeight()/2;
        }
    }

    public Texture getTexture() {
        return platformTexture;
    }

    public float getPositionX() {
        return position.x;
    }

    public float getPositionY() {
        return position.y - platformTexture.getHeight()/2;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
