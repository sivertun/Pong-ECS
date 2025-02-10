package com.coolgame.pong.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.coolgame.pong.components.Entity;

import java.util.List;



public class InputManager{
    private List<Entity> entities;
    public InputManager(List<Entity> entities) {
        this.entities = entities;
        setupInputHandler();
    }

    private void setupInputHandler() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                // Notify all relevant components of the key press
                for (Entity entity : entities) {
                    entity.keyDown(keycode);
                }
                return super.keyDown(keycode);
            }

            @Override
            public boolean keyUp(int keycode) {
                // Reset velocity when keys are released
                for (Entity entity : entities) {
                    entity.keyUp(keycode);}
                return super.keyDown(keycode);
            }
        });
    }
}
