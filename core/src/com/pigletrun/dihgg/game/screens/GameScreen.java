package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.pigletrun.dihgg.game.components.characters.Pig;
import com.pigletrun.dihgg.game.components.characters.Saw;
import com.pigletrun.dihgg.game.components.ui.Hud;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

class GameScreen extends BaseScreen {
	// VARIÁVEIS
	private Hud hud;
	private Pig pig; // Porco
	private Saw saw;

	GameScreen(Game game) {
		super(game); // chamar construtor pai

		hud = new Hud(stage);
		GLOBAL.ranking.setScore(0); // zerar o score

		pig = new Pig(); // criar novo ator do porco
		saw = new Saw(200);

		stage.addActor(pig); // Adicionar o porco ao cenário
		stage.addActor(saw); // Adicionar a serra

		// LISTENERS
		// drag
		stage.addListener(new DragListener() {
			@Override
			public void drag(InputEvent event, float x, float y, int pointer) {
				pig.move(50, y);
				GLOBAL.ranking.addScore(10);
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