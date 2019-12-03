package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idpersons")
    int id;

    @Column(name="name")
    String name;

    @Column(name="dateofbirth")
    LocalDate birthDate;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    public Person() {
    }

    public Person(String name, LocalDate localDate, Gender gender) {
        this.name = name;
        this.birthDate = localDate;
        this.gender = gender;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
