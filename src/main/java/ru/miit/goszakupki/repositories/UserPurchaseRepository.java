package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.UserPurchase;

@Repository
public interface UserPurchaseRepository extends JpaRepository<UserPurchase, Long> {
}
