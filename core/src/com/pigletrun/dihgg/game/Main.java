package com.pigletrun.dihgg.game;

import com.badlogic.gdx.Game;
import com.pigletrun.dihgg.game.components.Musics;
import com.pigletrun.dihgg.game.screens.IntroScreen;

class Main extends Game {

	private Musics music;

	@Override
	public void create () {
		//adiciona musica ao game
		music = new Musics("bg-music.mp3", 0.5f);
		this.setScreen(new IntroScreen(this));
	}
}
