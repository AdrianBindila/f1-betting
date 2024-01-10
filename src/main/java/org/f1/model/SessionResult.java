package org.f1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

//A result is the time a driver obtained for a single session
//For instance Fernando Alonso obtaining 1:43.004 in Free Practice 1

@Entity
@Getter
@Setter
public class SessionResult {
    @Id
    @GeneratedValue
    private Long id;
    private Time time;
    private boolean isDNF;
    @ManyToOne
    private Session session;
    @ManyToOne
    private Driver driver;

}
