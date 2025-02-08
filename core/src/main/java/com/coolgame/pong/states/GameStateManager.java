package com.coolgame.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStateManager {
    State currentGameState;

    public void setGameState(State gameState) {
        if (gameState != null) {
            currentGameState = gameState;
        }
    }

    public void update(float dt) {
        currentGameState.update(dt);
    }

    public void render(SpriteBatch sb) {
        currentGameState.render(sb);
    }

    public void dispose() {
        currentGameState.dispose();
    }
}
