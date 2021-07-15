package com.covid.info.service;

import com.covid.info.domain.Person;
import com.covid.info.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void addPerson(Person person) {
        int id = getRandomNumber(1,999999999);
        while (personRepository.existsById(id)){
            id = getRandomNumber(1,999999999);
        }
        person.setId(id);
        personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
       List<Person> peopleList = personRepository.findAll();
       return peopleList;
    }

    @Override
    public Person getPersonById(int id) {
        return personRepository.getOne(id);
    }

    @Override
    public void updatePersonName(String name, int id) {
        personRepository.setPersonName(name, id);
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.deleteById(id);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
