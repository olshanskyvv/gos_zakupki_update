package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.models.LotPurchase;
import ru.miit.goszakupki.services.LotPurchaseService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/lot_purchase")
@Tag(name = "Лоты закупок", description = "Включает все функции лотов закупок")
public class LotPurchaseController {
    @Autowired
    private LotPurchaseService lotPurchaseService;
    @GetMapping("/all")
    @Operation(
            summary = "Все лоты закупок",
            description = "Получить все лоты закупок"
    )
    public ResponseEntity<List<LotPurchase>> getAll() {
        return ResponseEntity.ok(lotPurchaseService.getAllLotPurchases());
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Лоты закупок по id",
            description = "Позволяет получить лоты закупок по id"
    )
    public ResponseEntity<LotPurchase> getById(@PathVariable Long id) {
        return ResponseEntity.ok(lotPurchaseService.getLotPurchaseById(id));
    }
    @PostMapping("/add")
    @Operation(
            summary = "Новые лоты закупок",
            description = "Позволяет добавить лоты закупок"
    )
    public ResponseEntity<LotPurchase> add(LotPurchase lotPurchase) {
        return ResponseEntity.ok(lotPurchaseService.createLotPurchase(lotPurchase));
    }
    @PutMapping("/update")
    @Operation(
            summary = "Обновить лоты закупок",
            description = "Позволяет обновить лоты закупок"
    )
    public ResponseEntity<LotPurchase> update(LotPurchase lotPurchase) {
        return ResponseEntity.ok(lotPurchaseService.updateLotPurchase(lotPurchase));
    }
    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить лоты закупок",
            description = "Позволяет удалить лоты закупок"
    )
    public ResponseEntity<?> delete(@RequestParam Long id) {
        lotPurchaseService.deleteLotPurchase(id);
        return ResponseEntity.ok().build();
    }
}
