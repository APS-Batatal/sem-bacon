package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.BaseScreen;
import com.pigletrun.dihgg.game.components.ui.Button;

import java.util.ArrayList;

class MenuScreen extends BaseScreen {
	// VARIÁVEIS
	private Button playBtn, optionsBtn, tutorialBtn, rankingsBtn, exitBtn; // Botões
	private String[] files = {"play", "options", "tutorial", "rankgings", "exit"}; // lista de nomes dos botões
	private ArrayList<Button> buttons = new ArrayList<Button>(); // array de botões

	MenuScreen(final Game game) {
		super(game);

		// para cada nome de botão
		for (int i = 0; i < files.length; i++) {
			String file = files[i]; // pegar o nome atual
			buttons.add(new Button(new Texture(Gdx.files.internal("images/ui/buttons/" + file + "-background.png")))); // criar um botão e adicioná-lo ao array de botões
			buttons.get(i).toCenter(0, -((buttons.get(i).getHeight() + 24) * i)); // posicioná-lo de acordo
			stage.addActor(buttons.get(i)); // adicionar ao stage
		}

		// Atribuir cada botão a sua respectiva variável
		// TODO: Ver como melhorar isso
		playBtn = buttons.get(0);
		optionsBtn = buttons.get(1);
		tutorialBtn = buttons.get(2);
		rankingsBtn = buttons.get(3);
		exitBtn = buttons.get(4);

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
