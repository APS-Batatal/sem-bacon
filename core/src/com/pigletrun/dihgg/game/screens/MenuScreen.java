package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.Image;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.core.BaseScreen;

import java.util.ArrayList;

public class MenuScreen extends BaseScreen {
	// VARIÁVEIS
	private Button playBtn, optionsBtn, tutorialBtn, rankBtn, creditsBtn, exitBtn; // Botões
	private String[] files = {"play", "options", "tutorial", "ranking", "credits", "exit"}; // lista de nomes dos botões
	private ArrayList<Button> buttons = new ArrayList<Button>(); // array de botões
	private Sound sound;

	private Image logo;

	public MenuScreen(final Game game) {
		super(game);
		sound = Gdx.audio.newSound(Gdx.files.internal("sound/button.wav"));

		// criar e posicionar logo
		logo = new Image("logo/game.png");
		logo.setScale(1.5f);
		logo.setPosition(60, Gdx.graphics.getHeight() / 2 - logo.getHeight() / 2);
		stage.addActor(logo);

		// para cada nome de botão
		for (int i = 0; i < files.length; i++) {
			String file = files[i]; // pegar o nome atual

			buttons.add(new Button(new Texture(Gdx.files.internal("images/ui/buttons/" + file + ".png")))); // criar um botão e adicioná-lo ao array de botões

			stage.addActor(buttons.get(i)); // adicionar ao stage
		}


		// Atribuir cada botão a sua respectiva variável
		// TODO: Ver como melhorar isso
		playBtn = buttons.get(0);
		optionsBtn = buttons.get(1);
		tutorialBtn = buttons.get(2);
		rankBtn = buttons.get(3);
		creditsBtn = buttons.get(4);
		exitBtn = buttons.get(5);

		//posicionar cada um dos botões

		playBtn.setPosition(Gdx.graphics.getWidth() / 2 - playBtn.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 - playBtn.getWidth() / 4);
		optionsBtn.setPosition(playBtn.getX() + optionsBtn.getWidth() + 24, playBtn.getY());
		tutorialBtn.setPosition(playBtn.getX(), playBtn.getY() - tutorialBtn.getHeight() - 24);
		rankBtn.setPosition(tutorialBtn.getX() + rankBtn.getWidth() + 24, tutorialBtn.getY());
		creditsBtn.setPosition(tutorialBtn.getX(), tutorialBtn.getY() - creditsBtn.getHeight() - 24);
		exitBtn.setPosition(creditsBtn.getX() + exitBtn.getWidth() + 24, creditsBtn.getY());



		// LISTENERS
		// Ao clicar no botão de início
		playBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				sound.play();
				dispose();
				game.setScreen(new GameScreen(game));
				return true;
			}
		});
		// Ao clicar no botão de Tutorial
		tutorialBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				sound.play();
				dispose();
				game.setScreen(new TutorialScreen(game));
				return true;
			}
		});
		// Ao clicar no botão de ranking
		rankBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				sound.play();
				dispose();
				game.setScreen(new RankingScreen(game));
				return true;
			}
		});
		// Ao clicar no botão de créditos
		creditsBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				sound.play();
				dispose();
				game.setScreen(new CreditsScreen(game));
				return true;
			}
		});
		// Ao clicar no botão de Sair
		exitBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				sound.play();
				//TODO: box de confirmação
				Gdx.app.exit();
				return true;
			}
		});
	}
}