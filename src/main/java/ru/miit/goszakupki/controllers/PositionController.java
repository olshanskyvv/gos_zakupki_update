package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.models.Position;
import ru.miit.goszakupki.services.PositionService;

import java.util.List;

@RestController
@RequestMapping("/position")
@Tag(name = "Должности", description = "Включает все функции должностей")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/all")
    @Operation(
            summary = "Все должности",
            description = "Получить все должности"
    )
    public ResponseEntity<List<Position>> getAll() {
        return ResponseEntity.ok(positionService.getPositions());
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Должность по id",
            description = "Позволяет получить должность по id"
    )
    public ResponseEntity<Position> getById(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.getPosition(id));
    }
    @PostMapping("/add")
    @Operation(
            summary = "Новая должность",
            description = "Позволяет добавить должность"
    )
    public ResponseEntity<Position> add(Position position) {
        return ResponseEntity.ok(positionService.createPosition(position));
    }
    @PutMapping("/update")
    @Operation(
            summary = "Обновить должность",
            description = "Позволяет обновить должность"
    )
    public ResponseEntity<Position> update(Position position) {
        return ResponseEntity.ok(positionService.updatePosition(position));
    }
    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить должность",
            description = "Позволяет удалить должность"
    )
    public ResponseEntity<?> delete(@RequestParam Long id) {
        positionService.deletePosition(id);
        return ResponseEntity.ok().build();
    }
}
