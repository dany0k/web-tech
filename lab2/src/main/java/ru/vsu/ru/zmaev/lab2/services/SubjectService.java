package ru.vsu.ru.zmaev.lab2.services;

import org.jvnet.staxex.BinaryText;
import org.springframework.http.ResponseEntity;
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

    public Subject addSubject(Subject subject) {
        return repository.save(subject);
    }

    public Subject updateSubject(Integer id, Subject subject) throws IllegalArgumentException {
        return repository.findById(id).map(s -> {
            s.setSubjectId(subject.getSubjectId());
            s.setName(subject.getName());
            s.setDescription(subject.getDescription());
            return repository.save(s);
        }).orElseThrow(() -> new IllegalArgumentException("No such subject"));
    }

    public ResponseEntity<?> deleteSubject(Integer id) throws IllegalArgumentException {
        return repository.findById(id).map(s -> {
            repository.delete(s);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("No such subject"));
    }
}
