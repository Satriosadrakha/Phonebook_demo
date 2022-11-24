package com.example.phonebook_demo;

import com.example.phonebook_demo.dao.mapper.PhonebookMapper;
import com.example.phonebook_demo.model.Phonebook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PhonebookDemoApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PhonebookDemoApplication.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(PhonebookDemoApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE IF EXISTS phonebook");
        jdbcTemplate.execute("CREATE TABLE phonebook(" +
                "id SERIAL, name VARCHAR(255), phone_number VARCHAR(255), region VARCHAR(255))");

        List<Object[]> initializeData = new ArrayList<>();
        initializeData.add(new String[]{"Rudolf", "811213631", "Kota Bandung"});
        initializeData.add(new String[]{"Agir", "811217347", "Kota Cilacap"});
        initializeData.add(new String[]{"Crysler", "811210101", "Kabupaten Sumedang"});

        jdbcTemplate.batchUpdate("INSERT INTO phonebook(name, phone_number, region) VALUES (?,?,?)", initializeData);

        log.info("Display All:");
        jdbcTemplate.query(
                "SELECT * FROM phonebook ",
                new PhonebookMapper()
        ).forEach(customer -> log.info(customer.toString()));

    }
}
