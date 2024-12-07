package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.LotPurchase;

@Repository
public interface LotPurchaseRepository extends JpaRepository<LotPurchase, Long> {
}
