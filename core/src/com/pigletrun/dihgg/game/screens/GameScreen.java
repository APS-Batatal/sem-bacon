package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Diego on 11/03/2017.
 */

public class GameScreen implements Screen {
	Game g;

	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation animation;
	private Sprite sprite;
	private int currentFrame = 1;

	public GameScreen(Game g) {
		this.create();
		this.g = g;
	}

	private void create() {
		batch = new SpriteBatch();
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
		,0,5/30.0f);
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();
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
		textureAtlas.dispose();
	}
}
