package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.models.Organization;
import ru.miit.goszakupki.models.Position;
import ru.miit.goszakupki.services.OrganizationService;

@RestController
@RequestMapping("/organization")
@Tag(name = "Организации", description = "Включает все функции организаций")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/all")
    @Operation(
            summary = "Все организации",
            description = "Получить все организации"
    )
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Организация по id",
            description = "Позволяет получить организацию по id"
    )
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }
    @PostMapping("/add")
    @Operation(
            summary = "Новая организация",
            description = "Позволяет добавить организацию"
    )
    public ResponseEntity<?> add(Organization organization) {
        return ResponseEntity.ok(organizationService.createOrganization(organization));
    }
    @PutMapping("/update")
    @Operation(
            summary = "Обновить организацию",
            description = "Позволяет обновить организацию"
    )
    public ResponseEntity<?> update(Organization organization) {
        return ResponseEntity.ok(organizationService.updateOrganization(organization));
    }
    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить организацию",
            description = "Позволяет удалить организацию"
    )
    public ResponseEntity<?> delete(@RequestParam Long id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.ok().build();
    }
}
