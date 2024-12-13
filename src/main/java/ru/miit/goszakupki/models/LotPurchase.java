package ru.miit.goszakupki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
