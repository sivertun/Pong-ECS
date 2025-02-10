package com.coolgame.pong.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.coolgame.pong.components.Component;
import com.coolgame.pong.components.Entity;

public class TextComponent extends Component {
    private static BitmapFont font = new BitmapFont(); // Shared font
    private String text;
    private float scale;

    public TextComponent(String text, float scale) {
        this.text = text;
        this.scale = scale;
        font.getData().setScale(scale);
        font.setColor(Color.WHITE);
    }

    @Override
    public void render(SpriteBatch sb) {
        Entity entity = getEntity();
        font.draw(sb, text, entity.getPosition().x, entity.getPosition().y);
    }

    @Override
    public void update() {

    }
}
