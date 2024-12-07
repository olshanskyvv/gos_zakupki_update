package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Schema(description = "Лоты")
public class LotDTO {
    @Schema(description = "Действует с", example = "1")
    private Date validFrom;
    @Schema(description = "Действует до", example = "1")
    private Date validTo;
    @Schema(description = "Наименование", example = "1")
    private String title;
    @Schema(description = "Единица измерения", example = "1")
    private String unitOfMeasurement;
    @Schema(description = "Код ОКПД2", example = "1")
    private String OKPD2;
    @Schema(description = "Код ОКВЭД2", example = "1")
    private String OKVED2;
}
