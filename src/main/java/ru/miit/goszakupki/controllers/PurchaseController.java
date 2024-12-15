package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.models.Purchase;
import ru.miit.goszakupki.services.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@Tag(name = "Закупки", description = "Включает все функции закупок")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @GetMapping("/all")
    @Operation(
            summary = "Все закупки",
            description = "Получить все закупки"
    )
    public ResponseEntity<List<Purchase>> getAll() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Закупка по id",
            description = "Позволяет получить закупку по id"
    )
    public ResponseEntity<Purchase> getById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.getPurchase(id));
    }
    @PostMapping("/add")
    @Operation(
            summary = "Новая закупка",
            description = "Позволяет добавить закупку"
    )
    public ResponseEntity<Purchase> add(Purchase purchase) {
        return ResponseEntity.ok(purchaseService.createPurchase(purchase));
    }
    @PutMapping("/update")
    @Operation(
            summary = "Обновить закупку",
            description = "Позволяет обновить закупку"
    )
    public ResponseEntity<Purchase> update(Purchase purchase) {
        return ResponseEntity.ok(purchaseService.updatePurchase(purchase));
    }
    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить закупку",
            description = "Позволяет удалить закупку"
    )
    public ResponseEntity<Purchase> delete(@RequestParam Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.ok().build();
    }
}
