package ru.vsu.ru.zmaev.lab2.services;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.vsu.ru.zmaev.lab2.models.Pairs;
import ru.vsu.ru.zmaev.lab2.repositories.PairsRepository;

import java.time.LocalTime;
import java.util.Date;
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

    public Pairs addPairs(Pairs pairs) {
        return repository.save(pairs);
    }

    public Pairs updatePairs(Integer id, Pairs pairs) throws IllegalArgumentException {
        return repository.findByPairsId(id).map(p -> {
            p.setPairsId(pairs.getPairsId());
            p.setSubject(p.getSubject());
            p.setStudentGroup(p.getStudentGroup());
            p.setTimeSeries(LocalTime.MAX);
            return repository.save(p);
        }).orElseThrow(() -> new IllegalArgumentException("No such pair"));
    }

    public ResponseEntity<?> deletePairs(Integer id) throws IllegalArgumentException {
        return repository.findByPairsId(id).map(p -> {
            repository.delete(p);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("No such pair"));
    }
}
