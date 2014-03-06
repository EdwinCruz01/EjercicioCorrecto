
package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite2;
	private Sprite sprite;
	private Texture texture2;
	private Sprite sprite3;
	private Texture texture3;
	private Sprite sprite4;
	private Texture texture4;
	int rotacion=0;
	float translate;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		texture2=new Texture(Gdx.files.internal("data/enemigo.png"));
		sprite2=new Sprite(texture2,128,128);
		sprite2.setPosition(-0.2f, -0.2f);
		sprite2.setSize(0.5f,0.5f);
		sprite2.setOrigin(sprite2.getWidth()/2, sprite2.getHeight()/2);
		
		texture3=new Texture(Gdx.files.internal("data/fondo.png"));
		sprite3=new Sprite(texture3,128,64);
		sprite3.setPosition(-0.1f, -0.1f);
		sprite3.setSize(0.5f,0.5f);
		
		texture4=new Texture(Gdx.files.internal("data/nave.png"));
		sprite4=new Sprite(texture4,128,64);
		sprite4.setPosition(-0.5f, -0.1f);
		sprite4.setSize(0.3f,0.3f);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite2.setX(translate);

		sprite3.draw(batch);
		sprite4.draw(batch);
		sprite2.draw(batch);
		batch.end();
		sprite2.setRotation(rotacion);
		rotacion+=0.1f;
		if(Gdx.input.isTouched())
		{
		translate-=0.01;
		rotacion+=20;
		
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
