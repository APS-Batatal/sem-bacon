package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.BaseScreen;
import com.pigletrun.dihgg.game.components.ui.Button;

class MenuScreen extends BaseScreen {
	private Button playBtn;

	MenuScreen(final Game game) {
		super(game);

		playBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/play-background.png"))); // criar um novo botão
		playBtn.toCenter(); // colocá-lo no centro da tela

		stage.addActor(playBtn); // adicionar ao stage

		// LISTENERS
		// Ao clicar no botão de início
		playBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// Trocar para a tela do jogo
				game.setScreen(new GameScreen(game));
				return true;
			}
		});
	}
}
