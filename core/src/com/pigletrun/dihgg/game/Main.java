package com.pigletrun.dihgg.game;

import com.badlogic.gdx.Game;
import com.pigletrun.dihgg.game.screens.EndScreen;

class Main extends Game {
	@Override
	public void create () {
		this.setScreen(new EndScreen(this));
	}
}
