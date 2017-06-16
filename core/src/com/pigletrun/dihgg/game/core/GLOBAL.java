package com.pigletrun.dihgg.game.core;

import com.badlogic.gdx.math.Rectangle;

public class GLOBAL {
    public static Rectangle bounds; // pig bounds
	public static Ranking ranking = new Ranking();
	public static Settings settings = new Settings();
	public static Boolean GAME_OVER;
    public static Boolean gamePaused; // para pausar o jogo
	public static Boolean musicPlaying = settings.getMusic();
}