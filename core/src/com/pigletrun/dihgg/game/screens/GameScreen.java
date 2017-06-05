package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.pigletrun.dihgg.game.components.characters.Pig;
import com.pigletrun.dihgg.game.components.characters.Saw;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.components.ui.Hud;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

import static com.pigletrun.dihgg.game.core.GLOBAL.GAME_OVER;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_COUNT;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_SPACING;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_WIDTH;
import static com.pigletrun.dihgg.game.core.GLOBAL.cam;
import static com.pigletrun.dihgg.game.core.GLOBAL.paused;

class GameScreen extends BaseScreen {
	// VARIÁVEIS
	private Hud hud;
	private Pig pig; // Porco
	private Button pauseBtn;

	GameScreen(final Game game) {
		super(game); // chamar construtor pai
		GAME_OVER = false;

		GLOBAL.ranking.setScore(0); // zerar o score

		pig = new Pig(); // criar novo ator do porco

		pauseBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/pause.png")));
		pauseBtn.setPosition(cam.viewportWidth - pauseBtn.getWidth() - 24, cam.viewportHeight - pauseBtn.getHeight() - 24);
		pauseBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				paused = !paused;
				return true;
			}
		});

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

		hud = new Hud(stage);
		stage.addActor(pig); // Adicionar o porco ao cenário
		//adiciona serras ao cenário
		for (int i = 1; i <= SAW_COUNT; i++) {
			stage.addActor(new Saw(i * (SAW_SPACING + SAW_WIDTH) + cam.viewportWidth));
		}
		stage.addActor(pauseBtn);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		hud.update();
		if (GAME_OVER) {
			dispose();
			game.setScreen(new EndScreen(game));
		}
	}
}