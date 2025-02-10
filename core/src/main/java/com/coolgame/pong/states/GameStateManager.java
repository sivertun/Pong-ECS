package com.coolgame.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.coolgame.pong.components.Entity;
import com.coolgame.pong.system.EntityManager;

public class GameStateManager {
    State currentGameState;
    private EntityManager entityManager;

    public GameStateManager(){
        this.entityManager = new EntityManager();
    }

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

    public void addEntity(Entity entity)
    {
        entityManager.addEntity(entity);
    }}
