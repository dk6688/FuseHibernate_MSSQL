package com.fuse.hibernate.example.service;

import java.math.BigInteger;
import java.util.List;

import com.fuse.hibernate.example.model.Person;

public interface PersonService {
    public Person createPerson (Person person);
    public void removePerson (Person person);
    public void removePersonById (BigInteger id);
    public Person findPerson (String name);
    public List<Person> findPersons();
    public void updateCustomer (Person person);
}
