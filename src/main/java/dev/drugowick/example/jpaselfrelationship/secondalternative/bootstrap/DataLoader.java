package dev.drugowick.example.jpaselfrelationship.secondalternative.bootstrap;

import dev.drugowick.example.jpaselfrelationship.secondalternative.domain.Person;
import dev.drugowick.example.jpaselfrelationship.secondalternative.infrastructure.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person person1 = new Person();
        person1.setName("João");

        Person person2 = new Person();
        person2.setName("Maria");

        person1 = personRepository.save(person1);
        person2 = personRepository.save(person2);

        createFriendship(person1, person2);
    }

    @Transactional
    public void createFriendship(Person person1, Person person2) {
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);

        this.personRepository.save(person1);
        this.personRepository.save(person2);
    }
}
