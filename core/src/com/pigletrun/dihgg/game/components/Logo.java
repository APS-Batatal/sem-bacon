package com.pigletrun.dihgg.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Logo extends Actor {
	private Texture texture;
	private Sprite sprite;

	public Logo(String image) {
		this.create(image);
	}

	private void create(String image) {
		texture = new Texture(Gdx.files.internal("images/logo/" + image));
		sprite = new Sprite(texture);
		sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2, Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2);
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
		this.create(image);
	}


}
