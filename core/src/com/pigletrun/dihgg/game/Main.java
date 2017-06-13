package com.pigletrun.dihgg.game;

import com.badlogic.gdx.Game;
import com.pigletrun.dihgg.game.components.Musics;
import com.pigletrun.dihgg.game.screens.IntroScreen;

import static com.pigletrun.dihgg.game.core.GLOBAL.musicPlaying;

class Main extends Game {

	private Musics music;

	@Override
	public void create () {
		music = new Musics();
		this.setScreen(new IntroScreen(this));
	}

	@Override
	public void render() {
		super.render();
		if (!musicPlaying)
			music.setVolume(0);
		else music.setVolume(1);
	}
}
