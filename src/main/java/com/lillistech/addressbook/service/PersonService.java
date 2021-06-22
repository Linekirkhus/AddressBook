package com.lillistech.addressbook.service;

import com.lillistech.addressbook.model.Person;

import java.util.List;


public interface PersonService {
    List<Person> getAllPeople();
    void saveContact(Person person);
    Person getContactById(Long id);
    void deleteContactById(Long id);
}
