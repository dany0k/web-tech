package ru.vsu.ru.zmaev.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.ru.zmaev.lab2.models.Subject;
import ru.vsu.ru.zmaev.lab2.services.SubjectService;

import java.util.List;

@RestController
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("/subject")
    public List<Subject> findAllSubjects() {
        return service.getAllSubjects();
    }
}
