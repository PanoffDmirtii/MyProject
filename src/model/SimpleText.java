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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleText text1 = (SimpleText) o;
        return Objects.equals(text, text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text + "\n";
    }
}