package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for sections ACHIEVEMENT("Достижения"), QUALIFICATIONS("Квалификация"),
 */
public class TextList extends Content {
    private List<String> listOfcontent = new ArrayList<>();

    public void addToList(String content){
        listOfcontent.add(content);
    }

    public List<String> getListOfcontent() {
        return listOfcontent;
    }

    @Override
    public String toString() {

        return listOfcontent.toString() + "\n";
    }
}
