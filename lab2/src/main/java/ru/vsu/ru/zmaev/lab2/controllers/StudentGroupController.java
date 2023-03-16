package ru.vsu.ru.zmaev.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.ru.zmaev.lab2.models.Group;
import ru.vsu.ru.zmaev.lab2.services.StudentGroupService;

import java.util.List;

@RestController
public class StudentGroupController {

    private final StudentGroupService service;

    public StudentGroupController(StudentGroupService service) {
        this.service = service;
    }

    @GetMapping("/groups")
    public List<Group> findAllGroups() {
        return service.getAllGroups();
    }
}
