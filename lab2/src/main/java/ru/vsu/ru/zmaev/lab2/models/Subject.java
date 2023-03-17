package ru.vsu.ru.zmaev.lab2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer subjectId;
    @Column
    private String name;
    @Column
    private String description;

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<Pairs> pairsesList;
}
