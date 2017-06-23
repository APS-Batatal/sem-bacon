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

import static com.pigletrun.dihgg.game.core.GLOBAL.musicPlaying;

class CreditsScreen extends BaseScreen {
	private Sound sound;

	CreditsScreen(final Game game) {
		super(game);
		sound = Gdx.audio.newSound(Gdx.files.internal("sound/button.wav"));

		Image logo = new Image("logo/unicluster.png");
		logo.setPosition(stage.getWidth() / 2 - logo.getWidth() / 2, stage.getHeight() - logo.getHeight() - 48);

		String txt = "Unicluster é um grupo de estudos e desenvolvimento";
		txt += "\n";
		txt += "em Android e Arduino formado por alunos e professores";
		txt += "\n";
		txt += "dos cursos de Ciência da computação e Sistemas de inormação";
		txt += "\n";
		txt += "da UNIP - Cidade Universitária";
		txt += "\n\n";
		String[] jobs = {"Programação", "Ilustração", "Música por", "Sons por", "Realização", "Coordenador", "powered by"};
		for (int i = 0; i < jobs.length; i++) {
			String[] names = {"Diego Lopes / Silmara Raquel", "Diego Lopes", "FoolBoyMedia", "Juhani Junkala / krzysiunet", "Unicluster / UNIP", "Fábio Luís Pereira", "LIBGDX"};
			txt += jobs[i] + " : " + names[i] + "\n\n";
		}

		Text text = new Text(txt, 20);
		text.setPosition(24, logo.getY() - logo.getHeight() - 300);
		text.setWidth(Gdx.graphics.getWidth() - 24);

		Button backBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/back.png")));
		backBtn.setPosition(stage.getWidth() - backBtn.getWidth() - 24, 24);

		backBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if (musicPlaying)
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