package org.f1.dto;

import lombok.Data;
import org.f1.model.BetType;

@Data
public class BetDTO {
    private Long betId;
    private BetType betType;
    private Long driverId;//check if driver is in the race
    private Long userId;//check that user exists
    private Long raceId;
}
