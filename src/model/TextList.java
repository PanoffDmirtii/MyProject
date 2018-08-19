package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class for sections ACHIEVEMENT("Достижения"), QUALIFICATIONS("Квалификация"),
 */
public class TextList extends Content {
    private List<String> listOfContent = new ArrayList<>();

    public TextList(String text) {
        Objects.requireNonNull(text, "Text must be not empty");
        listOfContent.add(text);
    }

    public void addToList(String content){
        listOfContent.add(content);
    }

    @Override
    public String toString() {
        return listOfContent.toString() + "\n";
    }
}