package com.pigletrun.dihgg.game.components.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Font {
	// Variables
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameters;
	private BitmapFont font;

	public Font(String name) {
		this(name, 18);
	}

	public Font(String name, int size) {

		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/" + name));
		parameters = new FreeTypeFontParameter();

		parameters.size = size;
		font = generator.generateFont(parameters);
		generator.dispose();
	}

	public BitmapFont get() {
		return font;
	}
}
