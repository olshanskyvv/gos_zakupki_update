package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.repositories.OrganizationRepository;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private OrganizationRepository organizationRepository;
}
