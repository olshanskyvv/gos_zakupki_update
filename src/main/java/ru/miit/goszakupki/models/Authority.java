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
@Table(name = "authority")
public class Authority { // полномочия
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authority_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_position_id")
    private Position position;
    private String header;
    private String description;
}
