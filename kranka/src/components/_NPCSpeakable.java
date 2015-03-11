package components;

import java.util.Map;

/**
 * Created by Анит on 10.03.2015.
 */
public class _NPCSpeakable implements iSpeakable{
    private Map<String, Phrase> dialog;

    public _NPCSpeakable(Map<String, Phrase> dialog) {
        this.dialog = dialog;
    }

    public Phrase getPhrase(String key) {
        if (this.dialog.containsKey(key)) {
            return this.dialog.get(key);
        }
        return null;
    }

	public String myName() {
		return "Speakable";
	}
}
