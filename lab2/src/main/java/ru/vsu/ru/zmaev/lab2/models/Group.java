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
@Table(name = "student_group")
public class Group implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private int groupId;

    @Column
    private int number;

    public Group(int number) {
        this.number = number;
    }
}
