package com.coolgame.pong.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Component {
    protected Entity entity;
    public abstract void update();
    public abstract void render(SpriteBatch sb);
    public void setEntity(Entity entity){
        this.entity = entity;
    }
    public Entity getEntity(){
        return this.entity;
    }
}
