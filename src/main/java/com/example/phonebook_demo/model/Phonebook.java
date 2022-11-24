package com.example.phonebook_demo.model;

public class Phonebook {
    private long id;
    private String name;
    private String phoneNumber;
    private String region;

    public Phonebook(long id, String name, String phoneNumber, String region) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.region = region;
    }

    public Phonebook() {

    }

    @Override
    public String toString() {
        return String.format(
                "Phonebook[id=%d, name='%s', phoneNumber='%s', region='%s']",
                id, name, phoneNumber, region);
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
