package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.core.BaseScreen;

public class EndScreen extends BaseScreen {
	private Button retryBtn;
	EndScreen(Game game) {
		super(game);

		retryBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/retry.png")));
	}
}
