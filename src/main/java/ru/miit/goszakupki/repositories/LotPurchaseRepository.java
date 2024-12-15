package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.LotPurchase;
import ru.miit.goszakupki.models.Purchase;

import java.util.List;

@Repository
public interface LotPurchaseRepository extends JpaRepository<LotPurchase, Long> {
    List<LotPurchase> findAllByPurchase(Purchase purchase);
}
