package dev.drugowick.example.jpaselfrelationship.infrastructure.projection;

import dev.drugowick.example.jpaselfrelationship.domain.User;

public interface ListOfFriendsProjection {
    User getFriend();
}
