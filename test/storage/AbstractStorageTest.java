package storage;


import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorageTest {
    protected Storage storage;
    protected static final File DIR_STORAGE_RESUME = new File("C:\\Users\\XS\\basejava\\storage_resume");
    protected static final Path PATH_STORAGE_RESUME = Paths.get(DIR_STORAGE_RESUME.getAbsolutePath());

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid_1";
    private static final String UUID_2 = "uuid_2";
    private static final String UUID_3 = "uuid_3";
    private static final String UUID_4 = "uuid_4";
    private static final Resume RESUME_1 = new Resume(UUID_1, "Dmitrii Panov");
    private static final Resume RESUME_2 = new Resume(UUID_2, "Nikolay Aprelev");
    private static final Resume RESUME_3 = new Resume(UUID_3, "Dmitrii Panov");
    private static final Resume RESUME_3_UPDATE = new Resume(UUID_3, "Puzanova Irina");
    protected static final Resume RESUME_4 = new Resume(UUID_4, "Evgenii Pupkin");

    {
        RESUME_1.addContact(Contacts.ADDRESS, "СПб, Невский проспект, дом 10, кв 7");
        RESUME_1.addContact(Contacts.EMAIL, "qwerty@gmail.com");
        RESUME_1.addContact(Contacts.TELEPHONE, "+8768743543");
        RESUME_1.addContact(Contacts.SKYPE, "Panov_qwerty");

        RESUME_1.addSection(SectionType.OBJECTIVE, new SimpleText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        RESUME_1.addSection(SectionType.PERSONAL, new SimpleText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        RESUME_1.addSection(SectionType.ACHIEVEMENT, new TextList(Arrays.asList("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity," +
                " Google Authenticator, Jira, Zendesk.", "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT)," +
                " Commet, HTML5, Highstock для алгоритмического трейдинга.", "Реализация протоколов по приему платежей всех основных платежных системы России" +
                " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.")));
        RESUME_1.addSection(SectionType.QUALIFICATIONS, new TextList(Arrays.asList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,",
                "MySQL, SQLite, MS SQL, HSQLDB")));
        RESUME_1.addSection(SectionType.EXPERIENCE, new InstitutionsList(Arrays.asList(
                new Institution("Wrike","", "", Arrays.asList(
                        new Information("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                                LocalDate.of(2014, 10, 1),
                                LocalDate.of(2016, 1, 6),
                                "Старший разработчик (backend)"))),
                new Institution("Java Online Projects", "", "", Arrays.asList(
                        new Information("Создание, организация и проведение Java онлайн проектов и стажировок.",
                                LocalDate.of(2013,10,1),
                                LocalDate.now(),
                                "Автор проекта"))))));
        RESUME_1.addSection(SectionType.EDUCATION, new InstitutionsList(Arrays.asList(
                new Institution("Siemens AG","", "",  Arrays.asList(
                        new Information(
                                "3 месяца обучения мобильным IN сетям (Берлин)",
                                LocalDate.of(2005, 1, 15),
                                LocalDate.of(2005, 4, 17)),
                        new Information("Аспирантура (программист С, С++)",
                                LocalDate.of(1993, 1, 15),
                                LocalDate.of(1996, 4, 17)),
                        new Information("Курс Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.",
                                LocalDate.of(2011,3,1),
                                LocalDate.of(2011,4,1)))))));



        RESUME_3.addContact(Contacts.ADDRESS, "СПб, Ленинский проспект, дом 110, кв 57");
        RESUME_3.addContact(Contacts.EMAIL, "gdsrgdrg@gmail.com");
        RESUME_3.addContact(Contacts.TELEPHONE, "+78989989");
        RESUME_3.addContact(Contacts.SKYPE, "Panoff_qwerty");

        RESUME_3.addSection(SectionType.OBJECTIVE, new SimpleText("Ведущий стажировок и корпоративного обучения по Python и Enterprise технологиям"));
        RESUME_3.addSection(SectionType.PERSONAL, new SimpleText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        RESUME_3.addSection(SectionType.ACHIEVEMENT, new TextList(Arrays.asList("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," +
                        " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"." +
                        " Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT)," +
                        " Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Реализация протоколов по приему платежей всех основных платежных системы России" +
                        " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike." +
                        " Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.")));
        RESUME_3.addSection(SectionType.QUALIFICATIONS, new TextList(Arrays.asList("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet," +
                        " HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,",
                "MySQL, SQLite, MS SQL, HSQLDB",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix")));
        RESUME_3.addSection(SectionType.EXPERIENCE, new InstitutionsList(Arrays.asList(
                new Institution("Luxoft (Deutsche Bank)","Luxoft", "https://www.luxoft.ru/", Arrays.asList(
                        new Information("Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM." +
                                " Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга." +
                                " JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.",
                                LocalDate.of(2010, 12, 1),
                                LocalDate.of(2012, 4, 6),
                                "Ведущий программист"))),
                new Institution("Enkata", "", "http://enkata.com/", Arrays.asList(
                        new Information("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
                                LocalDate.of(2007,3,1),
                                LocalDate.of(2008,6,1),
                                "Разработчик ПО"))))));
        RESUME_3.addSection(SectionType.EDUCATION, new InstitutionsList(Arrays.asList(
                new Institution("Заочная физико-техническая школа при МФТИ","", "",  Arrays.asList(
                        new Information(
                                "Закончил с отличием",
                                LocalDate.of(1984, 9, 1),
                                LocalDate.of(1987, 6, 1)))),
                new Institution("Luxoft", "", "", Arrays.asList(
                        new Information("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                                LocalDate.of(2011, 3, 1),
                                LocalDate.of(2011, 4, 1)))))));



        RESUME_2.addContact(Contacts.ADDRESS, "СПб, Проспект Большивиков, дом 50, кв 20");
        RESUME_2.addContact(Contacts.EMAIL, "fererere@gmail.com");
        RESUME_2.addContact(Contacts.TELEPHONE, "+8454343435435");
        RESUME_2.addContact(Contacts.SKYPE, "rwerwerewrw_erere");

        RESUME_2.addSection(SectionType.OBJECTIVE, new SimpleText("Ведущий стажировок и корпоративного обучения по Python и Enterprise технологиям"));
        RESUME_2.addSection(SectionType.PERSONAL, new SimpleText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        RESUME_2.addSection(SectionType.ACHIEVEMENT, new TextList(Arrays.asList(
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк)," +
                        " Белоруcсии(Erip, Osmp) и Никарагуа.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish)." +
                        " Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios." +
                        " Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).")));
        RESUME_2.addSection(SectionType.QUALIFICATIONS, new TextList(Arrays.asList(
                "Python: Django.",
                "программирования",
                "проектрирования, архитектурных шаблонов, UML, функционального",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов")));
        RESUME_2.addSection(SectionType.EXPERIENCE, new InstitutionsList(Arrays.asList(
                new Institution("RIT Center","", "", Arrays.asList(
                        new Information("Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins)," +
                                " миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO." +
                                " Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html)." +
                                " Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development," +
                                " Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                                LocalDate.of(2012, 4, 1),
                                LocalDate.of(2014, 10, 1),
                                "Java архитектор"))),
                new Institution("Enkata", "", "http://enkata.com/", Arrays.asList(
                        new Information("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
                                LocalDate.of(2007,3,1),
                                LocalDate.of(2008,6,1),
                                "Разработчик ПО"))))));
        RESUME_2.addSection(SectionType.EDUCATION, new InstitutionsList(Arrays.asList(
                new Institution("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики","", "",  Arrays.asList(
                        new Information(
                                "Аспирантура (программист С, С++)",
                                LocalDate.of(1993, 9, 1),
                                LocalDate.of(1996, 6, 1)),
                        new Information("Инженер (программист Fortran, C)",
                                LocalDate.of(1987, 5, 1),
                                LocalDate.of(1993, 3, 1)))),
                new Institution("Luxoft", "", "", Arrays.asList(
                        new Information("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                                LocalDate.of(2011, 3, 1),
                                LocalDate.of(2011, 4, 1)))))));
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_3);
        storage.save(RESUME_2);
    }

    @Test
    public void saveNewResume() {
        storage.save(RESUME_4);
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistUuidException.class)
    public void saveExistResume() {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistUuidException.class)
    public void deleteNotExistResume() {
        storage.delete(UUID_4);
    }

    @Test
    public void deleteExistResume() {
        storage.delete(UUID_2);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void updateExistResume() {
        storage.update(RESUME_3_UPDATE);
        Assert.assertEquals(RESUME_3_UPDATE, storage.get(UUID_3));
    }

    @Test(expected = NotExistUuidException.class)
    public void updateNotExistResume() {
        storage.update(RESUME_4);
    }

    @Test(expected = NotExistUuidException.class)
    public void getNotExistResume() {
        storage.get(RESUME_4.getUuid());
    }

    @Test
    public void getExistResume() {
        Assert.assertEquals(RESUME_3, storage.get(UUID_3));
    }

    @Test
    public void getAllSorted() {
        List<Resume> sortedResume = Arrays.asList(RESUME_1,RESUME_2,RESUME_3);
        Collections.sort(sortedResume);
        try {
            Assert.assertEquals(sortedResume, storage.getAllSorted());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void size() {
        Assert.assertEquals(3,storage.size());
    }
}