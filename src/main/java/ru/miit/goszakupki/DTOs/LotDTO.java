package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Лоты")
@Data
@NoArgsConstructor
public class LotDTO {
    @Schema(description = "Идентификатор лота", example = "1")
    private Long code;
    @Schema(description = "Наименование", example = "1")
    private String title;
    @Schema(description = "Единица измерения", example = "1")
    private String unitOfMeasurement;
    @Schema(description = "Код ОКПД2", example = "1")
    private String okpd2;
    @Schema(description = "Код ОКВЭД2", example = "1")
    private String okved2;

    public LotDTO(Long code, String title, String unitOfMeasurement, String okpd2, String okved2) {
        this.title = title;
        this.code = code;
        this.unitOfMeasurement = unitOfMeasurement;
        this.okpd2 = okpd2;
        this.okved2 = okved2;
    }

    public Long getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public String getOkpd2() {
        return okpd2;
    }

    public String getOkved2() {
        return okved2;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
