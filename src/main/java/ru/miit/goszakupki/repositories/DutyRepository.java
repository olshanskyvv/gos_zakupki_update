package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.Duty;
import ru.miit.goszakupki.models.Position;

import java.util.List;

@Repository
public interface DutyRepository extends JpaRepository<Duty, Long> {
    List<Duty> findAllByPosition(Position position);
}
