package ru.vsu.ru.zmaev.lab2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import ru.vsu.ru.zmaev.lab2.models.Pairs;

import java.util.List;
import java.util.Optional;

public interface PairsRepository extends CrudRepository<Pairs, Integer> {
    List<Pairs> findAll();

    Optional<Pairs> findByPairsId(Integer id);
    @Query(value = "SELECT p FROM pairs WHERE p.group_id = ?1")
    List<Pairs> findByStudentGroupId(Integer groupId);
}
