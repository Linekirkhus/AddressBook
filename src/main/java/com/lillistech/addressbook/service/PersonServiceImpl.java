package com.lillistech.addressbook.service;

import com.lillistech.addressbook.model.Person;
import com.lillistech.addressbook.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public void saveContact(Person person) {
        this.personRepository.save(person);
    }

    @Override
    public Person getContactById(Long id) {
        Optional<Person> optional = personRepository.findById(id);
        Person person = null;
        if (optional.isPresent()) {
            person = optional.get();
        } else {
            throw new RuntimeException("Contact Not Found for id :: " + id);
        }
        return person;
    }

    @Override
    public void deleteContactById(Long id) {
        this.personRepository.deleteById(id);
    }
}
