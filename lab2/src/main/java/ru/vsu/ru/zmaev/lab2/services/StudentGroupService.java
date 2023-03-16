package ru.vsu.ru.zmaev.lab2.services;

import org.springframework.stereotype.Service;
import ru.vsu.ru.zmaev.lab2.models.Group;
import ru.vsu.ru.zmaev.lab2.repositories.StudentGroupRepository;

import java.util.List;

@Service
public class StudentGroupService {
    private final StudentGroupRepository repository;

    public StudentGroupService(StudentGroupRepository repository) {
        this.repository = repository;
    }

    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public Group getGroupById(Integer id) throws IllegalArgumentException {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such group"));
    }

    public Group getGroupByNumber(Integer number) throws IllegalArgumentException {
        return repository.findAllByNumber(number).orElseThrow(() -> new IllegalArgumentException("No such group"));
    }
}
