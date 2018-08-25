package model;

import java.util.List;
import java.util.Objects;

/**
 * Class for sections ACHIEVEMENT("Достижения"), QUALIFICATIONS("Квалификация"),
 */
public class TextList extends Content {
    private List<String> textList;

    public TextList(List<String> textList) {
        Objects.requireNonNull(textList, "Text must be not empty");
        this.textList = textList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextList textList1 = (TextList) o;
        return Objects.equals(textList, textList1.textList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textList);
    }

    @Override
    public String toString() {
        return textList + " ";
    }
}