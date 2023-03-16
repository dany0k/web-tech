package ru.vsu.ru.zmaev.lab2.services;

import org.springframework.stereotype.Service;
import ru.vsu.ru.zmaev.lab2.models.Pairs;
import ru.vsu.ru.zmaev.lab2.repositories.PairsRepository;

import java.util.List;

@Service
public class PairsService {

    private PairsRepository repository;

    public PairsService(PairsRepository repository) {
        this.repository = repository;
    }

    public List<Pairs> getAllPairs() {
        return repository.findAll();
    }

    public Pairs getPairById(Integer id) throws IllegalArgumentException {
        return repository.findByPairsId(id).orElseThrow(() -> new IllegalArgumentException("No such pair"));
    }

    public Pairs getPairBySubjectId(Integer id) throws IllegalArgumentException {
        return repository.findBySubjectId(id).orElseThrow(() -> new IllegalArgumentException("No such pair"));
    }

    public Pairs getPairByGroupId(Integer id) {
        return repository.findByStudentGroupId(id).orElseThrow(() -> new IllegalArgumentException("Nu such pair"));
    }
}
