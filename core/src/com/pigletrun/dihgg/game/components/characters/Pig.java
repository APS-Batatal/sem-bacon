package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;

import static com.pigletrun.dihgg.game.core.GLOBAL.bounds;
import static com.pigletrun.dihgg.game.core.GLOBAL.paused;

public class Pig extends Actor {

	private TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/characters/pig/Pig.pack"));
	private Sprite sprite = new Sprite(atlas.findRegion("p1"));
	private int frame = 1;

	public Pig() {
		sprite.setPosition(50, Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2);
		bounds = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

		Timer.schedule(new Timer.Task(){
						   @Override
						   public void run() {
							   frame++;
							   if (frame > 6)
								   frame = 1;
							   sprite.setRegion(atlas.findRegion("p" + frame));
						   }
					   }
				, 0, 5 / 30.0f);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		sprite.draw(batch);
	}

	public void move(float transition) {
		if (!paused) {
			if (sprite.getY() >= 100 && sprite.getY() <= Gdx.graphics.getHeight() - 100 - sprite.getHeight())
				sprite.translateY(transition);
			bounds.setPosition(sprite.getX(), sprite.getY());
		}
	}
}