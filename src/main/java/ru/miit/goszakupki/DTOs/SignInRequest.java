package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

@Schema(name = "Запрос на авторизацию пользователя")
public class SignInRequest {
    @Schema(description = "Адрес электронной почты", example = "sapipa@gmail.com")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;
    @Schema(description = "Пароль", example = "123456")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
