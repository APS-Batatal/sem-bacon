package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Diego on 04/06/2017.
 */

public class PowerUp extends Actor {
	private Sprite sprite;
	private String type;

	public PowerUp(String file) {
		sprite = new Sprite(new Texture(Gdx.files.internal("images/characters/powerups/" + file + ".png")));
		this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
		sprite.setX(Gdx.graphics.getWidth() + 100);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		sprite.setX(sprite.getX() - 1f);
	}
}
