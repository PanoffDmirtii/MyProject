package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Institution {
    private String title;
    private Link homePage;
    private List<Information> infoList = new ArrayList<>();

    public Institution(String title, String website, String url, Information info) {
        Objects.requireNonNull(title, "Text must be not empty");
        Objects.requireNonNull(info, "not be null");
        this.homePage = new Link(website, url);
        this.title = title;
        infoList.add(info);
    }

    public List<Information> getInfoList() {
        return infoList;
    }

    public String getInstitution() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institution that = (Institution) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title + ":" + "\n"
                + infoList + "\n";
    }
}