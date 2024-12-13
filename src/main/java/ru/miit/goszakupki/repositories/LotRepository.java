package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.Lot;

import java.util.Date;
import java.util.List;

@Repository
public interface LotRepository extends JpaRepository<Lot, Long> {
    @Query(value = """
    select lot.* from Lot lot
    where lot.valid_to = '9999-12-31'::timestamp
        and lot.code = :code
""", nativeQuery = true)
    Lot findActualByCode(Long code);
    @Query(value = """
    select lot.* from Lot lot
    where :date::timestamp between lot.valid_from and lot.valid_to
        and lot.code in :codes
""", nativeQuery = true)
    List<Lot> findByCodesAndDate(List<Long> codes, Date date);
}
