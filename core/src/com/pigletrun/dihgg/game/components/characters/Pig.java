package com.pigletrun.dihgg.game.components.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;

public class Pig extends Actor {
	private TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/characters/pig/Pig.pack"));
	private Sprite sprite = new Sprite(atlas.findRegion("p1"));
	private OrthographicCamera cam; // Variável para efeito de zoom
	private int frame = 1;

	public Pig() {
		this.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2); // Definine a câmera para projeção ortográfica
		//this.setTouchable(Touchable.enabled);

		/*addListener(new InputListener(){
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				Pig.this.setPosition(x,y);
			}
		});*/


		Timer.schedule(new Timer.Task(){
			   @Override
			   public void run() {
				   frame++;
				   if(frame > 6)
					   frame = 1;
				   sprite.setRegion(atlas.findRegion("p"+ frame));
			   }
		   }
		,0,5/30.0f);
	}

	@Override
	public void draw(Batch batch, float alpha) {
		batch.setProjectionMatrix(cam.combined); //Instrui o "batch" a usar a matriz combinada
		sprite.draw(batch);
	}

	@Override
	public void setPosition(float x, float y) {
		sprite.setPosition(x, y);
		super.setPosition(x, y);
	}



	/*@Override
	public void act(float delta) {
		super.act(delta);
	}
	@Override
	protected void positionChanged() {
		sprite.setPosition(getX(),getY());
		super.positionChanged();
	}*/
}
