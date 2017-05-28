package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_COUNT;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_SPACING;
import static com.pigletrun.dihgg.game.core.GLOBAL.SAW_WIDTH;
import static com.pigletrun.dihgg.game.core.GLOBAL.cam;

public class Saw extends Actor {
    private static final float FLUCTUATION = cam.viewportHeight - 400; // número para posicionamento randômico da serra
    private static final int SAW_GAP = 100; // distância entre as serras superiores
    private static final float LOWEST_OPENING = cam.viewportHeight - 390; // altura mínima aceitável para impedir o não aparecimento da serra na tela

    private Sprite saw1 = new Sprite(new Texture("images/Saw1.png"));
    private Sprite saw2 = new Sprite(new Texture("images/Saw1.png"));
    private Random rand;

    public Saw(float x) {
        rand = new Random();
        saw1.setPosition(x, rand.nextInt(Math.round(FLUCTUATION)) + SAW_GAP + LOWEST_OPENING);
        saw2.setPosition(x, saw1.getY() - SAW_GAP - saw2.getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        // movimenta as serras no eixo x
        saw1.translateX(-2f);
        saw2.translateX(-2f);

        // efetuada o reposicionamento das serraa conforme estas saem da tela
        if (saw1.getX() + saw1.getWidth() < 0) {
            reposition(saw1.getX() + (SAW_WIDTH + SAW_SPACING) * SAW_COUNT);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        saw1.draw(batch);
        saw2.draw(batch);
    }

    public void reposition(float x) {
        saw1.setPosition(x, rand.nextInt(Math.round(FLUCTUATION)) + SAW_GAP + LOWEST_OPENING);
        saw2.setPosition(x, saw1.getY() - SAW_GAP - saw2.getHeight());
    }
}