package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.DTOs.AuthorityDTO;
import ru.miit.goszakupki.models.Authority;
import ru.miit.goszakupki.services.AuthorityService;

import java.util.List;

@CrossOrigin
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
    public ResponseEntity<List<Authority>> getAll() {
        return ResponseEntity.ok(authorityService.getAuthorities());
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Полномочие по id",
            description = "Позволяет получить полномочие по id"
    )
    public ResponseEntity<Authority> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authorityService.getAuthority(id));
    }
    @PostMapping("/add")
    @Operation(
            summary = "Новое полномочие",
            description = "Позволяет добавить полномочие"
    )
    public ResponseEntity<Authority> add(AuthorityDTO authority) {
        return ResponseEntity.ok(authorityService.saveAuthority(authority));
    }
    @PutMapping("/update")
    @Operation(
            summary = "Обновить полномочие",
            description = "Позволяет обновить полномочие"
    )
    public ResponseEntity<Authority> update(AuthorityDTO authority) {
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
