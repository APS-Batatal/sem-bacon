package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

import static com.pigletrun.dihgg.game.core.GLOBAL.cam;

public class Saw extends Actor {
    private static final float FLUCTUATION = cam.viewportHeight - 400; // número para posicionamento randômico da serra
    private static final int SAW_GAP = 100; // distância entre as serras superiores
    private static final float LOWEST_OPENING = cam.viewportHeight - 390; // altura mínima aceitável para impedir o não aparecimento da serra na tela

    private Sprite saw1 = new Sprite(new Texture("images/Saw1.png"));
    private Sprite saw2 = new Sprite(new Texture("images/Saw1.png"));
    private Vector2 posSaw1, posSaw2;
    private Random rand;

    public Saw(int x) {
        rand = new Random();
        posSaw1 = new Vector2(x, rand.nextInt(Math.round(FLUCTUATION)) + SAW_GAP + LOWEST_OPENING); //  Define posição da serra do topo
        posSaw2 = new Vector2(x, posSaw1.y - SAW_GAP - saw2.getHeight()); // Define posição da serra de baixo

        saw1.setPosition(posSaw1.x, posSaw1.y);
        saw2.setPosition(posSaw2.x, posSaw2.y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        saw1.draw(batch);
        saw2.draw(batch);
    }

    public void update() {
        saw1.setX(saw1.getX() - 2f);
        saw2.setX(saw2.getX() - 2f);
        this.setPosition(saw1.getX(), saw1.getY());
    }

    public void reposition(float x) {
        posSaw1.set(x, rand.nextInt(Math.round(FLUCTUATION)) + SAW_GAP + LOWEST_OPENING);
        posSaw2.set(x, posSaw1.y - SAW_GAP - saw2.getHeight());
    }

    public Sprite getSaw1() {
        return saw1;
    }

    public Vector2 getPosSaw1() {
        return posSaw1;
    }
}