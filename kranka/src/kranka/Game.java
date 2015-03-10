package kranka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;


public class Game extends com.badlogic.gdx.Game  {
	Screen screen;
	
	@Override
	public void create() {		
		screen = new GameScreen(this);
		this.setScreen(screen);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		screen.render(Gdx.graphics.getDeltaTime());
		
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
