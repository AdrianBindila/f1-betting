package org.f1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

// I bet that Fernando Alonso comes P10 in the Bahrain Race

@Entity
@Getter
@Setter
public class Bet {
    @Id
    @GeneratedValue
    private Long id;
    private BetType betType;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private User user;
    @ManyToOne
    private Race race;
}
