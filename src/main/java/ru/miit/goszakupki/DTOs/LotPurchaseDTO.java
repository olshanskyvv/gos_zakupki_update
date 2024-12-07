package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Schema(description = "Лот закупки")
public class LotPurchaseDTO {
    @Schema(description = "Идентификатор лота", example = "1")
    private Long lot;
    @Schema(description = "Идентификатор закупки", example = "1")
    private Long purchase;
    @Schema(description = "Количество", example = "1")
    private Integer quantity;
    @Schema(description = "Начальная стоимость", example = "1")
    private Integer initialCost;
    @Schema(description = "Дата добавления", example = "1")
    private Date dateOfAddition;
}
