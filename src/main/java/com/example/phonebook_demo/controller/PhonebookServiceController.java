package com.example.phonebook_demo.controller;

import com.example.phonebook_demo.model.Phonebook;
import com.example.phonebook_demo.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class PhonebookServiceController {
    @Autowired
    PhonebookService phonebookService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/phonebooks")
    public ResponseEntity<Object> getPhonebooks() {
        return new ResponseEntity<>(phonebookService.getPhonebooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/phonebooks", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Phonebook phonebook) {
        phonebookService.createPhonebook(phonebook);
        return new ResponseEntity<>("Phonebook is created elegantly", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/phonebooks/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Phonebook phonebook) {
        phonebookService.updatePhonebook(id, phonebook);
        return new ResponseEntity<>("Product is updated elegantly", HttpStatus.OK);
    }

    @RequestMapping(value = "/phonebooks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        phonebookService.deletePhonebook(id);
        return new ResponseEntity<>("Product is deleted elegantly", HttpStatus.OK);
    }

    @RequestMapping(value = "/phonebooksSearch/{keyword}")
    public ResponseEntity<Object> getPhonebooks(@PathVariable("keyword") String keyword) {
        return new ResponseEntity<>(phonebookService.getPhonebooks(keyword), HttpStatus.OK);
    }
}
