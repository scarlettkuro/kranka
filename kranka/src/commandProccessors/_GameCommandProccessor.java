package commandProccessors;

import kranka.Game;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.ObjectMap;

public class _GameCommandProccessor implements InputProcessor, CommandProccessor {
	
	static protected  Object _instance = null; 
	
	static public InputProcessor inputInstance(GameCommander game) {
		if (_instance == null) _instance = new _GameCommandProccessor(game);
		return (InputProcessor)_instance;
	}
	
	static public CommandProccessor commandInstance(GameCommander game) {
		if (_instance == null) _instance = new _GameCommandProccessor(game);
		return (CommandProccessor)_instance;
	}
	
	private _GameCommandProccessor(GameCommander game) {
		this.commander = game;
		keys.put("left", Keys.LEFT);
		keys.put("right", Keys.RIGHT);
	}
	
	//---
	
	protected IntMap<Boolean> pressed = new IntMap<Boolean>();
	protected ObjectMap<String,Integer> keys = new ObjectMap<String, Integer>();
	protected GameCommander commander;
	
	public boolean keyDown(int keycode) {
		pressed.put(keycode, true);
		return true;
	}
	
	public void executeAll() {
		if (pressed.get(keys.get("left"),false))
			commander._GC_MoveLeft();
		if (pressed.get(keys.get("right"),false))
			commander._GC_MoveRight();
	}
	
	public boolean keyUp(int keycode) {
		pressed.put(keycode, false);
		return true;
	}

	
	public boolean keyTyped(char character) {
		return false;
	}

	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	
	public boolean scrolled(int amount) {
		return false;
	}
	


}
