import model.*;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Resume resume = new Resume("Дмитрий Панов");

        Contacts contacts = new Contacts();
        contacts.setTelephone("+79213079075");
        contacts.setEmail("qwerty@gmail.com");
        contacts.setAddress("СПб, Невский проспект, дом 10, кв 7");
        contacts.setSkype("Panov_qwerty");

        resume.setContacts(contacts);

        Content content1 = new SimpleText();
        ((SimpleText) content1).setText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.addSection(SectionType.OBJECTIVE, content1);

        Content content2 = new SimpleText();
        ((SimpleText) content2).setText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.addSection(SectionType.PERSONAL, content2);

        Content content3 = new TextList();
        ((TextList) content3).addToList(("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity," +
                " Google Authenticator, Jira, Zendesk."));
        ((TextList) content3).addToList("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT)," +
                " Commet, HTML5, Highstock для алгоритмического трейдинга.");
        ((TextList) content3).addToList("Реализация протоколов по приему платежей всех основных платежных системы России" +
                " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        resume.addSection(SectionType.ACHIEVEMENT, content3);

        Content content4 = new TextList();
        ((TextList) content4).addToList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        ((TextList) content4).addToList("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        ((TextList) content4).addToList("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        ((TextList) content4).addToList("MySQL, SQLite, MS SQL, HSQLDB");

        resume.addSection(SectionType.QUALIFICATIONS, content4);

        Content content5 = new InstitutionsList();
        Institution wrike = new Institution();
        wrike.setStartDate(LocalDate.of(2014, 10, 1));
        wrike.setEndDate(LocalDate.of(2016, 1, 6));
        wrike.setDescription("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        wrike.setInstitution("Wrike");
        wrike.setPosition("Старший разработчик (backend)");
        ((InstitutionsList) content5).addToList(wrike);

        resume.addSection(SectionType.EXPERIENCE, content5);

        Content content6 = new InstitutionsList();
        Institution siemens_ag = new Institution();
        siemens_ag.setInstitution("Siemens AG");
        siemens_ag.setDescription("3 месяца обучения мобильным IN сетям (Берлин)");
        siemens_ag.setStartDate(LocalDate.of(2005, 1, 15));
        siemens_ag.setEndDate(LocalDate.of(2005, 4, 17));
        ((InstitutionsList) content6).addToList(siemens_ag);

        resume.addSection(SectionType.EDUCATION, content6);

        PrintResume.printResumeToConsole(resume);
    }
}
