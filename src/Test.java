import model.*;

import java.time.LocalDate;
import java.util.Map;

public class Test {
    private static void printResumeToConsole(Resume resume){
        System.out.println(resume.getFullName());
        System.out.println(resume.getContacts());
        for (Map.Entry<SectionType, Content> section : resume.getMapSection().entrySet()) {
            System.out.println("Section: " + section.getKey().getTitle() + "\n" + section.getValue());
        }
    }
    public static void main(String[] args) {
        Resume resume = new Resume("Дмитрий Панов");

        Contacts contacts = new Contacts();
        contacts.setTelephone("+79213079075");
        contacts.setEmail("qwerty@gmail.com");
        contacts.setAddress("СПб, Невский проспект, дом 10, кв 7");
        contacts.setSkype("Panov_qwerty");

        resume.setContacts(contacts);

        SimpleText objective = new SimpleText();
        objective.setText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.addSection(SectionType.OBJECTIVE, objective);

        SimpleText personal = new SimpleText();
        personal.setText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.addSection(SectionType.PERSONAL, personal);

        TextList achievement = new TextList();
        achievement.addToList(("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity," +
                " Google Authenticator, Jira, Zendesk."));
        achievement.addToList("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT)," +
                " Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievement.addToList("Реализация протоколов по приему платежей всех основных платежных системы России" +
                " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        resume.addSection(SectionType.ACHIEVEMENT, achievement);

        TextList qualifications = new TextList();
        qualifications.addToList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.addToList("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.addToList("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        qualifications.addToList("MySQL, SQLite, MS SQL, HSQLDB");

        resume.addSection(SectionType.QUALIFICATIONS, qualifications);

        InstitutionsList experience = new InstitutionsList();
        Institution wrike = new Institution();
        wrike.setStartDate(LocalDate.of(2014, 10, 1));
        wrike.setEndDate(LocalDate.of(2016, 1, 6));
        wrike.setDescription("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        wrike.setInstitution("Wrike");
        wrike.setPosition("Старший разработчик (backend)");
        experience.addToList(wrike);

        resume.addSection(SectionType.EXPERIENCE, experience);

        InstitutionsList education = new InstitutionsList();
        Institution siemens_ag = new Institution();
        siemens_ag.setInstitution("Siemens AG");
        siemens_ag.setDescription("3 месяца обучения мобильным IN сетям (Берлин)");
        siemens_ag.setStartDate(LocalDate.of(2005, 1, 15));
        siemens_ag.setEndDate(LocalDate.of(2005, 4, 17));
        education.addToList(siemens_ag);

        resume.addSection(SectionType.EDUCATION, education);

        printResumeToConsole(resume);
    }
}
