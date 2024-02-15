package com.education.DemoWebApp.controller;

import com.education.DemoWebApp.model.Person;
import com.education.DemoWebApp.service.PersonService;
import com.education.DemoWebApp.validation.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;
    private final PersonValidator validator;

    @Autowired
    public PersonController(PersonService service, PersonValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @GetMapping
    public String createNewPerson(@ModelAttribute("person") Person person) {
        return "/create";
    }

    @PostMapping
    public String saveNewPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        validator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        service.addPersonToDB(person);
        return "redirect:/person";
    }
}
