package org.f1.dto;

import lombok.Data;
import org.f1.model.SessionType;

@Data
public class SessionDTO {
    private Long sessionId;
    private SessionType sessionType;
    private Long raceId;
}
