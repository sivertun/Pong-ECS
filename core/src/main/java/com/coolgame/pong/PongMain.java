package com.coolgame.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.coolgame.pong.states.GameStateManager;
import com.coolgame.pong.states.MainMenuGameState;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class PongMain extends ApplicationAdapter {
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 720;
    public static final String TITLE = "COOL PONG";

    private SpriteBatch batch;
    private GameStateManager gameStateManager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gameStateManager = new GameStateManager();

        // Start with the Main Menu
        gameStateManager.setGameState(new MainMenuGameState(gameStateManager));
    }

    @Override
    public void render() {
        // Clear the screen
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // Update and render the current game state
        gameStateManager.update(Gdx.graphics.getDeltaTime());
        gameStateManager.render(batch);
    }

    @Override
    public void dispose() {
        gameStateManager.dispose();
        batch.dispose();
    }
}
