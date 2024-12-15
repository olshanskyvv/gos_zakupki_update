package ru.miit.goszakupki.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "lot", uniqueConstraints = {
        @UniqueConstraint(
                name = "unique_key",
                columnNames = {"code", "valid_from"}
                )
})
@Schema(name = "Лот")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lot_id")
    private Long id;
    private Long code;
    private Date validFrom;
    private Date validTo;
    private String title;
    private String unitOfMeasurement;
    private String OKPD2;
    private String OKVED2;

    public Lot(Long code, Date validFrom, Date validTo, String title, String unitOfMeasurement, String OKPD2, String OKVED2) {
        this.code = code;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.title = title;
        this.unitOfMeasurement = unitOfMeasurement;
        this.OKPD2 = OKPD2;
        this.OKVED2 = OKVED2;
    }

    public Lot() {
    }

    public Long getCode() {
        return code;
    }

    public Date getValidTo() {
        return validTo;
    }

    public String getTitle() {
        return title;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public String getOKPD2() {
        return OKPD2;
    }

    public String getOKVED2() {
        return OKVED2;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOKPD2(String OKPD2) {
        this.OKPD2 = OKPD2;
    }

    public void setOKVED2(String OKVED2) {
        this.OKVED2 = OKVED2;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }
}
