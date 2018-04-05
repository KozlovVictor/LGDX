package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
    final int NUMBER_OF_ASTEROIDS = 10;
    final float VELOSITY_RANGE = 100;
    final int ASTEROID_SIZE = 64;
    ArrayList<Asteroid> asteroids;
    SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        asteroids = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ASTEROIDS; i++) {
            asteroids.add(new Asteroid(MathUtils.random(0, Gdx.graphics.getWidth() - ASTEROID_SIZE),
                    MathUtils.random(0, Gdx.graphics.getHeight() - ASTEROID_SIZE), MathUtils.random(-VELOSITY_RANGE, VELOSITY_RANGE),
                    MathUtils.random(-VELOSITY_RANGE, VELOSITY_RANGE)));
        }
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (Asteroid index:asteroids) {
            index.update(dt);
            index.render(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
