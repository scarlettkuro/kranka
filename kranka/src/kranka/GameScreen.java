package kranka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import components.Drawable;
import components._SpriteDrawable;


public class GameScreen implements Screen {

	private SpriteBatch batch;
	Drawable anim;
	public GameScreen (Game game) {
		
		batch = new SpriteBatch();
		anim = new _SpriteDrawable("pic3.png", 2, 2, .5f);
	}
	
	@Override
	public void render(float delta) {
		
		
		batch.begin();
		Array<TextureRegion> frames = anim.getFrame(delta);
		for(int i=0;i<frames.size; i++)
		batch.draw(frames.get(i),100 + (frames.get(i).getRegionWidth()+20)*i,100);
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
		//texture.dispose();
	}
	

}
