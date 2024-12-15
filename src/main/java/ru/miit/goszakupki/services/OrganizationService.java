package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.models.Organization;
import ru.miit.goszakupki.repositories.OrganizationRepository;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id).orElseThrow();
    }

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}
