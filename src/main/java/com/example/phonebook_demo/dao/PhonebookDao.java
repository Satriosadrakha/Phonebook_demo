package com.example.phonebook_demo.dao;

import com.example.phonebook_demo.model.Phonebook;

import java.util.List;

public interface PhonebookDao {
    void createPhonebook(Phonebook phonebook);
    void updatePhonebook(Long id, Phonebook phonebook);
    void deletePhonebook(Long id);
    List<Phonebook> getPhonebooks();
    List<Phonebook> getPhonebooks(String keyword);
}
