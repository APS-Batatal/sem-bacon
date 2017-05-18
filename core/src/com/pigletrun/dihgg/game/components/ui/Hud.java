package com.pigletrun.dihgg.game.components.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.pigletrun.dihgg.game.core.GLOBAL;

public class Hud {
	private BitmapFont font;
	private LabelStyle labelStyle;

	private Label score;

	public Hud() {

		this.font = new Font("press-start.ttf").get();
		this.labelStyle = new LabelStyle();
		this.labelStyle.font = font;

		this.score = new Label(String.valueOf(GLOBAL.ranking.getScore()), this.labelStyle);
	}

	public Label score() {
		return this.score;
	}

	public void update() {
	}

	public void dispose() {

	}
}
