package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.DTOs.SignInRequest;
import ru.miit.goszakupki.DTOs.SignUpRequest;
import ru.miit.goszakupki.services.UserService;

@RestController
@RequestMapping("/user")
@Tag(name = "Пользователя", description = "Включает все функции пользователям, включая авторизацию")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Авторизация пользователя",
            description = "Позволяет авторизовать пользователя"
    )
    @GetMapping("/sign/in")
    public ResponseEntity<?> authorizeUser(@RequestBody SignInRequest signInRequest) {
        try {
            return ResponseEntity.ok(userService.authorize(signInRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
            summary = "Регистрация пользователя",
            description = "Позволяет зарегистрироваться пользователя"
    )
    @GetMapping("/sign/up")
    public ResponseEntity<?> addUser(@RequestBody SignUpRequest signUpRequest) {
        try {
            userService.add(signUpRequest);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
