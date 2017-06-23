package com.pigletrun.dihgg.game.components.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Button extends ImageButton {
	public Button(Texture texture) {
		super(new SpriteDrawable(new Sprite(texture)), new SpriteDrawable(new Sprite(texture)));
		this.setBackground(new SpriteDrawable(new Sprite(texture)));
	}
}