package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
