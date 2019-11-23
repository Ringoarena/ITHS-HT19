package model;

import model.enums.Gender;

import java.time.LocalDate;

public class Person {
    int id;
    String name;
    LocalDate birthDate;
    Gender gender;

    public Person(int id, String name, LocalDate localDate, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthDate = localDate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return 10;
    }

    public Gender getGender() {
        return gender;
    }
}
