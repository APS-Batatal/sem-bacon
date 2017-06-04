package com.pigletrun.dihgg.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Logo extends Actor {
	private Sprite sprite;

	public Logo(String image) {
		sprite = new Sprite(new Texture(Gdx.files.internal("images/logo/" + image)));
		sprite.setScale(2f);
		//sprite.setPosition(cam.viewportWidth / 2 - sprite.getWidth() / 2, cam.viewportHeight / 2 - sprite.getHeight() / 2);
		sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2, Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		//batch.setProjectionMatrix(cam.combined); //Instrui o "batch" a usar a matriz combinada
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	public void setSprite(String image) {
		sprite.setTexture(new Texture(Gdx.files.internal("images/logo/" + image)));
	}

}