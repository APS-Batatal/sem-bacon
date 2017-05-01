package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.pigletrun.dihgg.game.components.Logo;

import java.util.ArrayList;


public class IntroScreen implements Screen {
	// VARIÁVEIS
	private Game game; // a variável game (importante para o sistema)
	private SpriteBatch batch; // o 'batch' de desenho
	private Stage stage; // a variável de 'stage'
	private String files[] = {"unicluster.png", "unip.png", "guaxinim.png", "game.png"}; // nomes dos arquivos de logo
	private Logo logo; // Classe de logo
	private float delay = 2f; // tempo de delay entre os logos

	public IntroScreen(final Game game) {
		this.game = game; // Atribuir a variavel de game
		batch = new SpriteBatch(); // iniciar o 'spritebatch'
		stage = new Stage(); // iniciar o 'stage'
		logo = new Logo(files[0]); // iniciar o logo 'com o primeiro logo'
		stage.addActor(logo); // Adicionar o ator 'logo' ao stage

		// Criar sequencia de ações
		ArrayList<Action> actions = new ArrayList<Action>();
		for (int i = 0; i < files.length; i++) {
			final int k = i;
			actions.add(new Action() {
				@Override
				public boolean act(float delta) {
					logo.setSprite(files[k]);
					return true;
				}
			});
			actions.add(Actions.delay(delay));
		}
		// Adicionar a ação final
		actions.add(new Action() {
			@Override
			public boolean act(float delta) {
				game.setScreen(new GameScreen(game));
				return true;
			}
		});
		// transformar em um array primitivo de actions
		Action[] _actions = new Action[actions.size()];
		for (int i = 0; i < actions.size(); i++) {
			_actions[i] = actions.get(i);
		}
		logo.addAction(Actions.sequence(_actions)); // adicionar a sequência de ações ao logo
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
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

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}
}
