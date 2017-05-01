package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.BaseScreen;
import com.pigletrun.dihgg.game.components.characters.Pig;

class GameScreen extends BaseScreen {
	// VARIÁVEIS
	private Pig pig; // Porco

	GameScreen(Game game) {
		super(game); // chamar construtor pai

		pig = new Pig(); // criar novo ator do porco
		Gdx.input.setInputProcessor(stage); // Settar o input processor ao stage

		stage.addActor(pig); // Adicionar o porco ao cenário

		// LISTENERS
		stage.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				pig.setPosition(x, y);
				return true;
			}
		});
	}
}
