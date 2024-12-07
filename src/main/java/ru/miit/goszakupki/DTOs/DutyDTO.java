package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Обязанности")
public class DutyDTO {
    @Schema(description = "Идентификатор должности", example = "1")
    private Long position_id;
    @Schema(description = "Заголовок", example = "1")
    private String header;
    @Schema(description = "Описание", example = "1")
    private String description;
}
