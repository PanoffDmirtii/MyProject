package model;

import java.util.List;
import java.util.Objects;

/**
 * Class for sections EXPERIENCE("Опыт работы"),
 *     EDUCATION("Образование");
 */

public class InstitutionsList extends Content {
    private List<Institution> institutionsList;

    public InstitutionsList(List<Institution> institutionsList) {
        this.institutionsList = institutionsList;
    }

    public List<Institution> getInstitutionsList() {
        return institutionsList;
    }

    public void addInstitution(Institution institution){
        for (Institution element : institutionsList) {
            if (element.equals(institution)){
                element.getInfoList().addAll(institution.getInfoList());
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