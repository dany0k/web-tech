package ru.vsu.ru.zmaev.lab2.models;

import jakarta.persistence.*;

@Entity
public class Pairs {

    @Id
    @GeneratedValue
    private int pairsId;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "")
    private int subjectId;
}
