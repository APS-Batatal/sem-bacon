package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.pigletrun.dihgg.game.components.characters.Pig;
import com.sun.xml.internal.ws.dump.LoggingDumpTube;

/**
 * Created by Diego on 11/03/2017.
 */

public class GameScreen implements Screen,InputProcessor {
	Game g;

	private Pig pig;
	/*private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation animation;
	private Sprite sprite;
	private int currentFrame = 1;*/

	private Stage stage;
	public GameScreen(Game g) {
		this.create();
		this.g = g;
	}

	private void create() {
		stage = new Stage();
		pig = new Pig();
		stage.addActor(pig);
		/*batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("images/characters/pig/Pig.pack"));
		AtlasRegion region = textureAtlas.findRegion("p1");

		sprite = new Sprite(region);
		sprite.setPosition(120, 100);
		sprite.scale(2);

		Timer.schedule(new Timer.Task(){
			   @Override
			   public void run() {
				   currentFrame++;
				   if(currentFrame > 6)
					   currentFrame = 1;
				   //currentAtlasKey = String.format("%04d", currentFrame);
				   sprite.setRegion(textureAtlas.findRegion("p"+ currentFrame));
			   }
		   }
		,0,5/30.0f);*/
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		//Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		pig.moveY(1);
		/*batch.begin();
		sprite.draw(batch);
		batch.end();*/
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
		/*batch.dispose();
		textureAtlas.dispose();*/
		stage.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
