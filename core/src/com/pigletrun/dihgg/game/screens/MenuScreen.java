package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;


public class MenuScreen implements Screen {
	private Skin skin;
	private Stage stage;
	private SpriteBatch batch;
	private Game g;

	public MenuScreen(Game g) {
		this.create();
		this.g = g;
	}

	private void create() {
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		skin = new Skin();

		Pixmap pixmap = new Pixmap(100,100, Pixmap.Format.RGBA8888);
		pixmap.setColor(Color.GREEN);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));

		BitmapFont font = new BitmapFont();
		skin.add("default", font);

		TextButton.TextButtonStyle textBtnStyle = new TextButton.TextButtonStyle();
		textBtnStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textBtnStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textBtnStyle.checked = skin.newDrawable("white", Color.BLUE);
		textBtnStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textBtnStyle.font = skin.getFont("default");

		final TextButton textButton=new TextButton("PLAY",textBtnStyle);
		textButton.setPosition(Gdx.graphics.getWidth()/2 - textButton.getWidth()/2, Gdx.graphics.getHeight()/2 - textButton.getHeight()/2);

		textButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				textButton.setText("Starting...");
			}
		});

		stage.addActor(textButton);
		stage.addActor(textButton);
		stage.addActor(textButton);


	}
	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		//stage.setViewport(stage.getViewport().update(width,height));
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
		stage.dispose();
		skin.dispose();
	}
}
