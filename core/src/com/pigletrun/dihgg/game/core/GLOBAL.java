package com.pigletrun.dihgg.game.core;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class GLOBAL {
	public static final int SAW_SPACING = 125; // distância lateral entre as serras
	public static final int SAW_COUNT = 8;  // quantidade de serras do jogo
	public static final int SAW_WIDTH = 52;
	public static Ranking ranking = new Ranking();
	public static OrthographicCamera cam = new OrthographicCamera();
}
