package org.f1.dto;

import lombok.Data;

import java.sql.Time;

@Data
public class SessionResultDTO {
    private Long sessionResultId;
    private Time time;
    private boolean isDnf;
    private Long sessionId;
    private Long driverId;
}
//TODO: validations for each DTO in the controllers