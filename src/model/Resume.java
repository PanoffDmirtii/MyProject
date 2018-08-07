package model;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private String fullName;

    public Resume(String fullName) {
        this.fullName = fullName;
        this.uuid = UUID.randomUUID().toString();

    }
    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
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
        int value = this.getFullName().compareTo(o.getFullName());
        return (value == 0) ? this.getUuid().compareTo(o.getUuid()) : value;
    }

    public static class ResumeComarator implements Comparator<Resume> {

        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
}
