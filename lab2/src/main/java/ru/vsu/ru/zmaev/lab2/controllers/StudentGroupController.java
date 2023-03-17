package ru.vsu.ru.zmaev.lab2.controllers;

import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.ru.zmaev.lab2.models.Group;
import ru.vsu.ru.zmaev.lab2.services.StudentGroupService;

import java.util.List;

@RestController
public class StudentGroupController {

    private final StudentGroupService service;

    public StudentGroupController(StudentGroupService service) {
        this.service = service;
    }

    @GetMapping("/group")
    public List<Group> findAllGroups() {
        return service.getAllGroups();
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<?> findGroupById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getGroupById(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PostMapping("group/create")
    public ResponseEntity<?> createGroup(@RequestBody Group group) {
        try {
            return ResponseEntity.ok(service.addGroup(group));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PutMapping("/group/{id}/update")
    public ResponseEntity<?> updateGroup(@PathVariable Integer id, @RequestBody Group group) {
        try {
            return ResponseEntity.ok(service.updateGroup(id, group));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @DeleteMapping("/group/{id}/delete")
    public ResponseEntity<?> deleteGroup(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.deleteGroup(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
}
