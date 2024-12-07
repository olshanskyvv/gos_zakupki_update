package ru.miit.goszakupki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_purchase")
public class UserPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_purchase_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "fk_purchase_id")
    private Purchase purchase;
}
