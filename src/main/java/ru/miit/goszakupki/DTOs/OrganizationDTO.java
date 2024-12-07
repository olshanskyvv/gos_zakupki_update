package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Организации")
public class OrganizationDTO {
    @Schema(description = "Наименование", example = "1")
    private String title;
    @Schema(description = "ИНН", example = "1")
    private String INN;
    @Schema(description = "КПП", example = "1")
    private String KPP;
    @Schema(description = "Юридический адрес", example = "1")
    private String legalAddress;
    @Schema(description = "Сфера", example = "1")
    private String sphere;
    @Schema(description = "Тип (Заказчик/Поставщик)", example = "1")
    private String type;
}
