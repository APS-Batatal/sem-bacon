package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.utils.Timer;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by Diego on 12/03/2017.
 */

public class Pig extends Actor {
	private TextureAtlas atlas;
	private Animation animation;
	private Sprite sprite;
	private int frame = 1;

	public Pig() {
		atlas = new TextureAtlas(Gdx.files.internal("images/characters/pig/Pig.pack"));
		sprite = new Sprite(atlas.findRegion("p1"));
		Timer.schedule(new Timer.Task(){
			   @Override
			   public void run() {
				   frame++;
				   if(frame > 6)
					   frame = 1;
				   sprite.setRegion(atlas.findRegion("p"+ frame));
			   }
		   }
		,0,5/30.0f);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		sprite.draw(batch);
	}

	public void moveY(int value) {
		sprite.setPosition(sprite.getX(), sprite.getY() + value);
	}
}
