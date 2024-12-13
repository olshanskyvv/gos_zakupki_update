package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.miit.goszakupki.models.ENUMS.METHOD;
import ru.miit.goszakupki.models.ENUMS.STATUS;
import ru.miit.goszakupki.models.ENUMS.TYPE;

import java.util.Date;

@Data
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

    public PurchaseDTO() {
    }

    public PurchaseDTO(Long number, String sphere, String object, Date dateOfPlacement, Date dateOfUpdate, STATUS status, TYPE type, METHOD method, Integer deliveryTime, String placeOfDelivery, String additionalRequirements) {
        this.number = number;
        this.sphere = sphere;
        this.object = object;
        this.dateOfPlacement = dateOfPlacement;
        this.dateOfUpdate = dateOfUpdate;
        this.status = status;
        this.type = type;
        this.method = method;
        this.deliveryTime = deliveryTime;
        this.placeOfDelivery = placeOfDelivery;
        this.additionalRequirements = additionalRequirements;
    }
}
