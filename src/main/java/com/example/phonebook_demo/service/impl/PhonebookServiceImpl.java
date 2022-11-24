package com.example.phonebook_demo.service.impl;

import com.example.phonebook_demo.dao.PhonebookDao;
import com.example.phonebook_demo.model.Phonebook;
import com.example.phonebook_demo.service.PhonebookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("phonebookService")
public class PhonebookServiceImpl implements PhonebookService {
    private PhonebookDao phonebookDao;

    public PhonebookServiceImpl(PhonebookDao phonebookDao) {
        this.phonebookDao = phonebookDao;
    }

    @Override
    public void createPhonebook(Phonebook phonebook) {
        phonebookDao.createPhonebook(phonebook);
    }
    @Override
    public void updatePhonebook(Long id, Phonebook phonebook) {
        phonebookDao.updatePhonebook(id, phonebook);
    }
    @Override
    public void deletePhonebook(Long id) {
        phonebookDao.deletePhonebook(id);
    }
    @Override
    public List<Phonebook> getPhonebooks() {
        return phonebookDao.getPhonebooks();
    }

    @Override
    public List<Phonebook> getPhonebooks(String keyword) {
        return phonebookDao.getPhonebooks(keyword);
    }
}
