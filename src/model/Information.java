package model;


import java.time.LocalDate;
import java.util.Objects;

public class Information {
    private Link homePage;
    private String position;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Information(String nameWebSite, String url, String position, String description, LocalDate startDate, LocalDate endDate) {
        this.homePage = new Link(nameWebSite, url);
        this.position = position;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Information(String nameWebSite, String url, String description, LocalDate startDate, LocalDate endDate) {
        this.homePage = new Link(nameWebSite, url);
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Information(String description, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(position, that.position) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, position, description, startDate, endDate);
    }

    @Override
    public String toString() {
        return "homePage: " + homePage + "\n" +
                "position: '" + position + "\n" +
                "description: " + description + "\n" +
                "Data:" + startDate + " - " + endDate + "\n";
    }
}
