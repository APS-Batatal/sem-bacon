package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.core.BaseScreen;

public class EndScreen extends BaseScreen {
	private Button retryBtn;

	EndScreen(final Game game) {
		super(game);

		retryBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/retry.png")));
		retryBtn.setPosition(10, Gdx.graphics.getHeight() / 2 - retryBtn.getHeight() / 2);

		//Listeners
		retryBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// Trocar para a tela do jogo
				game.setScreen(new GameScreen(game));
				return true;
			}
		});

		stage.addActor(retryBtn);
	}
}
