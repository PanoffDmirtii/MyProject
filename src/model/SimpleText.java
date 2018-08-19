package model;

import java.util.Objects;

/**
 * Class for sections PERSONAL("Личные качества"),
 * OBJECTIVE("Позиция").
 */
public class SimpleText extends Content {
    private String text;

    public SimpleText(String text) {
        Objects.requireNonNull(text, "Text must be not empty");
        this.text = text;
    }

    @Override
    public String toString() {
        return text + "\n";
    }
}