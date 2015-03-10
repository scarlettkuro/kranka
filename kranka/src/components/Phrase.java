package components;

import java.util.List;

/**
 * Created by Анит on 10.03.2015.
 */
public class Phrase {
    private String text;
    private List<Answer> answers;

    public Phrase(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }
    public String getText() {
        return this.text;
    }
    public List<Answer> getAnswers() {
        return this.answers;
    }
}
