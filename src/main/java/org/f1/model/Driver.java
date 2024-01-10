package org.f1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String driverName;
    @OneToMany
    private List<SessionResult> results;
}
