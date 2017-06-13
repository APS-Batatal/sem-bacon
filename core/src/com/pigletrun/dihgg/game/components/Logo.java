package com.pigletrun.dihgg.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Logo extends Actor {
	private Sprite sprite;

	public Logo(String image, Stage stage) {
		sprite = new Sprite(new Texture(Gdx.files.internal("images/logo/" + image)));
		sprite.setScale(2f);
		sprite.setPosition(stage.getWidth() / 2 - sprite.getWidth() / 2, stage.getHeight() / 2 - sprite.getHeight() / 2);
		this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
	}

	@Override
	public void draw(Batch batch, float alpha) {
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	public void setSprite(String image) {
		sprite.setTexture(new Texture(Gdx.files.internal("images/logo/" + image)));
		this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
	}
}