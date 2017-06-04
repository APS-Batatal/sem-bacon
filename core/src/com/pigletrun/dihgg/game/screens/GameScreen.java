package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.pigletrun.dihgg.game.components.characters.Pig;
import com.pigletrun.dihgg.game.components.characters.Saw;
import com.pigletrun.dihgg.game.components.ui.Hud;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

import static com.pigletrun.dihgg.game.core.GLOBAL.GAME_OVER;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_COUNT;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_SPACING;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_WIDTH;
import static com.pigletrun.dihgg.game.core.GLOBAL.cam;

class GameScreen extends BaseScreen {
	// VARIÁVEIS
	private Hud hud;
	private Pig pig; // Porco

	GameScreen(Game game) {
		super(game); // chamar construtor pai
		GAME_OVER = false;

		pig = new Pig(); // criar novo ator do porco
		hud = new Hud(stage);
		GLOBAL.ranking.setScore(0); // zerar o score

		stage.addActor(pig); // Adicionar o porco ao cenário

		//adiciona serras ao cenário
		for (int i = 1; i <= SAW_COUNT; i++) {
			stage.addActor(new Saw(i * (SAW_SPACING + SAW_WIDTH) + cam.viewportWidth));
		}

		// LISTENERS
		// drag
		stage.addListener(new DragListener() {
			@Override
			public void drag(InputEvent event, float x, float y, int pointer) {
				if (getDeltaY() > 0) //Identifica direção do movimento na tela
					pig.move(-5f); // pig.moveDown();
				else if (getDeltaY() < 0)
					pig.move(5f); //  pig.moveUp();

				GLOBAL.ranking.addScore(10);
			}
		});
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		hud.update();
		if (GAME_OVER) {
			game.dispose();
			game.setScreen(new EndScreen(game));
		}
	}
}