package com.pigletrun.dihgg.game.components.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;


public class Button extends ImageButton {
	public Button(Texture up, Texture down, Texture background) {
		super(new SpriteDrawable(new Sprite(up)), new SpriteDrawable(new Sprite(down)));
		this.setBackground(new SpriteDrawable(new Sprite(background)));
	}

	public Button(Texture texture) {
		super(new SpriteDrawable(new Sprite(texture)), new SpriteDrawable(new Sprite(texture)));
		this.setBackground(new SpriteDrawable(new Sprite(texture)));
	}

	public void toCenter(float offsetX, float offsetY) {
		float x = (Gdx.graphics.getWidth() / 2) - (this.getWidth() / 2) + offsetX;
		float y = (Gdx.graphics.getHeight() / 2) - (this.getHeight() / 2) + offsetY;
		this.setPosition(x, y);
	}

	public void toCenter() {
		this.toCenter(0, 0);
	}
}