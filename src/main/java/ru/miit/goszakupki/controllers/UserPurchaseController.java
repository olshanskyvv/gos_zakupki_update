package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.models.UserPurchase;
import ru.miit.goszakupki.services.UserPurchaseService;

@RestController
@RequestMapping("/user_purchase")
@Tag(name = "Пользователи Закупки", description = "Включает все функции пользователей закупок")
public class UserPurchaseController {
    @Autowired
    private UserPurchaseService userPurchaseService;
    @GetMapping("/all")
    @Operation(
            summary = "Все Пользователи Закупки",
            description = "Получить все Пользователи Закупки"
    )
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userPurchaseService.getAllUserPurchases());
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Пользователи Закупки по id",
            description = "Позволяет получить Пользователи Закупки по id"
    )
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userPurchaseService.getUserPurchaseById(id));
    }
    @PostMapping("/add")
    @Operation(
            summary = "Новые Пользователи Закупки",
            description = "Позволяет добавить Пользователи Закупки"
    )
    public ResponseEntity<?> add(UserPurchase userPurchase) {
        return ResponseEntity.ok(userPurchaseService.createUserPurchase(userPurchase));
    }
    @PutMapping("/update")
    @Operation(
            summary = "Обновить Пользователи Закупки",
            description = "Позволяет обновить Пользователи Закупки"
    )
    public ResponseEntity<?> update(UserPurchase userPurchase) {
        return ResponseEntity.ok(userPurchaseService.updateUserPurchase(userPurchase));
    }
    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить Пользователи Закупки",
            description = "Позволяет удалить Пользователи Закупки"
    )
    public ResponseEntity<?> delete(@RequestParam Long id) {
        userPurchaseService.deleteUserPurchase(id);
        return ResponseEntity.ok().build();
    }
}
