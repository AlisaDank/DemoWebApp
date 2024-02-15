package com.education.DemoWebApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotEmpty(message = "Введите имя")
    @Size(min = 2, max = 20, message = "Имя ожидается длиной от 2 до 20 символов")
    @Column(name = "name")
    String name;

    @NotEmpty(message = "Введите фамилию")
    @Size(min = 2, max = 30, message = "Фамилия ожидается длиной от 2 до 30 символов")
    @Column(name = "last_name")
    String lastName;

    @NotNull(message = "Введите дату рождения")
    @Temporal(value = TemporalType.DATE)
    LocalDate birthDate;

    @Email
    @NotEmpty(message = "Введите email")
    @Column(name = "email")
    String email;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

//    public Integer getBirthYear() {
//        return birthDate.getYear();
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
