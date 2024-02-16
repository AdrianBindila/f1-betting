package org.f1.service;

import org.f1.dto.SessionResultDTO;
import org.f1.model.SessionResult;
import org.f1.repository.SessionResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionResultService {
    private final SessionResultRepository sessionResultRepository;

    public SessionResultService(SessionResultRepository sessionResultRepository) {
        this.sessionResultRepository = sessionResultRepository;
    }

    public SessionResult getSessionResult(Long sessionResultId) {
        return null;
    }

    public List<SessionResult> getAllSessionResults(Long sessionId) {
        return null;
    }

    public List<SessionResult> getDriverSessions(Long driverId) {
        return null;
    }

    public SessionResult addSessionResult(SessionResultDTO map) {
        return null;
    }

    public void deleteSessionResult(Long sessionResultId) {
        sessionResultRepository.deleteById(sessionResultId);
    }

    public SessionResult updateSessionResult(Long sessionResultId, SessionResultDTO sessionResultDTO) {
        return null;
    }
}