package ru.miit.goszakupki.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import ru.miit.goszakupki.models.ENUMS.METHOD;
import ru.miit.goszakupki.models.ENUMS.STATUS;
import ru.miit.goszakupki.models.ENUMS.TYPE;

import java.time.LocalDate;

@Entity
@Table(name = "purchase")
@Schema(name = "Закупка")
public class Purchase { // закупка
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_id")
    private Long id;
    private Long number;
    private String sphere;
    private String object;
    private LocalDate dateOfPlacement;
    private LocalDate dateOfUpdate;
    private STATUS status;
    private TYPE type;
    private METHOD method;
    private Integer deliveryTime;
    private String placeOfDelivery;
    private String additionalRequirements;

    public Purchase() {
    }

    public Purchase(Long id, Long number, String sphere, String object, LocalDate dateOfPlacement, LocalDate dateOfUpdate, STATUS status, TYPE type, METHOD method, Integer deliveryTime, String placeOfDelivery, String additionalRequirements) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public String getSphere() {
        return sphere;
    }

    public String getObject() {
        return object;
    }

    public LocalDate getDateOfPlacement() {
        return dateOfPlacement;
    }

    public LocalDate getDateOfUpdate() {
        return dateOfUpdate;
    }

    public STATUS getStatus() {
        return status;
    }

    public TYPE getType() {
        return type;
    }

    public METHOD getMethod() {
        return method;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public String getPlaceOfDelivery() {
        return placeOfDelivery;
    }

    public String getAdditionalRequirements() {
        return additionalRequirements;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setSphere(String sphere) {
        this.sphere = sphere;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setDateOfPlacement(LocalDate dateOfPlacement) {
        this.dateOfPlacement = dateOfPlacement;
    }

    public void setDateOfUpdate(LocalDate dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public void setMethod(METHOD method) {
        this.method = method;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setPlaceOfDelivery(String placeOfDelivery) {
        this.placeOfDelivery = placeOfDelivery;
    }

    public void setAdditionalRequirements(String additionalRequirements) {
        this.additionalRequirements = additionalRequirements;
    }
}
