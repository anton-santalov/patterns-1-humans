package com.antonsantalov;

import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private Integer age;
    private String address;

    Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    Person(String name, String surname) {
        this(name, surname, null, null);
    }

    Person(String name, String surname, Integer age) {
        this(name, surname, age, null);
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) age++;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
            .setSurname(this.surname)
            .setAddress(this.address)
            .setAge(0);
    }
}
