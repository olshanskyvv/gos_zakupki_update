package ru.miit.goszakupki.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lot_purchase")
public class LotPurchase { // Лот закупки
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lot_purchase_id")
    private Long id;
    private Long lotCode;
    @ManyToOne
    @JoinColumn(name = "fk_purchase_id")
    private Purchase purchase;
    private Integer quantity;
    private Integer initialCost;
    private Date dateOfAddition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLotCode() {
        return lotCode;
    }

    public void setLotCode(Long lotCode) {
        this.lotCode = lotCode;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(Integer initialCost) {
        this.initialCost = initialCost;
    }

    public Date getDateOfAddition() {
        return dateOfAddition;
    }

    public void setDateOfAddition(Date dateOfAddition) {
        this.dateOfAddition = dateOfAddition;
    }
}
