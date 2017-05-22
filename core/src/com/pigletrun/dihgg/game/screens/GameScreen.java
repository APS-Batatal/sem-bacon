package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.pigletrun.dihgg.game.components.characters.Pig;
import com.pigletrun.dihgg.game.components.characters.Saw;
import com.pigletrun.dihgg.game.core.BaseScreen;

class GameScreen extends BaseScreen {
	// VARIÁVEIS
	private Pig pig; // Porco
	private Saw saw;

	GameScreen(Game game) {
		super(game); // chamar construtor pai

		pig = new Pig(); // criar novo ator do porco
        saw = new Saw(200);

		stage.addActor(pig); // Adicionar o porco ao cenário
		stage.addActor(saw);
		stage.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
				if (getDeltaY() > 0)
					pig.moveDown();
				else if (getDeltaY() < 0)
					pig.moveUp();
			}
		});
	}
}