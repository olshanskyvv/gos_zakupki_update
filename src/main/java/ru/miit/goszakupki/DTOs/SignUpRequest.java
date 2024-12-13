package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Регистрация пользователя")
public class SignUpRequest {
    @Schema(description = "Фамилия", example = "1")
    public String surname;
    @Schema(description = "Имя", example = "1")
    public String name;
    @Schema(description = "Отчество", example = "1")
    public String patronymic;
    @Schema(description = "Номер телефона", example = "1")
    public String number;
    @Schema(description = "Почта", example = "1")
    public String email;
    @Schema(description = "Пароль", example = "1")
    public String password;
    @Schema(description = "Роль", example = "1")
    public String role;
    @Schema(description = "Юр. лицо", example = "1")
    public Boolean isLegalEntity;
    @Schema(description = "Идентификатор организации", example = "1")
    public Long organization_id;
    @Schema(description = "Идентификатор должности", example = "1")
    public Long position_id;
}
