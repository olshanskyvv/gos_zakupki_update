package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Должность")
public class PositionDTO {
    @Schema(description = "Наименование", example = "1")
    private String title;
}
