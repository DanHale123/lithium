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

	int[][] tiles = new int[12][18];
	
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
			for(int x=0; x<10; x++){
				for(int y=0; y<20; y++){
					if(tiles[x][y]==1){
						shapeBatch.setColor(Color.ORANGE);
						shapeBatch.rect(x*90, y*90, 90, 90);
					}else{
						
					}
				}
			}
		shapeBatch.end();
	}

	public void generalUpdate(OrthographicCamera camera, ShapeRenderer shapeBatch){
		
	}
	
	public void drawCell(ShapeRenderer shapeBatch, Color color, int x, int y){
		tiles[x][y] = 1;
	}
	
	public void drawToken(ShapeRenderer shapeBatch, Color color, int x, int y){
		drawCell(shapeBatch, color, x+0, y+0);
		drawCell(shapeBatch, color, x+0, y+1);
		drawCell(shapeBatch, color, x+1, y+1);
		drawCell(shapeBatch, color, x+2, y+0);
	}
	
	public void eraseCell(ShapeRenderer shapeBatch, int x, int y){
		tiles[x][y] = 0;
		shapeBatch.setColor(Color.valueOf("f7f7f8"));
		shapeBatch.rect(x*90, y*90, 90, 90);
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