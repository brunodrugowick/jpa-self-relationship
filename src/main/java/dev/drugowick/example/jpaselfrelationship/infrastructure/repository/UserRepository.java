package dev.drugowick.example.jpaselfrelationship.infrastructure.repository;

import dev.drugowick.example.jpaselfrelationship.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
