package ru.vsu.ru.zmaev.lab2.controllers;

import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.ru.zmaev.lab2.models.Group;
import ru.vsu.ru.zmaev.lab2.models.Pairs;
import ru.vsu.ru.zmaev.lab2.models.Subject;
import ru.vsu.ru.zmaev.lab2.services.PairsService;

import java.util.List;

@RestController
public class PairsController {

    private final PairsService service;

    public PairsController(PairsService service) {
        this.service = service;
    }

    @GetMapping("/pairs")
    public List<Pairs> getAllPairs() {
        return service.getAllPairs();
    }

    @GetMapping("/pairs/subject/{id}")
    public ResponseEntity<?> getPairsBySubjectId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getPairBySubjectId(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @GetMapping("/pairs/group/{id}")
    public ResponseEntity<?> getPairsByGroupId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getPairByGroupId(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PostMapping("pairs/create")
    public ResponseEntity<?> createPair(@RequestBody Pairs pairs) {
        try {
            return ResponseEntity.ok(service.addPairs(pairs));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PutMapping("/pairs/{id}/update")
    public ResponseEntity<?> updatePairs(@PathVariable Integer id, @RequestBody Pairs pairs) {
        try {
            return ResponseEntity.ok(service.updatePairs(id, pairs));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @DeleteMapping("/pairs/{id}/delete")
    public ResponseEntity<?> deletePairs(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.deletePairs(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
}

