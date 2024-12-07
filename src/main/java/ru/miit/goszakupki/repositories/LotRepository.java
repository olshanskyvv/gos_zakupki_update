package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.Lot;

@Repository
public interface LotRepository extends JpaRepository<Lot, Long> {
}
