package dev.drugowick.example.jpaselfrelationship.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Friend> friends = new ArrayList<>();
}
