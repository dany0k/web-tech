package ru.vsu.ru.zmaev.lab2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private int subjectId;
    @Column
    private String name;
    @Column
    private String description;

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
