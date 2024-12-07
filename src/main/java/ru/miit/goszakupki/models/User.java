package ru.miit.goszakupki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String number;
    private String email;
    private String password;
    private String role;
    private Boolean isLegalEntity;
    @ManyToOne
    @JoinColumn(name = "fk_organization_id")
    private Organization organization;
    @ManyToOne
    @JoinColumn(name = "fk_position_id")
    private Position position;

    public User(String surname, String name, String patronymic, String number, String email, String password, String role, Boolean isLegalEntity, Organization organization, Position position) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.number = number;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isLegalEntity = isLegalEntity;
        this.organization = organization;
        this.position = position;
    }
}
