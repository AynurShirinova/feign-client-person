package com.example.feign.controller;
import com.example.feign.client.PersonClient;
import com.example.feign.rest.response.Person;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/persons")
@RequiredArgsConstructor
//@AllArgsConstructor
public class PersonController {

    private final PersonClient personClient;

    @GetMapping
    public ResponseEntity readPersonData(@RequestParam(required = false) String personId) {
        if (personId == null) {
            return ResponseEntity.ok(personClient.readPersons());
        }
        return ResponseEntity.ok(personClient.readPersonById(personId));
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personClient.create(person);
    }
}