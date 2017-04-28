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


public class IntroScreen implements Screen {
	// VARIABLES
	private Game game; // the game controller variable
	private SpriteBatch batch; // the sprite batch
	private Stage stage; // stage class
	private String files[] = {"unicluster.png", "unip.png", "guaxinim.png", "game.png"}; // filename of logos
	private Logo logo; // logo class
	private float delay = 2f;

	public IntroScreen(final Game game) {
		this.game = game; // attr the logo
		batch = new SpriteBatch(); // init the sprite batch
		stage = new Stage(); // init the stage
		logo = new Logo(files[0]); // init the logo (with the first logo)
		stage.addActor(logo); // add actor to stage

		// Do actions in a sequence
		logo.addAction(Actions.sequence(
				// delay
				Actions.delay(delay),
				// change the logo
				new Action() {
					@Override
					public boolean act(float delta) {
						logo.setSprite(files[1]);
						return true;
					}
				},
				// delay
				Actions.delay(delay),
				// change the logo
				new Action() {
					@Override
					public boolean act(float delta) {
						logo.setSprite(files[2]);
						return true;
					}
				},
				// delay
				Actions.delay(delay),
				// change the logo
				new Action() {
					@Override
					public boolean act(float delta) {
						logo.setSprite(files[3]);
						return true;
					}
				},
				// delay
				Actions.delay(delay),
				// GOTO next screen
				new Action() {
					@Override
					public boolean act(float delta) {
						return true;
						/*game.setScreen(new GameScreen(game));
						return true;*/
					}
				}
		));
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
