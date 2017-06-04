package com.pigletrun.dihgg.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.pigletrun.dihgg.game.screens.IntroScreen;

class Main extends Game {

	private Music music;

	@Override
	public void create () {
		//adiciona musica ao game
		music = Gdx.audio.newMusic(Gdx.files.internal("music/bg-music.mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);
		music.play();
		
		this.setScreen(new IntroScreen(this));
	}
}
