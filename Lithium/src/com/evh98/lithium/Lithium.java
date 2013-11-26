package com.evh98.lithium;

import com.badlogic.gdx.Game;
import com.evh98.lithium.screens.GameScreen;

public class Lithium extends Game{

	private GameScreen game_screen;
	
	@Override
	public void create() {
		Assets.load();
		
		game_screen = new GameScreen(this);
		
		setScreen(game_screen);
	}
}