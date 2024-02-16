package org.f1.service;

import org.f1.dto.SessionDTO;
import org.f1.model.Session;
import org.f1.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session getSession(Long sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }


    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session addSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session updateSession(Long sessionId, SessionDTO sessionDTO) {
        Session session = sessionRepository.findById(sessionId).orElseThrow();
        session.setType(sessionDTO.getSessionType());
        return sessionRepository.save(session);
    }

    public void deleteSession(Long sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
