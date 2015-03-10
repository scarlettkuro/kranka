package commandProccessors;
import com.badlogic.gdx.InputProcessor;


public interface CommandProccessor extends InputProcessor {
	void executeAll();
}
