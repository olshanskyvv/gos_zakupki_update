package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Регистрация пользователя")
public class SignUpRequest {
    @Schema(description = "Фамилия", example = "1")
    private String surname;
    @Schema(description = "Имя", example = "1")
    private String name;
    @Schema(description = "Отчество", example = "1")
    private String patronymic;
    @Schema(description = "Номер телефона", example = "1")
    private String number;
    @Schema(description = "Почта", example = "1")
    private String email;
    @Schema(description = "Пароль", example = "1")
    private String password;
    @Schema(description = "Роль", example = "1")
    private String role;
    @Schema(description = "Юр. лицо", example = "1")
    private Boolean isLegalEntity;
    @Schema(description = "Идентификатор организации", example = "1")
    private Long organization_id;
    @Schema(description = "Идентификатор должности", example = "1")
    private Long position_id;
}
