package model;

public enum Contacts {
    ADDRESS("Адресс"),
    EMAIL("E-mail"),
    TELEPHONE("Телефон"),
    SKYPE("Skype");

    private String title;

    Contacts(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
