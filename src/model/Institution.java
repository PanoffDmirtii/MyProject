package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Institution {
    private String institution;
    private List<Information> infoList = new ArrayList<>();

    public Institution(String institution, Information info) {
        Objects.requireNonNull(institution, "Text must be not empty");
        Objects.requireNonNull(info, "not be null");
        this.institution = institution;
        infoList.add(info);
    }

    public void addInformation(Information i){
        infoList.add(i);
    }

    public List<Information> getInfoList() {
        return infoList;
    }

    public String getInstitution() {
        return institution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institution that = (Institution) o;
        return Objects.equals(institution, that.institution) &&
                Objects.equals(infoList, that.infoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(institution, infoList);
    }

    @Override
    public String toString() {
        return institution + ":" + "\n"
                + infoList + "\n";
    }
}