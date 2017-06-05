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

public class CreditsScreen extends BaseScreen {
	private Button backBtn;
	private Image logo;
	private Text text;
	private String[] jobs = {"Programação", "Ilustração", "Música por", "Sons por", "Realização", "powered by"};
	private String[] names = {"Diego Lopes / Silmara Raquel", "Diego Lopes", "FoolBoyMedia", "Juhani Junkala / krzysiunet", "Unicluster / UNIP", "LIBGDX"};
	private Sound sound;

	public CreditsScreen(final Game game) {
		super(game);
		sound = Gdx.audio.newSound(Gdx.files.internal("sound/button.wav"));

		logo = new Image("logo/game.png");
		logo.setPosition(Gdx.graphics.getWidth() / 2 - logo.getWidth() / 2, Gdx.graphics.getHeight() - logo.getHeight() - 48);

		String txt = "";
		for (int i = 0; i < jobs.length; i++) {
			txt += jobs[i] + " : " + names[i] + "\n\n";
		}

		text = new Text(txt, 20);
		text.setPosition(24, logo.getY() - logo.getHeight() - 120);

		backBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/back.png")));
		backBtn.setPosition(Gdx.graphics.getWidth() - backBtn.getWidth() - 24, 24);

		backBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				sound.play();
				dispose();
				game.setScreen(new MenuScreen(game));
				return false;
			}
		});


		stage.addActor(logo);
		stage.addActor(text);
		stage.addActor(backBtn);
	}
}