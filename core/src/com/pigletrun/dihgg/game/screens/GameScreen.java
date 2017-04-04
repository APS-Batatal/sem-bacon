package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pigletrun.dihgg.game.components.characters.Pig;

class GameScreen implements Screen {
	private Game game; // Required
	// VARIABLES
	private Pig pig;
	private Stage stage;

	GameScreen(Game game) {
		this.game = game;
		this.create();
	}

	private void create() {
		stage = new Stage(); // create new stage
		pig = new Pig(); // create new pig actor
		Gdx.input.setInputProcessor(stage); // set the input processor to stage

		stage.addActor(pig); // add the pig to stage

		// LISTENERS
		stage.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				pig.setPosition(x, y);
				return true;
			}
		});
	}

	@Override
	public void show() {}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		stage.dispose();
	}
}
