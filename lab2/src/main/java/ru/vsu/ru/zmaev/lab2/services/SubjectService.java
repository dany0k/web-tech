package ru.vsu.ru.zmaev.lab2.services;

import org.springframework.stereotype.Service;
import ru.vsu.ru.zmaev.lab2.models.Subject;
import ru.vsu.ru.zmaev.lab2.repositories.SubjectRepository;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public List<Subject> getAllSubjects() {
        return repository.findAll();
    }

    public Subject getSubjectById(Integer id) throws IllegalArgumentException {
        return repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("No such subject"));
    }
    public Subject getSubjectByDescription(String description) {
        return repository.findByDescription(description).orElseThrow(() ->
                new IllegalArgumentException("Nu such subject"));
    }

    public Subject getSubjectByName(String name) {
        return repository.findByName(name).orElseThrow(() ->
                new IllegalArgumentException("Nu such subject"));
    }
}
