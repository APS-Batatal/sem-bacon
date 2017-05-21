package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.pigletrun.dihgg.game.components.ui.Font;
import com.pigletrun.dihgg.game.components.ui.Hud;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

class TutorialScreen extends BaseScreen {
	private Hud hud;
	TutorialScreen(Game game) {
		super(game);
		// TODO: remover
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new Font("press-start.ttf").get();
		Label label = new Label(String.valueOf(GLOBAL.ranking.getHiscore()), labelStyle);
		label.setColor(Color.BLACK);

		label.setPosition(20, 20);
		stage.addActor(label);
	}
}
