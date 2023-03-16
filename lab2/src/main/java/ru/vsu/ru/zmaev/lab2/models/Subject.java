package ru.vsu.ru.zmaev.lab2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private Integer subjectId;
    @Column
    private String name;
    @Column
    private String description;

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
