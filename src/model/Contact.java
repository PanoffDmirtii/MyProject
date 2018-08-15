package model;

public enum Contact {
    ADDRESS("Адрес"),
    EMAIL("Электронная почта"),
    TELEPHONE("Номер телефона"),
    SKYPE("Skype");

    private String title;

    Contact(String title) {
        this.title = title;
    }
}
