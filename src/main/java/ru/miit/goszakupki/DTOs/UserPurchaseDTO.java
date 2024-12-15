package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Пользователи Закупки")
public class UserPurchaseDTO {
    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long user;
    @Schema(description = "Идентификатор закупки", example = "1")
    private Long purchase;
}
