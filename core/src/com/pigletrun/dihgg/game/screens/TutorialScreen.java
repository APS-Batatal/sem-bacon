package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pigletrun.dihgg.game.components.Image;
import com.pigletrun.dihgg.game.components.ui.Button;
import com.pigletrun.dihgg.game.core.BaseScreen;

class TutorialScreen extends BaseScreen {
	private Button backBtn;
	private Image image;
	private Sound sound;

	TutorialScreen(final Game game) {
		super(game);

		backBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/back.png")));
		backBtn.setPosition(Gdx.graphics.getWidth() - backBtn.getWidth() - 24, 24);

		image = new Image("tutorial/tutorial.png");
		image.setPosition(Gdx.graphics.getWidth() / 2 - image.getWidth() / 2, Gdx.graphics.getHeight() / 2 - image.getHeight() / 2);

		sound = Gdx.audio.newSound(Gdx.files.internal("sound/button.wav"));

		// Listeners
		backBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				sound.play();
				dispose();
				game.setScreen(new MenuScreen(game));
				return true;
			}
		});

		stage.addActor(image);
		stage.addActor(backBtn);
	}
}
