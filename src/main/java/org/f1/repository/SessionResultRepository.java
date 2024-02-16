package org.f1.repository;

import org.f1.model.SessionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionResultRepository extends JpaRepository<SessionResult,Long> {
}
