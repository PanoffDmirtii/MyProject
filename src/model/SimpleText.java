package model;

/**
 * Class for sections PERSONAL("Личные качества"),
 * OBJECTIVE("Позиция").
 */
public class SimpleText extends Content {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text + "\n";
    }
}
