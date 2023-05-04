package ru.vsu.ru.zmaev.lab2.models;

import lombok.Data;

import java.time.LocalTime;

@Data
public class SubjectGroupDto {
    private int groupNum;
    private String subjectName;
    private String subjectDesc;
    private LocalTime timestamp;
}
