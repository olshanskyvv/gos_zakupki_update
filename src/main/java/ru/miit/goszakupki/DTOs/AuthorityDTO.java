package ru.miit.goszakupki.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Полномочия")
public class AuthorityDTO {
    @Schema(description = "Идентификатор должности", example = "1")
    private Long position_id;
    @Schema(description = "Заголовок", example = "1")
    private String header;
    @Schema(description = "Описание", example = "1")
    private String description;

    public AuthorityDTO(Long position_id, String header, String description) {
        this.position_id = position_id;
        this.header = header;
        this.description = description;
    }

    public Long getPosition_id() {
        return position_id;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
