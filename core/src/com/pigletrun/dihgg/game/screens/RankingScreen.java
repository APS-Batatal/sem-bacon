package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.Text;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

import static com.pigletrun.dihgg.game.core.GLOBAL.musicPlaying;

public class RankingScreen extends BaseScreen {

	private Text text, hiscore;
	private Button backBtn, clearHiscore;
	private Sound sound;

	public RankingScreen(final Game game) {
		super(game);

		sound = Gdx.audio.newSound(Gdx.files.internal("sound/button.wav"));

		text = new Text("O Recorde atual é de:");
		text.setPosition((stage.getWidth() / 2 - text.getWidth() / 2), (stage.getHeight() / 2 + text.getHeight() * 3));

		hiscore = new Text(GLOBAL.ranking.getHiscore() + " Pontos");
		hiscore.setScale(2f);
		hiscore.setPosition(stage.getWidth() / 2 - hiscore.getWidth() / 2, text.getY() - 72);

		backBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/back.png")));
		backBtn.setPosition(stage.getWidth() - backBtn.getWidth() - 24, 24);

		clearHiscore = new Button(new Texture(Gdx.files.internal("images/ui/buttons/clear.png")));
		clearHiscore.setPosition(24, 24);

		//Listeners
		backBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if (musicPlaying)
					sound.play();
				dispose();
				game.setScreen(new MenuScreen(game));
				return true;
			}
		});

		clearHiscore.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if (musicPlaying)
					sound.play();
				GLOBAL.ranking.clearHiscore();
				dispose();
				game.setScreen(new RankingScreen(game));
				return true;
			}
		});

		stage.addActor(hiscore);
		stage.addActor(text);
		stage.addActor(backBtn);
		stage.addActor(clearHiscore);
	}
}
