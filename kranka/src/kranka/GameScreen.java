package kranka;

import members.Hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import commandProccessors.iGameCommander;
import commandProccessors._GameCommandProccessor;
import components.iDrawable;
import components.iPositionable;


public class GameScreen implements Screen, iGameCommander {

	protected SpriteBatch batch;
	protected iDrawable dhero;
	protected Game game;
	float step = 0f;
	float dur = .02f;
	private iPositionable mhero;
	Texture texture = new Texture(Gdx.files.internal("-.png"));
	
	private OrthographicCamera cam;
	
	public GameScreen (Game game) {
		this.game = game;
		Gdx.input.setInputProcessor(_GameCommandProccessor.inputInstance(this));
		batch = new SpriteBatch();
		
		Object hero = new Hero();
		dhero = (iDrawable)hero;
		mhero = (iPositionable)hero;
		
		this.cam = new OrthographicCamera();
		cam.setToOrtho(false); // We want (0,0) in the bottom left corner
		//cam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() , 0); // this will render the camera so that 0,0 (of everything inside batch.begin() - batch.end()) will be rendered at 0,0 on your screen
		//cam.update(); // Updates the camera
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
		cam.position.set(mhero.getX(), Gdx.graphics.getHeight(), 0); // x and y could be changed by Keyboard input for example
		cam.update(); // Don't forget me ;)
		batch.setProjectionMatrix(cam.combined); // Tells the spritebatch to render according to your camera
		batch.begin();
		batch.draw(texture, 0, 0);
		Array<TextureRegion> frames = dhero.getFrame(delta);
		for(int i=0;i<frames.size; i++)
			batch.draw(frames.get(i),mhero.getX(),300);
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
		mhero.setX(mhero.getX()-10);
	}

	@Override
	public void _GC_MoveRight() {
		mhero.setX(mhero.getX()+10);
	}
	

}
