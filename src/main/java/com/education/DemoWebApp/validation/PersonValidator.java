package com.education.DemoWebApp.validation;

import com.education.DemoWebApp.model.Person;
import com.education.DemoWebApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonService service;

    @Autowired
    public PersonValidator(PersonService service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (service.findByEmail(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "",
                    "Пользователь с таким email уже существует");
        }

//        if (person.getBirthYear() < 1900) {
//            errors.rejectValue("birthDate", "", "Введите корректный год рождения");
//        }
    }
}
