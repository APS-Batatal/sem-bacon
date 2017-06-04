package com.pigletrun.dihgg.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Image extends Actor {
	private Sprite sprite;

	public Image(String file) {
		sprite = new Sprite(new Texture(Gdx.files.internal("images/" + file)));
		this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		//batch.setProjectionMatrix(cam.combined); //Instrui o "batch" a usar a matriz combinada
		sprite.draw(batch);
		super.draw(batch, parentAlpha);
	}

	@Override
	public void setPosition(float x, float y) {
		sprite.setPosition(x, y);
		super.setPosition(x, y);
	}

	@Override
	public void setScale(float scaleXY) {
		sprite.setScale(scaleXY);
		super.setScale(scaleXY);
	}
}
