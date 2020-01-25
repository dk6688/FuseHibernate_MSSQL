package com.fuse.hibernate.example.service;

import com.fuse.hibernate.example.model.Person;
import java.math.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.transaction.*;
import javax.transaction.Transactional.*;

@Transactional
public class PersonServiceImpl implements PersonService
{
    @PersistenceContext(unitName = "persons")
    private EntityManager em;

    @Override
    public Person createPerson(Person person) {
        em.persist(person);
        em.flush();
        return person;
    }

    @Override
    public void removePerson(Person person) {
        em.remove(person);
    }

    @Override
    public void removePersonById(BigInteger id) {
        em.remove(em.find(Person.class, id));
    }

    @Transactional(TxType.SUPPORTS)
    @Override
    public Person findPerson(String name) {
        return em.find(Person.class, name);
    }

    @Transactional(TxType.SUPPORTS)
    @Override
    public List<Person> findPersons() {
        CriteriaQuery<Person> query = em.getCriteriaBuilder().createQuery(Person.class);
        return em.createQuery(query.select(query.from(Person.class))).getResultList();
    }

    @Override
    public void updateCustomer(Person person) {
        em.persist(person);
    }
}
