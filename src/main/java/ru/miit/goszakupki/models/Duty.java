package ru.miit.goszakupki.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "duty")
@Schema(name = "Обязанность")
public class Duty { // обязанность
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "duty_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_position_id")
    private Position position;
    private String header;
    private String description;

    public Duty() {
    }

    public Duty(Position position, String header, String description) {
        this.position = position;
        this.header = header;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
