package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.pigletrun.dihgg.game.components.Logo;
import com.pigletrun.dihgg.game.core.BaseScreen;

import java.util.ArrayList;


public class IntroScreen extends BaseScreen {
	// VARIÁVEIS
	private String files[] = {"unicluster.png", "unip.png", "guaxinim.png", "game.png"}; // nomes dos arquivos de logo
	private Logo logo; // Classe de logo
	private float delay = 2f; // tempo de delay entre os logos

	public IntroScreen(final Game game) {
		super(game);

		logo = new Logo(files[0]); // iniciar o logo 'com o primeiro logo'
		stage.addActor(logo); // Adicionar o ator 'logo' ao stage

		// Criar sequencia de ações
		ArrayList<Action> actions = new ArrayList<Action>();
		for (int i = 0; i < files.length; i++) {
			final int k = i;
			actions.add(new Action() {
				@Override
				public boolean act(float delta) {
					logo.setSprite(files[k]);
					return true;
				}
			});
			actions.add(Actions.delay(delay));
		}
		// Adicionar a ação final
		actions.add(new Action() {
			@Override
			public boolean act(float delta) {
				game.dispose();
				game.setScreen(new MenuScreen(game));
				return true;
			}
		});

		// Transformar em um array primitivo de actions
		Action[] _actions = new Action[actions.size()];
		for (int i = 0; i < actions.size(); i++) {
			_actions[i] = actions.get(i);
		}

		logo.addAction(Actions.sequence(_actions)); // adicionar a sequência de ações ao logo
	}
}
