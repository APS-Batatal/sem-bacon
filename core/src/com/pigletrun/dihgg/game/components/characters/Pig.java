package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;

import static com.pigletrun.dihgg.game.core.GLOBAL.cam;

public class Pig extends Actor {

	private TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/characters/pig/Pig.pack"));
	private Sprite sprite = new Sprite(atlas.findRegion("p1"));
	private int frame = 1;
//	private float toX, toY; // variáveis para posicionar o porco
//	private float velocity = 3f; // velocidade de movimento do porco

	public Pig() {
		//toX = 50;
		//toY = Gdx.graphics.getHeight() / 4 - sprite.getHeight() / 2;
		sprite.setPosition(50, Gdx.graphics.getHeight() / 4 - sprite.getHeight() / 2);
		//this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

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
		batch.setProjectionMatrix(cam.combined); //Instrui o "batch" a usar a matriz combinada
		sprite.draw(batch);
	}

	public void move(float transition) {
		if (sprite.getY() >= 100 && sprite.getY() <= cam.viewportHeight - 100 - sprite.getHeight())
			sprite.translateY(transition);
		//toY = y;
	}

	public void update() {
		// Atualizar a posição do porco
	/*if (sprite.getX() < cam.viewportWidth/2) // condição para teste somente
			sprite.translateX(2f);
			cam.position.x = sprite.getX() + 80;
			cam.update();
		    //this.setX(this.getX() + 3f);

		/*if (this.getY() < toY) {
			this.setY(this.getY() + velocity);
		} else if (this.getY() > toY) {
			this.setY(this.getY() - velocity);
		}
		sprite.setPosition(this.getX(), this.getY());*/
	}
}