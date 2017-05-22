package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.characters.Pig;
import com.pigletrun.dihgg.game.components.ui.Hud;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

class GameScreen extends BaseScreen {
	// VARIÁVEIS
	private Pig pig; // Porco
	private int pigX = 20; // a posição X do porco //TODO: adicionar lógica para o porco andar para frente
	private Hud hud;

	GameScreen(Game game) {
		super(game); // chamar construtor pai

		pig = new Pig(); // criar novo ator do porco
		hud = new Hud(stage); // Criar o elemento de Hud

		GLOBAL.ranking.setScore(0); // zerar o score

		stage.addActor(pig); // Adicionar o porco ao cenário

		// LISTENERS
		//TODO: isso aqui é apenas um teste
		stage.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				pig.move(pigX, y);
				GLOBAL.ranking.addScore(10);
				return true;
			}
		});
	}

	@Override
	public void render(float delta) {
		hud.update();
		pig.update();
		super.render(delta);
	}
}
