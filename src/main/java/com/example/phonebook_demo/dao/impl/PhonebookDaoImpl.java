package com.example.phonebook_demo.dao.impl;

import com.example.phonebook_demo.PhonebookDemoApplication;
import com.example.phonebook_demo.dao.PhonebookDao;
import com.example.phonebook_demo.dao.mapper.PhonebookMapper;
import com.example.phonebook_demo.model.Phonebook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository("phonebookDao")
public class PhonebookDaoImpl implements PhonebookDao {
    private static final Logger logger = LoggerFactory.getLogger(PhonebookDaoImpl.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createPhonebook(Phonebook phonebook) {
        logger.info("DAO createPhonebook");
        String stringQuery = "INSERT INTO phonebook VALUES (?, ?, ?, ?);";
        Object[] args = new Object[] {phonebook.getId(),phonebook.getName(),phonebook.getPhoneNumber(),phonebook.getRegion()};

        jdbcTemplate.update(stringQuery,args);
    }

    @Override
    public void updatePhonebook(Long id, Phonebook phonebook) {
        logger.info("DAO updatePhonebook");
        String stringQuery = "UPDATE phonebook " +
                "SET name = ?, phone_number = ?, region = ? " +
                "WHERE id = ?;";
        Object[] args = new Object[] {phonebook.getName(),phonebook.getPhoneNumber(),phonebook.getRegion(),
                id};

        jdbcTemplate.update(stringQuery,args);
    }

    @Override
    public void deletePhonebook(Long id) {
        logger.info("DAO deletePhonebook");
        String stringQuery = "DELETE FROM phonebook WHERE id = ?;";
        Object[] args = new Object[] {id};

        jdbcTemplate.update(stringQuery,args);

    }
    @Override
    public List<Phonebook> getPhonebooks() {
        logger.info("DAO getPhonebooks");
        String stringQuery = "SELECT * FROM phonebook;";

        List<Phonebook> phonebookList = jdbcTemplate.query(
                stringQuery,
                new PhonebookMapper()
        );
        return phonebookList;
    }

    @Override
    public List<Phonebook> getPhonebooks(String keyword) {
        logger.info("DAO getPhonebooks with keyword: " + keyword);
        keyword = "%" + keyword + "%";
        String stringQuery = "SELECT * FROM phonebook " +
                " WHERE name LIKE ?; " ;
//                " OR phone_number LIKE '%?%' " +
//                " OR region LIKE '%?%' ;";
//        Object[] args = new Object[] {keyword,keyword,keyword};
        Object[] args = new Object[] {keyword};

        List<Phonebook> phonebookList = jdbcTemplate.query(
                stringQuery,
                new PhonebookMapper(),
                args
        );
        return phonebookList;
    }
}
