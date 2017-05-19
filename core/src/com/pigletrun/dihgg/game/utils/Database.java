package com.pigletrun.dihgg.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Database {
	private Preferences preferences;

	public Database(String name) {
		preferences = Gdx.app.getPreferences(name);
	}

	public void put(String key, String value) {
		preferences.putString(key, value);
		preferences.flush();
	}

	public void put(String key, int value) {
		preferences.putInteger(key, value);
		preferences.flush();
	}

	public String getString(String key) {
		return preferences.getString(key);
	}

	public int getInt(String key) {
		return preferences.getInteger(key);
	}
}
