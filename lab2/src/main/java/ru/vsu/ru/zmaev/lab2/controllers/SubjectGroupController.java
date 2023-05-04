package ru.vsu.ru.zmaev.lab2.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.ru.zmaev.lab2.models.SubjectGroupDto;
import ru.vsu.ru.zmaev.lab2.services.SubjectGroupService;

@RestController
@RequestMapping(
        path = "/subject-group",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class SubjectGroupController {
    private final SubjectGroupService service;

    public SubjectGroupController(SubjectGroupService service) {
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody SubjectGroupDto dto) {
        long subjectId = service.createSubject(dto);
        long groupId = service.createGroup(dto);
        long id = service.createPair(groupId, subjectId, dto);
        return ResponseEntity.ok(String.valueOf(id));
    }
}
