package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    final float SCALE = 3;
    Texture texture;
    Vector2 position; // position.x position.y
    Vector2 velocity; // velocity.x velocity.y

    public Asteroid(float x, float y, float vx, float vy) {
        this.texture = new Texture("asteroid64.png");
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(vx, vy);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - texture.getWidth() / 2, position.y - texture.getHeight() / 2, 32, 32, 64, 64, SCALE, SCALE, 0, 0, 0, 64, 64, false, false);
    }

    public void update(float dt) {
        position.mulAdd(velocity, dt);
        if (position.y - texture.getHeight() < 0) {
            position.y = texture.getHeight();
            velocity.y *= -1;
        }
        if (position.y > Gdx.graphics.getHeight() - texture.getHeight() * SCALE / 2){
            position.y = Gdx.graphics.getHeight() - texture.getHeight() * SCALE / 2;
            velocity.y *= -1;
        }
        if (position.x >= Gdx.graphics.getWidth() + texture.getWidth()) position.x = 0;
        if (position.x + texture.getWidth() < 0) position.x = Gdx.graphics.getWidth();
        
        // float rnd = MathUtils.random(-100.0f, 100.0f);
        // float rnd = -100.0f + (float)Math.random() * 200.0f;
    }
}
