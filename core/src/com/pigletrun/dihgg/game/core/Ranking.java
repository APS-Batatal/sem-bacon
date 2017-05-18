package com.pigletrun.dihgg.game.core;

import com.pigletrun.dihgg.game.utils.Database;

public class Ranking {
	private Database db = new Database("Ranking");

	public int getScore() {
		return db.getInt("score");
	}

	public void setScore(int value) {
		db.put("score", value);
	}

	public int getHiscore() {
		return db.getInt("hiscore");
	}

	public void setHiscore(int value) {
		if (value > db.getInt("score")) {
			db.put("hiscore", value);
		}
	}
}
