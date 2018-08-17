package model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private String fullName;
    private Contacts contacts;
    private EnumMap<SectionType, Content> mapSection = new EnumMap<>(SectionType.class);


    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must be not null");
        Objects.requireNonNull(fullName, "fullName must be not null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public void addSection(SectionType type, Content content){
        mapSection.put(type, content);
    }

    public void printResume(){
        System.out.println(fullName);
        System.out.println(contacts);
        for (Map.Entry<SectionType, Content> section : mapSection.entrySet()) {
            System.out.println("Section: " + section.getKey().getTitle() + "\n" + section.getValue());
        }
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public int compareTo(Resume o) {
        int value = fullName.compareTo(o.fullName);
        return (value == 0) ? uuid.compareTo(o.uuid) : value;
    }


}
