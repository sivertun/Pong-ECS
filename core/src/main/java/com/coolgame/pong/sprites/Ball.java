package com.coolgame.pong.sprites;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Ball {
    private static final Texture ballTexture = new Texture("ball.png");
    private Vector2 position;
    private Vector2 velocity;
    private Random random = new Random();
    private final Vector2 startingVelocity;
    private final Vector2 startingPosition;
    private final OrthographicCamera camera;
    private final PlayerPlatform player1Platform;
    private final PlayerPlatform player2Platform;
    private final Rectangle ballBounds;

    public Ball(OrthographicCamera camera, PlayerPlatform player1Platform, PlayerPlatform player2Platform) {
        this.camera = camera;
        startingPosition = new Vector2(camera.viewportWidth/2, camera.viewportHeight/2);
        startingVelocity = new Vector2(100f,100f);


        position = new Vector2(startingPosition);
        velocity = new Vector2(startingVelocity);

        ballBounds = new Rectangle(position.x, position.y, ballTexture.getWidth(), ballTexture.getHeight());

        this.player1Platform = player1Platform;
        this.player2Platform = player2Platform;
    }

    public void update(float dt) {
        // Don't understand why I need this, but I do if I am testing on desktop in android studio. Cause this method will be called with dt = 0.0 once on startup
        if (dt == 0.0f) {
            return;
        }
        if (velocity.x > 0) {
            velocity.x = velocity.x + 80*dt;
        } else {
            velocity.x = velocity.x - 80*dt;
        }

        if (velocity.y > 0) {
            velocity.y = velocity.y + 5*dt;
        } else {
            velocity.y = velocity.y - 5*dt;
        }


        velocity.scl(dt);
        position.add(velocity);
        velocity.scl(1/dt);
        collideFloorCeil();
        collidePlatforms();
        ballBounds.setPosition(position);
    }

    private void collideFloorCeil() {
        if (position.y < 0) {
            velocity.y = velocity.y * -1;
            position.y = 0;
        } else if(position.y > camera.viewportHeight - ballTexture.getHeight()) {
            velocity.y = velocity.y * -1;
            position.y = camera.viewportHeight - ballTexture.getHeight();
        }
    }

    private void collidePlatforms() {
        System.out.println(player2Platform.getBounds());
        if (player1Platform.getBounds().overlaps(ballBounds) || player2Platform.getBounds().overlaps(ballBounds)) {
            velocity.x = velocity.x * -1;
            if (velocity.x < 0) {
                position = position.add(velocity.x/15,velocity.y/15);
            } else {
                position = position.sub(velocity.x/15,velocity.y/15);
            }
        }
    }

    public String checkOutOfBounds() {
        if (position.x + ballTexture.getWidth() < 0) {
            velocity = new Vector2(startingVelocity);
            position = new Vector2(startingPosition);

            return "Player2Point";
        }
        if (position.x > camera.viewportWidth) {
            velocity = new Vector2(startingVelocity);
            position = new Vector2(startingPosition);
            System.out.println("Start:" + startingPosition);
            System.out.println(position);
            return "Player1Point";
        } else {
            return null;
        }
    }

    public Texture getBallTexture() {
        return ballTexture;
    }

    public float getBallPosX() {
        return position.x;
    }

    public float getBallPosY() {
        return position.y;
    }

    public void bounceX() {
        velocity.x = velocity.x * -1;
    }
}
