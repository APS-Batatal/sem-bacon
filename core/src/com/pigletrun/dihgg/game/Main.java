package com.pigletrun.dihgg.game;

import com.badlogic.gdx.Game;
import com.pigletrun.dihgg.game.screens.IntroScreen;

class Main extends Game {
	@Override
	public void create () {
		this.setScreen(new IntroScreen(this));
	}
}
