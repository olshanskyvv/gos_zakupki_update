package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.DTOs.LotDTO;
import ru.miit.goszakupki.models.Lot;
import ru.miit.goszakupki.services.LotService;

import java.util.List;

@RestController
@RequestMapping("/lot")
@Tag(name = "Лоты", description = "Включает все функции лотов")
public class LotController {
    @Autowired
    private LotService lotService;

    @Operation(
            summary = "Список лотов",
            description = "Получение списка всех доступных лотов"
    )
    @GetMapping
    public List<LotDTO> all() {
        return lotService.getLots();
    }

    @Operation(
            summary = "Лот",
            description = "Получение лота по его Id"
    )
    @GetMapping("/{id}")
    public LotDTO getLotById(@PathVariable Long id) {
        return lotService.getLotByCode(id);
    }

    @Operation(
            summary = "Новый лот",
            description = "Создание нового лота"
    )
    @PostMapping
    public LotDTO createLot(@RequestBody LotDTO lot) {
        return lotService.createOrUpdate(lot);
    }
    @Operation(
            summary = "Обновление лота",
            description = "Обновление лота по его Id"
    )
    @PutMapping("/{id}")
    public LotDTO updateLot(@PathVariable Long id,
                            @RequestBody LotDTO lot) {
        lot.setCode(id);
        return lotService.createOrUpdate(lot);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lot>> getAll() {
        return ResponseEntity.ok(lotService.getAllLots());
    }
}
