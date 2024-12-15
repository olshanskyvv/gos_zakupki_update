package ru.miit.goszakupki.models;

import jakarta.persistence.*;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
