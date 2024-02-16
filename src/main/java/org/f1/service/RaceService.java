package org.f1.service;

import org.f1.dto.RaceDTO;
import org.f1.model.Race;
import org.f1.model.RaceStatus;
import org.f1.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {
    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public Race addRace(Race race) {
        race.setStatus(RaceStatus.FUTURE);
        return raceRepository.save(race);
    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Race getRaceData(Long raceId) {
        return raceRepository.findById(raceId).orElse(null);
    }

    public Race updateRace(Long raceId, RaceDTO raceDTO) {
        Race current = raceRepository.findById(raceId).orElseThrow();
        current.setName(raceDTO.getName());
        current.setCircuitName(raceDTO.getCircuitName());
        current.setRaceDate(raceDTO.getRaceDate());

        return raceRepository.save(current);
    }

    public void deleteRace(Long raceId) {
        raceRepository.deleteById(raceId);
    }
}
