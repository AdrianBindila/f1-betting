package org.f1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Race {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String circuitName;
    @Column(unique = true, nullable = false)
    private Date raceDate;
    @OneToMany
    private List<Session> sessions;
    private RaceStatus status;
}
