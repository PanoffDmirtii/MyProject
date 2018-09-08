package model;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;

    // Unique identifier
    private final String uuid;
    private String fullName;
    private Map<SectionType, Content> mapSection = new EnumMap<>(SectionType.class);
    private Map<Contacts, String> mapContact = new EnumMap<>(Contacts.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must be not null");
        Objects.requireNonNull(fullName, "fullName must be not null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public void addSection(SectionType type, Content content) {
        mapSection.put(type, content);
    }

    public void addContact(Contacts type, String text) {
        mapContact.put(type, text);
    }

    public Map<SectionType, Content> getMapSection() {
        return mapSection;
    }

    public Map<Contacts, String> getMapContact() {
        return mapContact;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "UUID: " + uuid + "\n"
                + "Full name: " + fullName;
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