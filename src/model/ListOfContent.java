package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for sections ACHIEVEMENT("Достижения"), QUALIFICATIONS("Квалификация"),
 * EXPERIENCE("Опыт работы"), EDUCATION("Образование").
 */
public class ListOfContent {
    private List<String> listOfcontent = new ArrayList<>();
    private LocalDate data;
    private String org;

    public ListOfContent() {
    }

    public ListOfContent(String org, LocalDate data) {
        this.org = org;
        this.data = data;
    }

    public void addToList(String content){
        listOfcontent.add(content);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    @Override
    public String toString() {
        return "ListOfContent{" +
                "listOfcontent=" + listOfcontent +
                ", data=" + data +
                ", org='" + org + '\'' +
                '}';
    }
}
