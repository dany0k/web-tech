package ru.vsu.ru.zmaev.lab2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.ru.zmaev.lab2.models.Subject;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    List<Subject> findAll();

    Optional<Subject> findById(Integer id);

    @Query(value = "select s from Subject s where s.description = ?1")
    Optional<Subject> findByDescription(String description);

    @Query(value = "select s from Subject s where s.name = ?1")
    Optional<Subject> findByName(String name);
}
