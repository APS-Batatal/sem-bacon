package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.pigletrun.dihgg.game.components.characters.Pig;
import com.pigletrun.dihgg.game.core.BaseScreen;

class GameScreen extends BaseScreen {
	// VARIÁVEIS
	private Pig pig; // Porco

	GameScreen(Game game) {
		super(game); // chamar construtor pai

		pig = new Pig(); // criar novo ator do porco
		pig.setPosition(50, Gdx.graphics.getHeight() / 2);  // Define posição inicial do porco

		stage.addActor(pig); // Adicionar o porco ao cenário

		// LISTENERS
		stage.addListener(new DragListener() {
			@Override
			public void touchDragged(InputEvent event, float x, float y, int pointer) {
				super.touchDragged(event, x, y, pointer);
				if (y > 0 && y < Gdx.graphics.getHeight() - pig.getHeight())
					pig.setPosition(50, y);
			}
		});
	}
}