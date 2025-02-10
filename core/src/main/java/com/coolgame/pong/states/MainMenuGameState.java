package com.coolgame.pong.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.coolgame.pong.components.TextComponent;
import com.coolgame.pong.components.Entity;
import com.coolgame.pong.system.EntityManager;

public class MainMenuGameState extends State {
    private final GameStateManager gsm;
    private EntityManager entityManager;
    private Entity titleEntity;
    private Entity playTextEntity;
    private Entity exitTextEntity;

    public MainMenuGameState(GameStateManager gameStateManager) {
        super(gameStateManager);
        entityManager = new EntityManager();
        this.gsm=gameStateManager;

        // Create title entity
        titleEntity = new Entity(new Vector2(600, 500));
        titleEntity.addComponent(new TextComponent("COOL PONG", 4));
        entityManager.addEntity(titleEntity);

        // Create play option entity
        playTextEntity = new Entity(new Vector2(700, 350));
        playTextEntity.addComponent(new TextComponent("Press ENTER to Play", 2));
        entityManager.addEntity(playTextEntity);

        // Create exit option entity
        exitTextEntity = new Entity(new Vector2(720, 300));
        exitTextEntity.addComponent(new TextComponent("Press ESC to Exit", 2));
        entityManager.addEntity(exitTextEntity);
    }

    @Override
    public void update(float dt) {
        // If player presses Enter, switch to MainGameState
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER)) {
            gsm.setGameState(new MainGameState(gsm));
        }
        // If player presses ESC, exit game
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        entityManager.render(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        entityManager.dispose();
    }
}
