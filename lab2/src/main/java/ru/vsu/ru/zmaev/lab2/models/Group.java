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
@Table(name = "student_group")
public class Group implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int groupId;

    @Column
    private int number;

    public Group(int number) {
        this.number = number;
    }

    @OneToMany(mappedBy = "studentGroup")
    @JsonIgnore
    private List<Pairs> pairsesList;
}
