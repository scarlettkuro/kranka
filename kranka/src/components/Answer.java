package components;

/**
 * Created by Анит on 10.03.2015.
 */
public class Answer {
    private String answerText;
    private String key;

    public Answer(String text, String key) {
        this.answerText = text;
        this.key = key;
    }
    public String getAnswerText() {
        return this.answerText;
    }
    public String getKey() {
        return this.key;
    }
}
