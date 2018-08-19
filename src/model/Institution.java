package model;

import java.time.LocalDate;
import java.util.Objects;

public class Institution {
    private String institution;
    private String webSite;
    private String position;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Institution(String institution, String description, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(institution, "Text must be not empty");
        Objects.requireNonNull(description, "Text must be not empty");
        this.institution = institution;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setWebSite(String webSite){
        this.webSite = webSite;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Institution: " + institution + "\n"
                + "WebSite: " + webSite + "\n"
                + "Data: " + startDate + " - "  + endDate + "\n"
                + "Position: " + position + "\n"
                + "Description: " + description;
    }
}