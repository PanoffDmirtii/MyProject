package model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Information implements Serializable {
    private static final long serialVersionUID = 1L;
    private String position;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Information(String description, LocalDate startDate, LocalDate endDate) {
        this(description, startDate, endDate, "Not Specified");
    }

    public Information(String description, LocalDate startDate, LocalDate endDate, String position) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return Objects.equals(position, that.position) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, description, startDate, endDate);
    }

    @Override
    public String toString() {
        return  "position: '" + position + "\n" +
                "description: " + description + "\n" +
                "Data:" + startDate + " - " + endDate + "\n";
    }
}