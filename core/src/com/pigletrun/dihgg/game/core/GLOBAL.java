package com.pigletrun.dihgg.game.core;

import com.badlogic.gdx.math.Rectangle;

public class GLOBAL {
	public static final int SAW_SPACING = 125; // distância lateral entre as serras
	public static final int SAW_COUNT = 12;  // quantidade de serras do jogo
	public static final int SAW_WIDTH = 52;
	public static Rectangle bounds; // pig bounds
	public static Ranking ranking = new Ranking();
	public static Boolean GAME_OVER;
	public static Boolean paused = false; // para pausar o jogo
}