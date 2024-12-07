package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.miit.goszakupki.models.ENUMS.METHOD;
import ru.miit.goszakupki.models.ENUMS.STATUS;
import ru.miit.goszakupki.models.ENUMS.TYPE;

import java.util.Date;

@Data
@AllArgsConstructor
@Schema(description = "Организации")
public class PurchaseDTO {
    @Schema(description = "Номер", example = "1")
    private Long number;
    @Schema(description = "Сфера", example = "1")
    private String sphere;
    @Schema(description = "Объект закупки", example = "1")
    private String object;
    @Schema(description = "Дата размещения", example = "1")
    private Date dateOfPlacement;
    @Schema(description = "Дата обновления", example = "1")
    private Date dateOfUpdate;
    @Schema(description = "Статус", example = "1")
    private STATUS status;
    @Schema(description = "Тип", example = "1")
    private TYPE type;
    @Schema(description = "Способ", example = "1")
    private METHOD method;
    @Schema(description = "Срок поставки", example = "1")
    private Integer deliveryTime;
    @Schema(description = "Место поставки", example = "1")
    private String placeOfDelivery;
    @Schema(description = "Дополнительные требования", example = "1")
    private String additionalRequirements;
}
