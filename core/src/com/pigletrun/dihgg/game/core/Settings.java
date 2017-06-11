package com.pigletrun.dihgg.game.core;

public class Settings {
	private Database db = new Database("settings");

	public boolean getMusic() {
		return db.getBoolean("music");
	}

	public void setMusic(boolean active) {
		db.put("music", active);
	}
}
