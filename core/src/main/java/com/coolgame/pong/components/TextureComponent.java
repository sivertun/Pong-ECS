package com.coolgame.pong.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class TextureComponent extends Component {
    private final Texture texture;

    public TextureComponent(Texture texture) {
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }

    @Override
    public void update() {
        // No update logic needed for a texture
    }

    @Override
    public void render(SpriteBatch sb) {
        if (entity != null) {
            Vector2 position = entity.getPosition(); // Get position from Entity
            sb.draw(texture, position.x, position.y);
        }
    }

    @Override
    public void onKeyPress(int keycode) {
        // Texture component doesn't respond to input
    }

    @Override
    public void onKeyRelease(int keycode) {
        // Texture component doesn't respond to input
    }

    @Override
    public void dispose() {
        texture.dispose(); // Prevents memory leaks
    }
}
