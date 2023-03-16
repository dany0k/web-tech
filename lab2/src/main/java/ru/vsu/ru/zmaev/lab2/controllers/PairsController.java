package ru.vsu.ru.zmaev.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.ru.zmaev.lab2.models.Pairs;
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
}
