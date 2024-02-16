package org.f1.controller;

import lombok.extern.slf4j.Slf4j;
import org.f1.dto.SessionDTO;
import org.f1.model.Session;
import org.f1.service.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/session")
public class SessionController {
    private final SessionService sessionService;
    private final ModelMapper modelMapper;

    public SessionController(SessionService sessionService, ModelMapper modelMapper) {
        this.sessionService = sessionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionDTO> getSession(@PathVariable Long sessionId) {
        if (sessionId == null) {
            return ResponseEntity.badRequest().build();
        }
        Session session = sessionService.getSession(sessionId);

        if (session == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
            return ResponseEntity.ok(sessionDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<SessionDTO>> getAllSessions() {
        List<Session> sessions = sessionService.getAllSessions();
        List<SessionDTO> sessionDTOS = sessions.stream().map(session -> modelMapper.map(session, SessionDTO.class)).toList();
        return ResponseEntity.ok(sessionDTOS);
    }

    @PostMapping
    public ResponseEntity<SessionDTO> addSession(@RequestBody SessionDTO dto) {
        if (dto.getSessionType() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Session s = sessionService.addSession(modelMapper.map(dto, Session.class));
        return new ResponseEntity<>(modelMapper.map(s, SessionDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{sessionId}")
    public ResponseEntity<SessionDTO> updateSession(@PathVariable Long sessionId, @RequestBody SessionDTO sessionDTO) {
        if (sessionId == null || sessionDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        Session session = sessionService.updateSession(sessionId, sessionDTO);

        try {
            SessionDTO dto = modelMapper.map(session, SessionDTO.class);
            return ResponseEntity.ok(dto);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<?> deleteSession(@PathVariable Long sessionId){
        if(sessionId == null){
            return ResponseEntity.badRequest().build();
        }

        sessionService.deleteSession(sessionId);
        return ResponseEntity.ok().build();
    }
}
