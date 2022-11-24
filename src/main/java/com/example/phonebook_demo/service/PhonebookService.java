package com.example.phonebook_demo.service;

import com.example.phonebook_demo.model.Phonebook;
import com.example.phonebook_demo.model.Product;

import java.util.Collection;
import java.util.List;

public interface PhonebookService {
    void createPhonebook(Phonebook phonebook);
    void updatePhonebook(Long id, Phonebook phonebook);
    void deletePhonebook(Long id);
    List<Phonebook> getPhonebooks();
    List<Phonebook> getPhonebooks(String keyword);
}
