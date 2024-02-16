package org.f1.controller;

import lombok.extern.slf4j.Slf4j;
import org.f1.dto.RaceDTO;
import org.f1.model.Race;
import org.f1.service.RaceService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/race")
public class RaceController {
    private final RaceService raceService;
    private final ModelMapper modelMapper;

    public RaceController(RaceService raceService, ModelMapper modelMapper) {
        this.raceService = raceService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<?> addRace(@RequestBody RaceDTO dto) {
        if (dto.getName().isEmpty() || dto.getName().isBlank()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Race r = raceService.addRace(modelMapper.map(dto, Race.class));
        return new ResponseEntity<>(modelMapper.map(r, RaceDTO.class), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RaceDTO>> getAllRaces() {
        List<Race> races = raceService.getAllRaces();
        List<RaceDTO> raceDTOS = races.stream().map(race -> modelMapper.map(race, RaceDTO.class)).toList();
        return ResponseEntity.ok(raceDTOS);
    }

    @GetMapping("/{raceId}")
    public ResponseEntity<RaceDTO> getRaceData(@PathVariable Long raceId) {
        if (raceId == null) {
            return ResponseEntity.badRequest().build();
        }
        Race race = raceService.getRaceData(raceId);

        if (race == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            RaceDTO raceDTO = modelMapper.map(race, RaceDTO.class);
            return ResponseEntity.ok(raceDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{raceId}")
    public ResponseEntity<RaceDTO> updateRace(@PathVariable Long raceId, @RequestBody RaceDTO raceDTO) {
        if (raceId == null || raceDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        Race race = raceService.updateRace(raceId, raceDTO);

        try {
            RaceDTO dto = modelMapper.map(race, RaceDTO.class);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{raceId}")
    public ResponseEntity<?> deleteRace(@PathVariable Long raceId) {
        if (raceId == null) {
            return ResponseEntity.badRequest().build();
        }
        raceService.deleteRace(raceId);
        return ResponseEntity.ok().build();
    }
}
