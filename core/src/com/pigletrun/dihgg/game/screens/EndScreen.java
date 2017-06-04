package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.core.BaseScreen;

public class EndScreen extends BaseScreen {
	private Button retryBtn, menuBtn, rankBtn;
	private float btnY;

	EndScreen(final Game game) {
		super(game);

		retryBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/retry.png")));
		btnY = (Gdx.graphics.getHeight() / 2 - retryBtn.getHeight() / 2);
		retryBtn.setPosition(10, btnY);

		menuBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/menu.png")));
		menuBtn.setPosition(retryBtn.getX() + retryBtn.getWidth() + 20, btnY);

		rankBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/ranking.png")));
		rankBtn.setPosition(menuBtn.getX() + menuBtn.getWidth() + 20, btnY);


		//Listeners
		retryBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.dispose();
				// Trocar para a tela do jogo
				game.setScreen(new GameScreen(game));
				return true;
			}
		});
		menuBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.dispose();
				// Trocar para a tela do jogo
				game.setScreen(new MenuScreen(game));
				return true;
			}
		});
		rankBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.dispose();
				// Trocar para a tela do jogo
				game.setScreen(new RankingScreen(game));
				return true;
			}
		});

		stage.addActor(retryBtn);
		stage.addActor(menuBtn);
		stage.addActor(rankBtn);

	}
}
