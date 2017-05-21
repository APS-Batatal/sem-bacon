package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
        pig.setPosition(50, (Gdx.graphics.getHeight() / 4) - pig.getHeight());  // Define posição inicial do porco

        saw = new Saw(200);
        saw.setPosition();

		stage.addActor(pig); // Adicionar o porco ao cenário
		stage.addActor(saw);
		// LISTENERS
		stage.addListener(new DragListener() {
            //TODO: Melhorar movimento do porco
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                if (y < Gdx.graphics.getHeight() / 2 - pig.getHeight())
                    pig.setPosition(50, y);
			}
		});
	}
}