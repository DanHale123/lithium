package com.evh98.lithium.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.evh98.lithium.Lithium;

public class GameScreen implements Screen{

	Lithium game;
	
	OrthographicCamera camera;
	SpriteBatch batch;
	ShapeRenderer shapeBatch;
	
	//18

	public static int[][] map = {{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},};
	
	public GameScreen(Lithium game){
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1080, 1920);
		
		batch = new SpriteBatch();
		shapeBatch = new ShapeRenderer();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.95F, 0.95F, 0.95F, 1F);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		shapeBatch.setProjectionMatrix(camera.combined);
		generalUpdate(camera, shapeBatch);
		
		batch.begin();
		
		batch.end();
		
		shapeBatch.begin(ShapeType.Filled);
			shapeBatch.setColor(Color.valueOf("ea565a"));
			shapeBatch.rect(90, 90, 128, 128);
		shapeBatch.end();
	}

	public void generalUpdate(OrthographicCamera camera, ShapeRenderer shapeBatch){
		
	}
	
	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}
}