package model;

/**
 * Class for sections PERSONAL("Личные качества"),
 * OBJECTIVE("Позиция").
 */
public class TextSection {
    private String text;

    public TextSection(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
