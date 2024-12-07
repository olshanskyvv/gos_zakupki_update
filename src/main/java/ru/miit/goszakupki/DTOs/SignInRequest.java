package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Авторизация пользователя")
public class SignInRequest {
    @Schema(description = "Адрес электронной почты", example = "sapipa@gmail.com")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;
    @Schema(description = "Пароль", example = "123456")
    private String password;
}
