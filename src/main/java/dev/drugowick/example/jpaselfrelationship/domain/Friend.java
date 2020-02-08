package dev.drugowick.example.jpaselfrelationship.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Friend {

    @JsonIgnore
    @EmbeddedId
    private Key key = new Key();

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("friendId")
    private User friend;

    @Embeddable
    @Data
    public static class Key implements Serializable {
        private Long userId;
        private Long friendId;
    }
}
