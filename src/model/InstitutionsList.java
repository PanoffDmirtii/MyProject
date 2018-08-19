package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for sections EXPERIENCE("Опыт работы"),
 *     EDUCATION("Образование");
 */

public class InstitutionsList extends Content {
    private List<Institution> institutionsList = new ArrayList<>();

    public InstitutionsList(Institution institution) {
        institutionsList.add(institution);
    }

    public void addToList(Institution institution){
        institutionsList.add(institution);
    }

    @Override
    public String toString() {
        return institutionsList.toString() + "\n";
    }
}