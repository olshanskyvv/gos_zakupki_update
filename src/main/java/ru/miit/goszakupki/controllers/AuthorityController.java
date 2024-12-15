package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.DTOs.AuthorityDTO;
import ru.miit.goszakupki.models.Authority;
import ru.miit.goszakupki.services.AuthorityService;

@RestController
@RequestMapping("/authority")
@Tag(name = "Полномочия", description = "Включает все функции полномочий")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;
    @GetMapping("/all")
    @Operation(
            summary = "Все полномочия",
            description = "Получить все полномочия"
    )
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(authorityService.getAuthorities());
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Полномочие по id",
            description = "Позволяет получить полномочие по id"
    )
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authorityService.getAuthority(id));
    }
    @PostMapping("/add")
    @Operation(
            summary = "Новое полномочие",
            description = "Позволяет добавить полномочие"
    )
    public ResponseEntity<?> add(AuthorityDTO authority) {
        return ResponseEntity.ok(authorityService.saveAuthority(authority));
    }
    @PutMapping("/update")
    @Operation(
            summary = "Обновить полномочие",
            description = "Позволяет обновить полномочие"
    )
    public ResponseEntity<?> update(AuthorityDTO authority) {
        return ResponseEntity.ok(authorityService.updateAuthority(authority));
    }
    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить полномочие",
            description = "Позволяет удалить полномочие"
    )
    public ResponseEntity<?> delete(@RequestParam Long id) {
        authorityService.deleteAuthority(id);
        return ResponseEntity.ok().build();
    }
}
