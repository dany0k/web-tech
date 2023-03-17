package ru.vsu.ru.zmaev.lab2.controllers;

import net.minidev.json.JSONObject;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/subject/{id}")
    public ResponseEntity<?> findBySubjectId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getSubjectById(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PostMapping("/subject/create")
    public ResponseEntity<?> createSubject(@RequestBody Subject subject) {
        try {
            return ResponseEntity.ok(service.addSubject(subject));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PutMapping("/subject/{id}/update")
    public ResponseEntity<?> updateSubject(@PathVariable Integer id, @RequestBody Subject subject) {
        try {
            return ResponseEntity.ok(service.updateSubject(id, subject));
        } catch (IllegalIdentifierException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @DeleteMapping("/subject/{id}/delete")
    public ResponseEntity<?> deleteSubject(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.deleteSubject(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
}
