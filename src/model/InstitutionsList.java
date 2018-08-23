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
        for (Institution elements : institutionsList){
            if (elements.getInstitution().equals(institution.getInstitution())){
                elements.addInformation(institution.getInfoList().get(0));
            } else {
                institutionsList.add(institution);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutionsList that = (InstitutionsList) o;
        return Objects.equals(institutionsList, that.institutionsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(institutionsList);
    }

    @Override
    public String toString() {
        return institutionsList.toString() + "\n";
    }
}