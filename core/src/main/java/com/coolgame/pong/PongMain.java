package com.coolgame.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.coolgame.pong.states.GameStateManager;
import com.coolgame.pong.states.MainGameState;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class PongMain extends ApplicationAdapter {
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 720;
    public static final String TITLE = "COOL PONG";
    private GameStateManager gameStateManager;


    @Override
    public void create() {
        gameStateManager = new GameStateManager();
        gameStateManager.setGameState(new MainGameState(gameStateManager));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        gameStateManager.update(Gdx.graphics.getDeltaTime());
        gameStateManager.render(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
        gameStateManager.dispose();
    }
}
