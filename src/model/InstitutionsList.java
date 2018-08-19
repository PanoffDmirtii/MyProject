package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class for sections EXPERIENCE("Опыт работы"),
 *     EDUCATION("Образование");
 */

public class InstitutionsList extends Content {
    private List<Institution> institutionsList = new ArrayList<>();

    public InstitutionsList(Institution institution) {
        Objects.requireNonNull(institution, "not null");
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