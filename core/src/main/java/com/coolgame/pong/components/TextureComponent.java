package com.coolgame.pong.components;

import com.badlogic.gdx.graphics.Texture;

public class TextureComponent implements Component {
    private Texture texture;

    public TextureComponent(Texture texture) {
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }
}
