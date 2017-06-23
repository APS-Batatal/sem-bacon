package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.pigletrun.dihgg.game.components.ui.Hud;

import static com.pigletrun.dihgg.game.core.GLOBAL.gamePaused;

public class Pig extends Actor {
	static Rectangle bounds; // pig bounds

	private TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/characters/pig/Pig.pack"));
	private Sprite sprite = new Sprite(atlas.findRegion("Pig1"));
	private int frame = 1;
	private Stage stage;

	public Pig(Stage stage) {
		this.stage = stage;
		sprite.setPosition(50, stage.getHeight() / 2 - sprite.getHeight() / 2 - 80);
		bounds = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight() - 25);

		Timer.schedule(new Timer.Task(){
						   @Override
						   public void run() {
							   frame++;
							   if (frame > 6)
								   frame = 1;
							   sprite.setRegion(atlas.findRegion("Pig" + frame));
						   }
					   }
				, 0, 5 / 30.0f);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		sprite.draw(batch);
	}

	public void move(float transition) {
        if (!gamePaused) {

			if (sprite.getY() >= 0 && sprite.getY() <= stage.getHeight() - Hud.bgHeight - sprite.getHeight())
				sprite.translateY(transition);
            else if (sprite.getY() < 0)
                sprite.setY(0);
            else
				sprite.setY(stage.getHeight() - Hud.bgHeight - sprite.getHeight());

			bounds.setPosition(sprite.getX() + 10, sprite.getY());
		}
	}
}