package model;

import java.util.Comparator;

public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private String fullName;

    public Resume(String uuid) {
        this.uuid = uuid;

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

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public int compareTo(Resume o) {
        return this.uuid.compareTo(o.uuid);
    }

    public static class ResumeFullNameComarator implements Comparator<Resume> {

        @Override
        public int compare(Resume o1, Resume o2) {
            int value = o1.getFullName().compareTo(o2.getFullName());
            if (value > 0) {
                return 1;
            } else if (value == 0) {
                return o1.getUuid().compareTo(o2.getUuid());
            }
            return -1;
        }
    }
}
