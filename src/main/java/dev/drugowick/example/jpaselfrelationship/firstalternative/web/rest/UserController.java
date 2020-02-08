package dev.drugowick.example.jpaselfrelationship.firstalternative.web.rest;

import dev.drugowick.example.jpaselfrelationship.firstalternative.domain.User;
import dev.drugowick.example.jpaselfrelationship.firstalternative.infrastructure.projection.ListOfFriendsProjection;
import dev.drugowick.example.jpaselfrelationship.firstalternative.infrastructure.repository.FriendRepository;
import dev.drugowick.example.jpaselfrelationship.firstalternative.infrastructure.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private FriendRepository friendRepository;

    public UserController(UserRepository userRepository, FriendRepository friendRepository) {
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
    }

    @GetMapping
    public List<User> list() {
        List<User> users = userRepository.findAll();

        return users;
    }

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/{id}/friends")
    public List<ListOfFriendsProjection> listFriends(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return friendRepository.findAllByUser(user.get());
    }
}
