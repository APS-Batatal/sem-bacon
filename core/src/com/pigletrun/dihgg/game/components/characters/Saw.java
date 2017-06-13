package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.pigletrun.dihgg.game.core.GLOBAL;

import java.util.Random;

import static com.pigletrun.dihgg.game.core.GLOBAL.GAME_OVER;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_COUNT;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_SPACING;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_WIDTH;
import static com.pigletrun.dihgg.game.core.GLOBAL.bounds;
import static com.pigletrun.dihgg.game.core.GLOBAL.gamePaused;
import static com.pigletrun.dihgg.game.core.GLOBAL.musicPlaying;

public class Saw extends Actor {
	private static final int FLUCTUATION = 360; // número para posicionamento randômico da serra // 230
	private static final int SAW_GAP = 150; // distância entre as serras superiores
	private static final int LOWEST_OPENING = 50; // altura mínima aceitável para impedir o não aparecimento da serra na tela

	private Sprite saw1 = new Sprite(new Texture("images/Saw1.png"));
	private Sprite saw2 = new Sprite(new Texture("images/Saw1.png"));
	private Rectangle boundsSaw1, boundsSaw2;
	private Random rand;
	private Sound sound, sound2;
	private int velocity = -5;
	private int pigPassed, playSound;
	private boolean block = false;

	public Saw(float x) {
		rand = new Random();
		sound = Gdx.audio.newSound(Gdx.files.internal("sound/saw.wav"));
		sound2 = Gdx.audio.newSound(Gdx.files.internal("sound/game-over.wav"));

		saw1.setPosition(x, rand.nextInt(FLUCTUATION) + SAW_GAP + LOWEST_OPENING);
		saw2.setPosition(x, saw1.getY() - SAW_GAP - saw2.getHeight());

		boundsSaw1 = new Rectangle(saw1.getX(), saw1.getY(), saw1.getWidth() - 20, saw1.getHeight() - 20);
		boundsSaw2 = new Rectangle(saw2.getX(), saw2.getY(), saw2.getWidth() - 20, saw2.getHeight() - 20);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (!gamePaused) {
			if (GLOBAL.ranking.getScore() % 10 == 0 && GLOBAL.ranking.getScore() != 0 && !block) {
				velocity += velocity * (delta);
				block = true;
			}
			if (GLOBAL.ranking.getScore() % 20 == 0 && GLOBAL.ranking.getScore() != 0 && block) {
				block = false;
			}

			// movimenta as serras no eixo x
			saw1.translateX(velocity);
			saw2.translateX(velocity);
			boundsSaw1.setPosition(saw1.getX(), saw1.getY());
			boundsSaw2.setPosition(saw2.getX(), saw2.getY());

			// efetua o reposicionamento das serra conforme estas saem da tela
			if (boundsSaw1.getX() + boundsSaw1.getWidth() < 0) {
				reposition(boundsSaw1.getX() + (SAW_WIDTH + SAW_SPACING) * SAW_COUNT);
			}

			// verifica colisão com o porco
			if (collides(bounds)) {
				if (musicPlaying)
					sound2.play();
				GAME_OVER = true;
			}

			// Verifica início da passagem do porco pela serra
			if (boundsSaw1.getX() <= bounds.getX() + (bounds.getWidth() / 2) && !GAME_OVER) {
				playSound++;
				if (playSound == 1)
					if (musicPlaying)
						sound.play();
			} else playSound = 0;

			// verifica se porco passou pela serra
			if (boundsSaw1.getWidth() + boundsSaw1.getX() <= bounds.getX()) {
				pigPassed++;
				if (pigPassed == 1) {
					GLOBAL.ranking.addScore(10);
				}
			} else pigPassed = 0;
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		saw1.draw(batch);
		saw2.draw(batch);
	}

	private void reposition(float x) {
		saw1.setPosition(x, rand.nextInt(FLUCTUATION) + SAW_GAP + LOWEST_OPENING);
		saw2.setPosition(x, saw1.getY() - SAW_GAP - saw2.getHeight());
	}

	private boolean collides(Rectangle player) {
		return player.overlaps(boundsSaw1) || player.overlaps(boundsSaw2);
	}
}