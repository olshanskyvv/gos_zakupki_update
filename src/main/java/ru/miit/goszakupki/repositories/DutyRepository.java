package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.Duty;

@Repository
public interface DutyRepository extends JpaRepository<Duty, Long> {
}
