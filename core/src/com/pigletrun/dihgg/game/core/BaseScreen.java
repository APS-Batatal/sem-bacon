package com.pigletrun.dihgg.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class BaseScreen implements Screen {
	// Variáveis

	protected Game game; // a variável game (importante para o sistema)
	protected Stage stage; // a variável de 'stage'
    protected SpriteBatch batch; // o 'batch' de desenho

	public BaseScreen(final Game game) {
		this.game = game; // Atribuir a variavel de game
		this.batch = new SpriteBatch(); // iniciar o 'spritebatch'
		//this.stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight())); // iniciar o 'stage'
		this.stage = new Stage(new FitViewport(1280, 720)); // iniciar o 'stage
		Gdx.input.setInputProcessor(stage); // Settar o input processor ao stage
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.stage.act(Gdx.graphics.getDeltaTime());
		this.stage.draw();
	}

	@Override
	public void dispose() {
		this.batch.dispose();
		this.stage.dispose();
	}

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);
	}

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }
}