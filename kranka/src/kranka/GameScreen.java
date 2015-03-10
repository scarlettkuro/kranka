package kranka;

import members.Hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import commandProccessors.GameCommander;
import commandProccessors._GameCommandProccessor;
import components.Drawable;
import components.Positionable;


public class GameScreen implements Screen, GameCommander {

	protected SpriteBatch batch;
	protected Drawable dhero;
	protected Game game;
	float step = 0f;
	float dur = .5f;
	private Positionable mhero;
	
	public GameScreen (Game game) {
		this.game = game;
		Gdx.input.setInputProcessor(_GameCommandProccessor.inputInstance(this));
		batch = new SpriteBatch();
		
		Object hero = new Hero();
		dhero = (Drawable)hero;
		mhero = (Positionable)hero;
		
	}
	
	@Override
	public void render(float delta) {
		step += delta;
		if (step>dur) {
			_GameCommandProccessor.commandInstance(this).executeAll();
			step = step % delta;
		}
		//System.out.println(delta);
		//
		batch.begin();
		Array<TextureRegion> frames = dhero.getFrame(delta);
		for(int i=0;i<frames.size; i++)
			batch.draw(frames.get(i),mhero.getX(),100);
		batch.end();
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
	@Override
	public void pause() {
		
	}
	@Override
	public void resume() {
		
	}
	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void _GC_MoveLeft() {
		mhero.setX(mhero.getX()-100);
	}

	@Override
	public void _GC_MoveRight() {
		mhero.setX(mhero.getX()+100);
	}
	

}
