package dev.drugowick.example.jpaselfrelationship.secondalternative.infrastructure.repository;

import dev.drugowick.example.jpaselfrelationship.secondalternative.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
