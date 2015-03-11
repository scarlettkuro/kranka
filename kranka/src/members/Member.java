package members;

import com.badlogic.gdx.utils.ObjectMap;

import components.iComponent;

public class Member {
	
	protected ObjectMap<String,iComponent> components = new ObjectMap<String,iComponent>();
		
	void init(String key, iComponent c) {
		components.put(key, c);
	}
		
	boolean is(String key) {
		return components.containsKey(key);
	}
	
	iComponent be(String key) {
		return components.get(key);
	}
	
}
