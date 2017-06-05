package com.pigletrun.dihgg.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.pigletrun.dihgg.game.components.ui.Font;

/**
 * Created by Diego on 04/06/2017.
 */

public class Text extends Actor {
	private Label label;
	private Label.LabelStyle labelStyle;

	public Text(String text, int size) {
		this(text);
		labelStyle.font = new Font("press-start.ttf", size).get(); // gerar font customizada
		label.setStyle(labelStyle);
	}
	public Text(String text) {
		labelStyle = new Label.LabelStyle(); // estilo das labels
		labelStyle.font = new Font("press-start.ttf").get(); // gerar font customizada
		labelStyle.fontColor = Color.BLACK; // pegar cor
		label = new Label(text, labelStyle);
		this.setBounds(label.getX(), label.getY(), label.getWidth(), label.getHeight());
	}

	public void setScale(float scale) {
		label.setFontScale(scale);
		this.setBounds(label.getX(), label.getY(), label.getWidth(), label.getHeight());
	}

	public void setText(String text) {
		label.setText(text);
		this.setBounds(label.getX(), label.getY(), label.getWidth(), label.getHeight());
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		label.draw(batch, parentAlpha);
		super.draw(batch, parentAlpha);
	}

	@Override
	public void setPosition(float x, float y) {
		label.setPosition(x, y);
		super.setPosition(x, y);
	}
}