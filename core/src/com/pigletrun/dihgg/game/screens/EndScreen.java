package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.Image;
import com.pigletrun.dihgg.game.components.Text;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

import static com.pigletrun.dihgg.game.core.GLOBAL.cam;

public class EndScreen extends BaseScreen {
	private Button retryBtn, menuBtn, exitBtn;
	private Image light, plate;
	private Text text, score, hiscore;
	private float btnY;

	public EndScreen(final Game game) {
		super(game);

		retryBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/retry.png")));
		btnY = (Gdx.graphics.getHeight() / 2 - retryBtn.getHeight() / 2);
		retryBtn.setPosition(24, btnY);

		menuBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/menu.png")));
		menuBtn.setPosition(retryBtn.getX() + retryBtn.getWidth() + 20, btnY);

		exitBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/exit.png")));
		exitBtn.setPosition(menuBtn.getX() + menuBtn.getWidth() + 20, btnY);

		light = new Image("gameover/light.png");
		light.setPosition(cam.viewportWidth - light.getWidth(), cam.viewportHeight - light.getHeight());
		plate = new Image("gameover/plate.png");
		plate.setPosition(cam.viewportWidth - plate.getWidth() - 75, 75);

		text = new Text("VIROU BACON !!!");
		text.setScale(1.8f);
		text.setPosition(24, cam.viewportHeight - text.getHeight() - 24);

		score = new Text("Seus pontos: " + GLOBAL.ranking.getScore());
		score.setPosition(text.getX(), text.getY() - 40);

		hiscore = new Text("");
		if (GLOBAL.ranking.getScore() >= GLOBAL.ranking.getHiscore()) {
			hiscore.setText("Parabéns, você fez o novo recorde!");
		} else {
			hiscore.setText("A pontuação mais alta é " + GLOBAL.ranking.getHiscore());
		}
		hiscore.setPosition(score.getX(), score.getY() - score.getHeight() - 24);

		//Listeners
		retryBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.dispose();
				game.setScreen(new GameScreen(game));
				return true;
			}
		});
		menuBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.dispose();
				game.setScreen(new MenuScreen(game));
				return true;
			}
		});
		exitBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
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
