import model.*;

import java.time.LocalDate;
import java.util.Map;

public class Test {
    private static void printResumeToConsole(Resume resume){
        System.out.println(resume.getFullName());
        for (Map.Entry<Contacts, String> contact : resume.getMapContact().entrySet()){
            System.out.println(contact.getKey().getTitle() + ": " + contact.getValue());
        }
        System.out.println();
        for (Map.Entry<SectionType, Content> section : resume.getMapSection().entrySet()) {
            System.out.println(section.getKey().getTitle() + ":\n" + section.getValue());
        }
    }
    public static void main(String[] args) {
        Resume resume = new Resume("Дмитрий Панов");

        resume.addContact(Contacts.ADDRESS, "СПб, Невский проспект, дом 10, кв 7");
        resume.addContact(Contacts.EMAIL, "qwerty@gmail.com");
        resume.addContact(Contacts.TELEPHONE, "+79213079075");
        resume.addContact(Contacts.SKYPE, "Panov_qwerty");


        SimpleText objective = new SimpleText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.addSection(SectionType.OBJECTIVE, objective);

        SimpleText personal = new SimpleText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.addSection(SectionType.PERSONAL, personal);

        TextList achievement = new TextList("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity," +
                " Google Authenticator, Jira, Zendesk.");
        achievement.addToList("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT)," +
                " Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievement.addToList("Реализация протоколов по приему платежей всех основных платежных системы России" +
                " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        resume.addSection(SectionType.ACHIEVEMENT, achievement);

        TextList qualifications = new TextList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.addToList("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.addToList("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        qualifications.addToList("MySQL, SQLite, MS SQL, HSQLDB");

        resume.addSection(SectionType.QUALIFICATIONS, qualifications);

        Institution wrike = new Institution("Wrike", "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                LocalDate.of(2014, 10, 1),
                LocalDate.of(2016, 1, 6));
        wrike.setPosition("Старший разработчик (backend)");
        InstitutionsList experience = new InstitutionsList(wrike);
        experience.addToList(wrike);

        resume.addSection(SectionType.EXPERIENCE, experience);

        Institution siemens_ag = new Institution("Siemens AG", "3 месяца обучения мобильным IN сетям (Берлин)",
                LocalDate.of(2005, 1, 15),
                LocalDate.of(2005, 4, 17));
        InstitutionsList education = new InstitutionsList(siemens_ag);
        education.addToList(siemens_ag);

        resume.addSection(SectionType.EDUCATION, education);

        printResumeToConsole(resume);
    }
}
