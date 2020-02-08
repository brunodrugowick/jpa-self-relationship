package dev.drugowick.example.jpaselfrelationship.web.rest;

import dev.drugowick.example.jpaselfrelationship.domain.Friend;
import dev.drugowick.example.jpaselfrelationship.infrastructure.repository.FriendRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {

    private FriendRepository friendRepository;

    public FriendController(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @GetMapping
    public List<Friend> list() {
        return friendRepository.findAll();
    }
}
