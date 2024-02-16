package org.f1.controller;

import lombok.extern.slf4j.Slf4j;
import org.f1.dto.SessionResultDTO;
import org.f1.model.SessionResult;
import org.f1.service.SessionResultService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/session-result")
public class SessionResultController {
    private final SessionResultService sessionResultService;
    private final ModelMapper modelMapper;

    public SessionResultController(SessionResultService sessionResultService, ModelMapper modelMapper) {
        this.sessionResultService = sessionResultService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{sessionResultId}")
    public ResponseEntity<?> getSessionResult(@PathVariable Long sessionResultId) {
        SessionResult result = sessionResultService.getSessionResult(sessionResultId);
        return ResponseEntity.ok(modelMapper.map(result, SessionResultDTO.class));
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<?> getAllSessionResults(@PathVariable Long sessionId) {
        List<SessionResult> results = sessionResultService.getAllSessionResults(sessionId);
        List<SessionResultDTO> resultDTOS = results.stream().map(sessionResult -> modelMapper.map(sessionResult, SessionResultDTO.class)).toList();
        return ResponseEntity.ok(resultDTOS);
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<?> getDriverSessions(@PathVariable Long driverId) {
        List<SessionResult> results = sessionResultService.getDriverSessions(driverId);
        List<SessionResultDTO> resultDTOS = results.stream().map(sessionResult -> modelMapper.map(sessionResult, SessionResultDTO.class)).toList();
        return ResponseEntity.ok(resultDTOS);
    }

    @PostMapping
    public ResponseEntity<?> addSessionResult(@RequestBody SessionResultDTO dto) {
        if (dto.getTime() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        SessionResult sessionResult = sessionResultService.addSessionResult(modelMapper.map(dto, SessionResultDTO.class));
        return new ResponseEntity<>(modelMapper.map(sessionResult, SessionResultDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{sessionResultId}")
    public ResponseEntity<?> updateSessionResult(@PathVariable Long sessionResultId, @RequestBody SessionResultDTO sessionResultDTO) {
        SessionResult sessionResult = sessionResultService.updateSessionResult(sessionResultId, sessionResultDTO);
        return ResponseEntity.ok(sessionResult);
    }

    @DeleteMapping("/{sessionResultId}")
    public ResponseEntity<?> deleteSessionResult(@PathVariable Long sessionResultId) {
        if (sessionResultId == null) {
            return ResponseEntity.badRequest().build();
        }

        sessionResultService.deleteSessionResult(sessionResultId);
        return ResponseEntity.ok().build();
    }
}
