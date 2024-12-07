package ru.miit.goszakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.miit.goszakupki.models.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
