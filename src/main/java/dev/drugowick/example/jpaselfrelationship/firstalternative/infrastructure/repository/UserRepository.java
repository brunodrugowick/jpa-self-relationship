package dev.drugowick.example.jpaselfrelationship.firstalternative.infrastructure.repository;

import dev.drugowick.example.jpaselfrelationship.firstalternative.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
