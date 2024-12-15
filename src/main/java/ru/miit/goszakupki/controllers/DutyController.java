package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.DTOs.DutyDTO;
import ru.miit.goszakupki.models.Duty;
import ru.miit.goszakupki.services.DutyService;

@RestController
@RequestMapping("/duty")
@Tag(name = "Обязанности", description = "Включает все функции обязанностей")
public class DutyController {
    @Autowired
    private DutyService dutyService;

    @GetMapping("/all")
    @Operation(
            summary = "Все обязанности",
            description = "Получить все обязанности"
    )
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(dutyService.getAllDuty());
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Обязанность по id",
            description = "Позволяет получить обязанность по id"
    )
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(dutyService.getDutyById(id));
    }
    @PostMapping("/add")
    @Operation(
            summary = "Новая обязанность",
            description = "Позволяет добавить обязанность"
    )
    public ResponseEntity<?> add(DutyDTO duty) {
        return ResponseEntity.ok(dutyService.saveDuty(duty));
    }
    @PutMapping("/update")
    @Operation(
            summary = "Обновить обязанность",
            description = "Позволяет обновить обязанность"
    )
    public ResponseEntity<?> update(DutyDTO duty) {
        return ResponseEntity.ok(dutyService.updateDuty(duty));
    }
    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить обязанность",
            description = "Позволяет удалить обязанность"
    )
    public ResponseEntity<?> delete(@RequestParam Long id) {
        dutyService.deleteDuty(id);
        return ResponseEntity.ok().build();
    }
}
