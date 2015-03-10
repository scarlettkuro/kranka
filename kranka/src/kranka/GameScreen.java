package kranka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import commandProccessors.GameCommander;
import commandProccessors._GameCommandProccessor;
import components.Drawable;
import components._SpriteDrawable;
//import _

public class GameScreen implements Screen, GameCommander {

	protected SpriteBatch batch;
	protected Drawable anim;
	protected Game game;
	int x  = 100;
	float step = 0f;
	float dur = .5f;
	public GameScreen (Game game) {
		this.game = game;
		batch = new SpriteBatch();
		anim = new _SpriteDrawable("pic3.png", 2, 2, .5f);
		Gdx.input.setInputProcessor(_GameCommandProccessor.inputInstance(this));
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
		Array<TextureRegion> frames = anim.getFrame(delta);
		for(int i=0;i<frames.size; i++)
		batch.draw(frames.get(i),x,100);
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
		x -=100;
	}

	@Override
	public void _GC_MoveRight() {
		x +=100;
	}
	

}
