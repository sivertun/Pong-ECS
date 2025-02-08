package com.coolgame.pong.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.coolgame.pong.PongMain;
import com.coolgame.pong.sprites.Ball;
import com.coolgame.pong.sprites.PlayerPlatform;

public class MainGameState extends State {
    private final Ball ball;
    private final PlayerPlatform player1Platform;
    private final PlayerPlatform player2Platform;
    private final BitmapFont p1ScoreText = new BitmapFont();
    private final BitmapFont p2ScoreText = new BitmapFont();
    private int p1Score = 0;
    private int p2Score = 0;

    public MainGameState(GameStateManager gameStateManager) {
        super(gameStateManager);
        camera.setToOrtho(false, PongMain.WIDTH, PongMain.HEIGHT);
        player1Platform = new PlayerPlatform(camera, new Vector2(20, camera.viewportHeight/2 - PlayerPlatform.platformTexture.getHeight()/2));
        player2Platform = new PlayerPlatform(camera, new Vector2(camera.viewportWidth - PlayerPlatform.platformTexture.getWidth() - 20, camera.viewportHeight/2 - PlayerPlatform.platformTexture.getHeight()/2));
        ball = new Ball(camera, player2Platform, player2Platform);
        setupInputHandler();

        p1ScoreText.getData().setScale(5f);
        p2ScoreText.getData().setScale(5f);
    }

    private boolean touchForPlayer1(int screenX){
        return screenX < camera.viewportWidth/2;
    }

    private void checkForPoints(Ball ball) {
        String result = ball.checkOutOfBounds();
        if (result == null) {
            return;
        } else if (result.equals("Player2Point")) {
            p2Score++;
        } else if (result.equals("Player1Point")) {
            p1Score++;
        }
    }


    @Override
    public void update(float dt) {
        ball.update(dt);
        player1Platform.update(dt);
        player2Platform.update(dt);
        checkForPoints(ball);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(ball.getBallTexture(), ball.getBallPosX(), ball.getBallPosY());
        sb.draw(player1Platform.getTexture(), player1Platform.getPositionX(), player1Platform.getPositionY());
        sb.draw(player2Platform.getTexture(), player2Platform.getPositionX(), player2Platform.getPositionY());

        p1ScoreText.draw(sb, String.valueOf(p1Score), camera.viewportWidth/2 - 90, camera.viewportHeight - p1ScoreText.getScaleY());
        p2ScoreText.draw(sb, String.valueOf(p2Score), camera.viewportWidth/2 + 90, camera.viewportHeight - p2ScoreText.getScaleY());
        sb.end();
    }

    @Override
    public void dispose() {

    }

    private void setupInputHandler() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.W) {
                    player1Platform.handleInput(camera.viewportHeight);
                } else if(keycode == Input.Keys.S) {
                    player1Platform.handleInput(0f);
                } else if(keycode == Input.Keys.UP) {
                    player2Platform.handleInput(camera.viewportHeight);
                } else if(keycode == Input.Keys.DOWN) {
                    player2Platform.handleInput(0f);
                }
                return super.keyDown(keycode);
            }

            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.W || keycode == Input.Keys.S) {
                    if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                        player1Platform.handleInput(camera.viewportHeight);
                    } else if(Gdx.input.isKeyPressed(Input.Keys.S)){
                        player1Platform.handleInput(0f);
                    } else {
                        player1Platform.handleInput(null);
                    }
                } else if (keycode == Input.Keys.UP || keycode == Input.Keys.DOWN) {
                    if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                        player2Platform.handleInput(camera.viewportHeight);
                    } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                        player2Platform.handleInput(0f);
                    } else {
                        player2Platform.handleInput(null);
                    }
                }
                return super.keyUp(keycode);
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                Vector3 touch = new Vector3(screenX, screenY, 0);
                camera.unproject(touch);

                if (touch.x < camera.viewportWidth/2) {
                    player1Platform.handleInput(null);
                } else {
                    player2Platform.handleInput(null);
                }
                return super.touchCancelled(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                Vector3 touch = new Vector3(screenX, screenY, 0);
                camera.unproject(touch);

                if (touch.x < camera.viewportWidth/2) {
                    player1Platform.handleInput(touch.y);
                } else {
                    player2Platform.handleInput(touch.y);
                }
                return super.touchDragged(screenX, screenY, pointer);
            }
        });
    }
}
