package ru.miit.goszakupki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.miit.goszakupki.models.ENUMS.METHOD;
import ru.miit.goszakupki.models.ENUMS.STATUS;
import ru.miit.goszakupki.models.ENUMS.TYPE;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase")
public class Purchase { // закупка
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_id")
    private Long id;
    private Long number;
    private String sphere;
    private String object;
    private Date dateOfPlacement;
    private Date dateOfUpdate;
    private STATUS status;
    private TYPE type;
    private METHOD method;
    private Integer deliveryTime;
    private String placeOfDelivery;
    private String additionalRequirements;
}
