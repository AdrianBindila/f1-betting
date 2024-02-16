package org.f1.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class RaceDTO {
    private Long raceId;
    private String name;
    private String circuitName;
    private Date raceDate;
}
