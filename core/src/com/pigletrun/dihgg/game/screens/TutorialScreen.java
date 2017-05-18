package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.pigletrun.dihgg.game.components.ui.Font;
import com.pigletrun.dihgg.game.components.ui.Hud;
import com.pigletrun.dihgg.game.core.BaseScreen;

public class TutorialScreen extends BaseScreen {
	private Hud hud;
	TutorialScreen(Game game) {
		super(game);
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new Font("press-start.ttf").get();
		Label label = new Label("10", labelStyle);
		label.setSize(10, 10);
		stage.addActor(label);
	}
}
