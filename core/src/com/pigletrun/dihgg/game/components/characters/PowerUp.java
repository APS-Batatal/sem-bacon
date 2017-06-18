package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;


public class PowerUp extends Actor {
    private Sprite sprite;
    private String type;
	private float velocity;
	private Rectangle bounds;

    public PowerUp(String file) {
        sprite = new Sprite(new Texture(Gdx.files.internal("images/characters/powerups/" + file + ".png")));
		sprite.setScale(0.5f);
		this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
		bounds = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		reposition();
		velocity = -5f;
	}

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
		sprite.draw(batch, parentAlpha);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		sprite.translateX(velocity);
		this.setPosition(sprite.getX(), sprite.getY());
		if (this.getX() < -100) {
			reposition();
		}
	}

	public boolean collides(Rectangle object) {
		return this.bounds.overlaps(object);
	}

	private void reposition() {
		this.setVisible(true);
		sprite.setX(Gdx.graphics.getWidth() + new Random().nextInt(Gdx.graphics.getWidth()));
		sprite.setY(Gdx.graphics.getHeight() / 2);
	}
}
