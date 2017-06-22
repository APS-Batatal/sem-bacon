package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.Image;
import com.pigletrun.dihgg.game.components.Text;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

import static com.pigletrun.dihgg.game.core.GLOBAL.musicPlaying;

class EndScreen extends BaseScreen {
	private Sound sound;

	EndScreen(final Game game) {
		super(game);

		sound = Gdx.audio.newSound(Gdx.files.internal("sound/button.wav"));

		Button retryBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/retry.png")));
		float btnY = (stage.getHeight() / 2 - retryBtn.getHeight() / 2 - 50);
		retryBtn.setPosition(24, btnY);

		Button menuBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/menu.png")));
		menuBtn.setPosition(retryBtn.getX() + retryBtn.getWidth() + 20, btnY);

		Button exitBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/exit.png")));
		exitBtn.setPosition(menuBtn.getX() + menuBtn.getWidth() + 20, btnY);

		Image light = new Image("gameover/light.png");
		light.setScale(2f);
		light.setPosition(stage.getWidth() - light.getWidth(), stage.getHeight() - light.getHeight());

		Image plate = new Image("gameover/plate.png");
		plate.setScale(2f);
		plate.setPosition(stage.getWidth() - plate.getWidth() - 75, stage.getHeight() - (light.getHeight() + plate.getHeight() + 40));

		Text text = new Text("VIROU BACON !!!", 50);
		text.setPosition(24, stage.getHeight() - text.getHeight() - 80);

		Text score = new Text(("Seus pontos: " + GLOBAL.ranking.getScore()), 22);
		score.setPosition(text.getX(), text.getY() - 80);

		Text hiscore = new Text("", 22);
		if (GLOBAL.ranking.getScore() >= GLOBAL.ranking.getHiscore()) {
			hiscore.setText("Parabéns, você bateu o recorde!");
		} else {
			hiscore.setText("A pontuação mais alta é " + GLOBAL.ranking.getHiscore());
		}
		hiscore.setPosition(score.getX(), score.getY() - score.getHeight() - 24);

		//Listeners
		retryBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if (musicPlaying)
					sound.play();
				dispose();
				game.setScreen(new GameScreen(game));
				return true;
			}
		});
		menuBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if (musicPlaying)
					sound.play();
				dispose();
				game.setScreen(new MenuScreen(game));
				return true;
			}
		});
		exitBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if (musicPlaying)
					sound.play();
				// TODO: confirmar saída
				Gdx.app.exit();
				return true;
			}
		});


		stage.addActor(retryBtn);
		stage.addActor(menuBtn);
		stage.addActor(exitBtn);
		stage.addActor(light);
		stage.addActor(plate);
		stage.addActor(text);
		stage.addActor(score);
		stage.addActor(hiscore);

	}
}
