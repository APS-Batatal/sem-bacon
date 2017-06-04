package com.pigletrun.dihgg.game.components.ui;

import com.badlogic.gdx.Gdx;
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
	private Label scoreLabel, hiscoreLabel;


	public Hud(Stage stage) {
		//iniciar variáveis
		score = GLOBAL.ranking.getScore();
		hiscore = GLOBAL.ranking.getHiscore();

		// Criar estilo das labels
		labelStyle = new LabelStyle(); // estilo das labels
		labelStyle.font = new Font("press-start.ttf").get(); // gerar font customizada
		labelStyle.fontColor = Color.BLACK; // pegar cor

		// criar label de score
		scoreLabel = new Label("PONTOS: \n\n" + String.valueOf(score), labelStyle); // Instanciar label de score
		hiscoreLabel = new Label("RECORDE: \n\n" + String.valueOf(hiscore), labelStyle); // Instanciar label de score
		//scoreLabel.setFontScale(2f); // altera tamanho da fonte
		//hiscoreLabel.setFontScale(2f);
		// TODO: alterar
		scoreLabel.setPosition(10, Gdx.graphics.getHeight() - 70); // alterar posição
		hiscoreLabel.setPosition(10, scoreLabel.getY() - hiscoreLabel.getHeight() - 48); // alterar posição
		//scoreLabel.setPosition(10, Gdx.graphics.getHeight() - 50); // alterar posição
		//hiscoreLabel.setPosition((scoreLabel.getX() + hiscoreLabel.getWidth() + 20), Gdx.graphics.getHeight() - 50); // alterar posição

		stage.addActor(scoreLabel); // adicionar ao stage
		stage.addActor(hiscoreLabel); // adicionar ao stage
	}

	public void update() {
		score = GLOBAL.ranking.getScore(); // Atualizar valor de score
		scoreLabel.setText("PONTOS: \n\n" + String.valueOf(score)); // Atualizar label

		// se score for maior do que hiscore, remover hiscore
		if ((score > hiscore) && hiscoreLabel.isVisible()) {
			hiscoreLabel.setVisible(false);
		}
	}
}
