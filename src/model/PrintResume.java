package model;

import java.util.Map;

public class PrintResume {
    public static void printResumeToConsole(Resume resume){
        System.out.println(resume.getFullName());
        System.out.println(resume.getContacts());
        for (Map.Entry<SectionType, Content> section : resume.getMapSection().entrySet()) {
            System.out.println("Section: " + section.getKey().getTitle() + "\n" + section.getValue());
        }
    }
}