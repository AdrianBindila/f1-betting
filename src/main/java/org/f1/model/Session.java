package org.f1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//FP1,2,3; Q1,2,3; and the race itself

@Entity
@Getter
@Setter
public class Session {
    @Id
    @GeneratedValue
    private Long id;
    private SessionType type;
    @ManyToOne
    private Race race;
    @OneToMany
    private List<SessionResult> results;
}
