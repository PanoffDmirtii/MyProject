package model;

public class Contacts {
    private String address;
    private String email;
    private String telephone;
    private String skype;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Override
    public String toString() {
        return "Contacts: " + "\n" + "Address: " + address + "\n"
                + "Email: " + email + "\n"
                + "Telephone: " + telephone + "\n"
                + "Skype: " + skype + "\n";
    }
}