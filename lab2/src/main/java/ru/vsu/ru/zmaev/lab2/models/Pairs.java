package ru.vsu.ru.zmaev.lab2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pairs")
public class Pairs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int pairsId;

    @ManyToOne()
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne()
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group studentGroup;

    @Column(name = "timestamp")
    private LocalTime timestamp;
}
