package com.education.DemoWebApp.service;

import com.education.DemoWebApp.model.Person;
import com.education.DemoWebApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addPersonToDB(Person person) {
        repository.save(person);
    }

    public Optional<Person> findByEmail(String email) {
        return repository.findByEmail(email);
    }

}
