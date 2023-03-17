package ru.vsu.ru.zmaev.lab2.controllers;

import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.ru.zmaev.lab2.models.Pairs;
import ru.vsu.ru.zmaev.lab2.services.PairService;
import java.util.List;

@RestController
public class PairController {

    private final PairService service;

    public PairController(PairService service) {
        this.service = service;
    }

    @GetMapping("/pair")
    public List<Pairs> getAllPairs() {
        return service.getAllPairs();
    }

    @GetMapping("/pair/{id}")
    public ResponseEntity<?> getPairsById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getPairById(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @GetMapping("/pair/subject/{id}")
    public ResponseEntity<?> getPairsBySubjectId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getPairBySubjectId(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @GetMapping("/pair/group/{id}")
    public ResponseEntity<?> getPairsByGroupId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getPairByGroupId(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PostMapping("pair/create/group/{groupId}/subject/{subjectId}")
    public ResponseEntity<?> createPair(@RequestBody Pairs pairs,
                                        @PathVariable Integer groupId,
                                        @PathVariable Integer subjectId) {
        try {
            return ResponseEntity.ok(service.addPairs(pairs, groupId, subjectId));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PutMapping("/pair/{id}/update")
    public ResponseEntity<?> updatePairs(@PathVariable Integer id, @RequestBody Pairs pairs) {
        try {
            return ResponseEntity.ok(service.updatePairs(id, pairs));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @DeleteMapping("/pair/{id}/delete")
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