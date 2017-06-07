package com.pigletrun.dihgg.game;

import com.badlogic.gdx.Game;
import com.pigletrun.dihgg.game.components.Musics;
import com.pigletrun.dihgg.game.core.GLOBAL;
import com.pigletrun.dihgg.game.screens.IntroScreen;

class Main extends Game {

	private Musics music;

	@Override
	public void create () {
		music = new Musics("bg-music.mp3", 0.5f); //adiciona musica ao game
		GLOBAL.MUSIC = music.get();
		this.setScreen(new IntroScreen(this));
	}
}
