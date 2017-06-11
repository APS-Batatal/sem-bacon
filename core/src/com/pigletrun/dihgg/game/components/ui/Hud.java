package com.pigletrun.dihgg.game.components.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.pigletrun.dihgg.game.components.Image;
import com.pigletrun.dihgg.game.core.GLOBAL;
import com.pigletrun.dihgg.game.screens.MenuScreen;

import static com.pigletrun.dihgg.game.core.GLOBAL.gamePaused;
import static com.pigletrun.dihgg.game.core.GLOBAL.musicPlaying;
import static com.pigletrun.dihgg.game.core.GLOBAL.settings;

public class Hud {
	public static float bgHeight;
	//variaveis
	private int score;
	private LabelStyle labelStyle;
	private int hiscore;
	private Label scoreLabel, hiscoreLabel;
	private Button pauseBtn, musicBtn, menuBtn;
	private Image bg;

	public Hud(final Stage stage, final Game game) {
		//iniciar variáveis
		score = GLOBAL.ranking.getScore();
		hiscore = GLOBAL.ranking.getHiscore();

		bg = new Image("ui/buttons/hudbg.png");
		bg.setPosition(0, Gdx.graphics.getHeight() - bg.getHeight());
		bgHeight = bg.getHeight();

		// Criar estilo das labels
		labelStyle = new LabelStyle(); // estilo das labels
		labelStyle.font = new Font("press-start.ttf").get(); // gerar font customizada
		labelStyle.fontColor = Color.WHITE; // pegar cor

		// criar label de score
		scoreLabel = new Label("PONTOS: " + String.valueOf(score), labelStyle); // Instanciar label de score
		hiscoreLabel = new Label("RECORDE: " + String.valueOf(hiscore), labelStyle); // Instanciar label de score
		scoreLabel.setFontScale(2f); // altera tamanho da fonte
        hiscoreLabel.setFontScale(2f);
        // TODO: alterar
        scoreLabel.setPosition(10, Gdx.graphics.getHeight() - (scoreLabel.getHeight() * 2) - 10); // alterar posição
        hiscoreLabel.setPosition(10, Gdx.graphics.getHeight() - (scoreLabel.getHeight() * 2) - (hiscoreLabel.getHeight() * 2) - 48); // alterar posição

		//Cria botão Menu
		menuBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/menu.png")));
		menuBtn.setPosition(Gdx.graphics.getWidth() - menuBtn.getWidth() - 24, Gdx.graphics.getHeight() - menuBtn.getHeight() - 24);
		menuBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.dispose();
				game.setScreen(new MenuScreen(game));
				return false;
			}
		});

		//Cria botão pause;
		pauseBtn = new Button(new Texture(Gdx.files.internal("images/ui/buttons/pause.png")));
		pauseBtn.setPosition(menuBtn.getX() - pauseBtn.getWidth() - 50, Gdx.graphics.getHeight() - pauseBtn.getHeight() - 24);
		pauseBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				gamePaused = !gamePaused;
				if (gamePaused)
					pauseBtn.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("images/ui/buttons/unpause.png")));
				else
					pauseBtn.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("images/ui/buttons/pause.png")));
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		// Cria botão musica
		musicPlaying = settings.getMusic();
		musicBtn = new Button(new Texture(Gdx.files.internal((musicPlaying) ? "images/ui/buttons/music.png" : "images/ui/buttons/mute.png")));
		musicBtn.setPosition(pauseBtn.getX() - musicBtn.getWidth() - 50, Gdx.graphics.getHeight() - pauseBtn.getHeight() - 24);
		musicBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				musicPlaying = !musicPlaying;
				if (musicPlaying) {
					musicBtn.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("images/ui/buttons/music.png")));
					GLOBAL.MUSIC.setVolume(.5f);
				} else {
					musicBtn.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("images/ui/buttons/mute.png")));
					GLOBAL.MUSIC.setVolume(0);
				}
				settings.setMusic(musicPlaying);
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		// adicionar ao stage
		stage.addActor(bg);
		stage.addActor(scoreLabel);
		stage.addActor(hiscoreLabel);
		stage.addActor(menuBtn);
		stage.addActor(pauseBtn);
		stage.addActor(musicBtn);
	}

	public void update() {
		score = GLOBAL.ranking.getScore(); // Atualizar valor de score
		scoreLabel.setText("PONTOS: " + String.valueOf(score)); // Atualizar label

		// se score for maior do que hiscore, remover hiscore
		if ((score > hiscore) && hiscoreLabel.isVisible()) {
			hiscoreLabel.setVisible(false);
		}
	}
}