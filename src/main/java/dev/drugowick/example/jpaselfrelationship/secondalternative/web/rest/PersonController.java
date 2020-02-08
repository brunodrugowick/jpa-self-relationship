package dev.drugowick.example.jpaselfrelationship.secondalternative.web.rest;

import dev.drugowick.example.jpaselfrelationship.secondalternative.domain.Person;
import dev.drugowick.example.jpaselfrelationship.secondalternative.infrastructure.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> list() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> get(@PathVariable Long id) {
        return personRepository.findById(id);
    }

    @GetMapping("/{id}/friends")
    public List<Person> friends(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get().getFriends();
        }
        return null;
    }

}
