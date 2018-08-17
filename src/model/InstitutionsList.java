package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for sections EXPERIENCE("Опыт работы"),
 *     EDUCATION("Образование");
 */

public class InstitutionsList extends Content {
    private List<Institution> institutionsList = new ArrayList<>();


    public List<Institution> getInstitutionsList() {
        return institutionsList;
    }

    public void setInstitutionsList(List<Institution> institutionsList) {
        this.institutionsList = institutionsList;
    }

    @Override
    public String toString() {
        return institutionsList.toString() + "\n";
    }
}
