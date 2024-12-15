package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.Authority;
import ru.miit.goszakupki.models.Position;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findAllByPosition(Position position);
}
