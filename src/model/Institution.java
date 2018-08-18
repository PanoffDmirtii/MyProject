package model;

import java.time.LocalDate;

public class Institution {
    private String institution;
    private String webSite;
    private String position;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setWebSite(String webSite){
        this.webSite = webSite;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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