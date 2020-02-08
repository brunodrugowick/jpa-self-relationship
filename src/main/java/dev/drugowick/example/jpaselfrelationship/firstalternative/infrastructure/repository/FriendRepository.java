package dev.drugowick.example.jpaselfrelationship.firstalternative.infrastructure.repository;

import dev.drugowick.example.jpaselfrelationship.firstalternative.domain.Friend;
import dev.drugowick.example.jpaselfrelationship.firstalternative.domain.User;
import dev.drugowick.example.jpaselfrelationship.firstalternative.infrastructure.projection.ListOfFriendsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Friend.Key> {

    List<ListOfFriendsProjection> findAllByUser(User user);
}
