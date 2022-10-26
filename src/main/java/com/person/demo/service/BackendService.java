/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.person.demo.service;

import org.springframework.stereotype.Service;
import person.Person;

import javax.xml.datatype.DatatypeFactory;
import java.util.Arrays;
import java.util.List;

@Service
public class BackendService {

    List<Person> getPersonsByName(String firstName, String lastName) throws Exception{
        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstname("Jeffery");
        person1.setLastname("Lewis");
        person1.setPesel("1234");
        person1.setGender("M");
        person1.setBirthdate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("2000-01-01"));

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstname("Francis");
        person2.setLastname("Stevens");
        person1.setPesel("5678");
        person2.setGender("M");
        person2.setBirthdate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("1999-01-01"));

        return Arrays.asList(person1, person2);
    }

    Person getPersonById(long id) throws Exception {
        Person person = new Person();
        person.setId(id);
        person.setFirstname("John");
        person.setLastname("Miller");
        person.setPesel("1234");
        person.setBirthdate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("1999-01-01"));
        return person;
    }

    Person getPersonByPesel(String id) throws Exception {
        Person person = new Person();
        person.setId(1234);
        person.setFirstname("John");
        person.setLastname("Miller");
        person.setPesel("1234");
        person.setBirthdate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("1999-01-01"));
        return person;
    }
}
