package com.example.phonebook_demo.dao.mapper;

import com.example.phonebook_demo.model.Phonebook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhonebookMapper implements RowMapper<Phonebook> {
    @Override
    public Phonebook mapRow(ResultSet rs, int rowNum) throws SQLException {
        Phonebook phonebook = new Phonebook();

        phonebook.setId(rs.getInt("id"));
        phonebook.setName(rs.getString("name"));
        phonebook.setPhoneNumber(rs.getString("phone_number"));
        phonebook.setRegion(rs.getString("region"));

        return phonebook;
    }
}