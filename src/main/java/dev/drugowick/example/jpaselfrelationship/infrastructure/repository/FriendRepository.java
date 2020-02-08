package dev.drugowick.example.jpaselfrelationship.infrastructure.repository;

import dev.drugowick.example.jpaselfrelationship.domain.Friend;
import dev.drugowick.example.jpaselfrelationship.domain.User;
import dev.drugowick.example.jpaselfrelationship.infrastructure.projection.ListOfFriendsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Friend.Key> {

    List<ListOfFriendsProjection> findAllByUser(User user);
}
