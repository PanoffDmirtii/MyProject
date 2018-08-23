package storage;


import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorageTest {
    protected Storage storage;

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
    protected static final Resume RESUME_4 = new Resume(UUID_4,"Evgenii Pupkin");



    @Before
    public void setUp() {
        storage.clear();
        RESUME_1.addContact(Contacts.ADDRESS, "СПб, Невский проспект, дом 10, кв 7");
        RESUME_1.addContact(Contacts.EMAIL, "qwerty@gmail.com");
        RESUME_1.addContact(Contacts.TELEPHONE, "+79213079075");
        RESUME_1.addContact(Contacts.SKYPE, "Panov_qwerty");

        SimpleText objective1 = new SimpleText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        RESUME_1.addSection(SectionType.OBJECTIVE, objective1);

        SimpleText personal1 = new SimpleText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        RESUME_1.addSection(SectionType.PERSONAL, personal1);

        TextList achievement1 = new TextList("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity," +
                " Google Authenticator, Jira, Zendesk.");
        achievement1.addToList("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT)," +
                " Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievement1.addToList("Реализация протоколов по приему платежей всех основных платежных системы России" +
                " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        RESUME_1.addSection(SectionType.ACHIEVEMENT, achievement1);

        TextList qualifications1 = new TextList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications1.addToList("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications1.addToList("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        qualifications1.addToList("MySQL, SQLite, MS SQL, HSQLDB");
        RESUME_1.addSection(SectionType.QUALIFICATIONS, qualifications1);

        Information infoWrike = new Information("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",LocalDate.of(2014, 10, 1),
                LocalDate.of(2016, 1, 6), "Старший разработчик (backend)");
        Institution wrike1 = new Institution("Wrike","", "", infoWrike);
        List<Institution> list1 = new ArrayList<>();
        list1.add(wrike1);
        InstitutionsList experience1 = new InstitutionsList(list1);
        RESUME_1.addSection(SectionType.EXPERIENCE, experience1);


        Information infoSiements = new Information("3 месяца обучения мобильным IN сетям (Берлин)",
                LocalDate.of(2005, 1, 15),
                LocalDate.of(2005, 4, 17));
        Institution siemens_ag1 = new Institution("Siemens AG","", "",  infoSiements);
        List<Institution> list2 = new ArrayList<>();
        list2.add(siemens_ag1);
        InstitutionsList education1 = new InstitutionsList(list2);
        RESUME_1.addSection(SectionType.EDUCATION, education1);



        /**
         *
         */
        RESUME_3.addContact(Contacts.ADDRESS, "СПб, проспект Ленина, дом 15, кв 2");
        RESUME_3.addContact(Contacts.EMAIL, "drtdrt@gmail.com");
        RESUME_3.addContact(Contacts.TELEPHONE, "+8989989898");
        RESUME_3.addContact(Contacts.SKYPE, "Panov_qwerty");

        SimpleText objective3 = new SimpleText("Ведущий стажировок и корпоративного обучения по Python Web и Enterprise технологиям");
        RESUME_3.addSection(SectionType.OBJECTIVE, objective3);

        SimpleText personal3 = new SimpleText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        RESUME_3.addSection(SectionType.PERSONAL, personal3);

        TextList achievement3 = new TextList("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP." +
                " Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery." +
                " Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievement3.addToList("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish)." +
                " Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios." +
                " Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        RESUME_3.addSection(SectionType.ACHIEVEMENT, achievement3);

        TextList qualifications3 = new TextList("Python: Django.");
        qualifications3.addToList("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualifications3.addToList("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualifications3.addToList("проектрирования, архитектурных шаблонов, UML, функционального");
        RESUME_3.addSection(SectionType.QUALIFICATIONS, qualifications3);


        Information infoYota = new Information("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\"" +
                " (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2).", LocalDate.of(2008, 6, 1),
                LocalDate.of(2010, 12, 1), "Ведущий специалист");
        Institution yota = new Institution("Yota","", "", infoYota);


        Information infoEnkata = new Information("Реализация клиентской (Eclipse RCP)" +
                " и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS)" +
                " частей кластерного J2EE приложения (OLAP, Data mining).",
                LocalDate.of(2007, 3, 1),
                LocalDate.of(208, 6, 1),"Разработчик ПО");
        Institution enkata = new Institution("Enkata","Enkata","http://enkata.com/", infoEnkata);

        List<Institution> list3 = new ArrayList<>();
        list3.add(yota);
        list3.add(enkata);
        InstitutionsList experience3 = new InstitutionsList(list3);
        RESUME_3.addSection(SectionType.EXPERIENCE, experience3);


        Information infoAlcatel = new Information("6 месяцев обучения цифровым телефонным сетям (Москва)",
                LocalDate.of(2005, 1, 15),
                LocalDate.of(2005, 4, 17));
        Institution alcatel = new Institution("Alcatel","","", infoAlcatel);
        List<Institution> list4 = new ArrayList<>();
        list4.add(alcatel);
        InstitutionsList education3 = new InstitutionsList(list4);
        RESUME_3.addSection(SectionType.EDUCATION, education3);
/**
 *
 */
        RESUME_3.addContact(Contacts.ADDRESS, "СПб, проспект Стачек, дом 115, кв 36");
        RESUME_3.addContact(Contacts.EMAIL, "erterte@gmail.com");
        RESUME_3.addContact(Contacts.TELEPHONE, "+989898988777774");
        RESUME_3.addContact(Contacts.SKYPE, "Panov_qwerty");

        Information infoUniversity1 = new Information("Аспирантура (программист С, С++)",
                LocalDate.of(1993, 1, 15),
                LocalDate.of(1996, 4, 17));
        Institution spbTI1 = new Institution("SPBTI","","", infoUniversity1);

        Information infoUniversity2 = new Information("Инженер (программист Fortran, C)",
                LocalDate.of(1987, 3, 15),
                LocalDate.of(1993, 7, 17));
        Institution spbTI2 = new Institution("SPBTI","","", infoUniversity2);
        List<Institution> list5 = new ArrayList<>();
        list5.add(spbTI1);
        InstitutionsList education4 = new InstitutionsList(list5);
        education4.addInstitution(spbTI2);
        RESUME_3.addSection(SectionType.EDUCATION, education3);



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
        Assert.assertEquals(sortedResume, storage.getAllSorted());
    }


    @Test
    public void size() {
        Assert.assertEquals(3,storage.size());
    }
}