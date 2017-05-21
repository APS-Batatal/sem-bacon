package com.pigletrun.dihgg.game.components.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.pigletrun.dihgg.game.core.GLOBAL;

public class Hud {
	private BitmapFont font;
	private LabelStyle labelStyle;

	//variaveis
	private int score;
	private int hiscore;
	// Labels
	private Label scoreLabel;


	public Hud(Stage stage) {
		//iniciar variáveis
		this.score = GLOBAL.ranking.getScore();
		this.hiscore = GLOBAL.ranking.getHiscore();

		// Criar estilo das labels
		this.labelStyle = new LabelStyle(); // estilo das labels
		this.labelStyle.font = new Font("press-start.ttf").get(); // gerar font customizada
		this.labelStyle.fontColor = Color.BLACK; // pegar cor

		// criar label de score
		this.scoreLabel = new Label(String.valueOf(this.score), this.labelStyle); // instanciar label de score
		this.scoreLabel.setScale(2f); // mudar escala
		// TODO: alterar
		this.scoreLabel.setPosition(10, 10); // alterar posição

		stage.addActor(this.scoreLabel); // adicionar ao stage
	}

	public void update() {
		//atualizar valores
		this.score = GLOBAL.ranking.getScore();
		this.scoreLabel.setText(String.valueOf(this.score));
	}
}
