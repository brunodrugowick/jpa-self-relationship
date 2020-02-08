package dev.drugowick.example.jpaselfrelationship.secondalternative.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany
    @JoinTable(name = "person_friends", joinColumns = {
            @JoinColumn(name = "person_id", referencedColumnName = "id")
    })
    private List<Person> friends = new ArrayList<>();
}
