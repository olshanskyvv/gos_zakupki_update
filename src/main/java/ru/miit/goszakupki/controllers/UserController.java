package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.DTOs.SignInRequest;
import ru.miit.goszakupki.DTOs.SignUpRequest;
import ru.miit.goszakupki.services.UserService;

@RestController
@RequestMapping("/user")
@Tag(name = "Пользователи", description = "Включает все функции пользователям")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(
            summary = "Авторизация пользователя",
            description = "Позволяет авторизовать пользователя"
    )
    @PostMapping("/sign/in")
    public ResponseEntity<?> authorizeUser(@RequestBody SignInRequest signInRequest) {
        try {
            if (userService.authorize(signInRequest)) {
                return ResponseEntity.ok(userService.getUserDTO(signInRequest.getEmail()));
            }
            return ResponseEntity.badRequest().body("Not authorized");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
            summary = "Регистрация пользователя",
            description = "Позволяет зарегистрироваться пользователя"
    )
    @PostMapping("/sign/up")
    public ResponseEntity<String> addUser(@RequestBody SignUpRequest signUpRequest) {
        try {
            userService.add(signUpRequest);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
