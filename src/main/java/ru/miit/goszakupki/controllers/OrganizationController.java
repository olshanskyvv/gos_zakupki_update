package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.services.OrganizationService;

@RestController
@RequestMapping("/organization")
@Tag(name = "Организации", description = "Включает все функции организаций")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;
}
