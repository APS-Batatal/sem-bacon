package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

public class Saw extends Actor {
    private static final int FLUCTUATION = 130;
    private static final int SAW_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Sprite saw1 = new Sprite(new Texture("images/Saw1.png"));
    private Sprite saw2 = new Sprite(new Texture("images/Saw1.png"));
    private Vector2 posSaw1, posSaw2;
    private Random rand;

    public Saw(int x) {
        rand = new Random();
        posSaw1 = new Vector2(x, rand.nextInt(FLUCTUATION) + SAW_GAP + LOWEST_OPENING);
        posSaw2 = new Vector2(x, posSaw1.y - SAW_GAP - saw2.getHeight());
        this.setPosition();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        saw1.draw(batch);
        saw2.draw(batch);
    }

    public void setPosition() {
        saw1.setPosition(posSaw1.x, posSaw1.y);
        saw2.setPosition(posSaw2.x, posSaw2.y);
    }
}