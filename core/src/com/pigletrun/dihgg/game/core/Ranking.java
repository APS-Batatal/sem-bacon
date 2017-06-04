package com.pigletrun.dihgg.game.core;

public class Ranking {
	private Database db = new Database("Ranking");

	public int getScore() {
		return db.getInt("score");
	}

	public void setScore(int value) {
		db.put("score", value);
	}

	public void addScore(int value) {
		db.put("score", db.getInt("score") + value);
		this.setHiscore(this.getScore());
	}

	public int getHiscore() {
		return db.getInt("hiscore");
	}

	public void setHiscore(int value) {
		if (value > db.getInt("hiscore")) {
			db.put("hiscore", value);
		}
	}

	public void clearHiscore() {
		db.put("hiscore", 0);
	}
}
