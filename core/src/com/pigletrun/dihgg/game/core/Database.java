package com.pigletrun.dihgg.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

class Database {
	private Preferences preferences;

	Database(String name) {
		preferences = Gdx.app.getPreferences(name);
	}

	void put(String key, int value) {
		preferences.putInteger(key, value);
		preferences.flush();
	}

	void put(String key, boolean value) {
		preferences.putBoolean(key, value);
		preferences.flush();
	}

	int getInt(String key) {
		return preferences.getInteger(key);
	}

	boolean getBoolean(String key) {
		return preferences.getBoolean(key);
	}
}
