package com.pigletrun.dihgg.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BaseScreen implements Screen {
	// Variáveis

	protected Game game; // a variável game (importante para o sistema)
	protected Stage stage; // a variável de 'stage'
	private SpriteBatch batch; // o 'batch' de desenho

	public BaseScreen(final Game game) {
		// TODO: Não tem nada mais simples do que isso não?
		//cam.setToOrtho(false, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2); // Seta a câmera para projeção ortográfica
		this.game = game; // Atribuir a variavel de game
		batch = new SpriteBatch(); // iniciar o 'spritebatch'
		stage = new Stage(); // iniciar o 'stage'
		Gdx.input.setInputProcessor(stage); // Settar o input processor ao stage
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {
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