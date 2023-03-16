package ru.vsu.ru.zmaev.lab2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.vsu.ru.zmaev.lab2.models.Pairs;

import java.util.List;
import java.util.Optional;

public interface PairsRepository extends CrudRepository<Pairs, Integer> {
    List<Pairs> findAll();

    Optional<Pairs> findByPairsId(Integer id);
    @Query(value = "SELECT p FROM Pairs p WHERE p.studentGroup.groupId = ?1")
    Optional<Pairs> findByStudentGroupId(Integer groupId);
    @Query(value = "SELECT p FROM Pairs p WHERE p.subject.subjectId = ?1")
    Optional<Pairs> findBySubjectId(Integer subjectId);
}
