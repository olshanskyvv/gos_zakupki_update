package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
