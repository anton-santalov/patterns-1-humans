package com.antonsantalov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

class PersonTest {

    @Test
    void getEmptyAge() {
        Person person = new PersonBuilder().setName("A").setSurname("B").build();
        OptionalInt age = person.getAge();
        OptionalInt result = OptionalInt.empty();
        Assertions.assertEquals(age, result);
    }

    @Test
    void getZeroAge() {
        Person person = new PersonBuilder().setName("A").setSurname("B").setAge(0).build();
        OptionalInt age = person.getAge();
        OptionalInt result = OptionalInt.of(0);
        Assertions.assertEquals(age, result);
    }
}