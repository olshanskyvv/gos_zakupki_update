package ru.miit.goszakupki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organization_id")
    private Long id;
    private String title;
    private String INN;
    private String KPP;
    private String legalAddress;
    private String sphere;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getKPP() {
        return KPP;
    }

    public void setKPP(String KPP) {
        this.KPP = KPP;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getSphere() {
        return sphere;
    }

    public void setSphere(String sphere) {
        this.sphere = sphere;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
