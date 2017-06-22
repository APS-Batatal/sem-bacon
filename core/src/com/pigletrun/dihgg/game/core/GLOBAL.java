package com.pigletrun.dihgg.game.core;

public class GLOBAL {
	public static Ranking ranking = new Ranking();
	public static Settings settings = new Settings();
	public static Boolean GAME_OVER;
    public static Boolean gamePaused; // para pausar o jogo
	public static Boolean musicPlaying = settings.getMusic();
	public static int velocity = -5; // velocidade do jogo
}