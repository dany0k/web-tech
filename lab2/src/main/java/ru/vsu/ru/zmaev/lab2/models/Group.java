package ru.vsu.ru.zmaev.lab2.models;

import jakarta.persistence.*;

@Entity
public class Group {

    @Id
    @GeneratedValue
    private int group_id;

    @Column
    private int number;
}
