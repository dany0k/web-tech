package ru.vsu.ru.zmaev.lab2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.ru.zmaev.lab2.models.Group;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentGroupRepository extends CrudRepository<Group, Integer> {
    List<Group> findAll();

    Optional<Group> findById(Integer id);

    @Query(value = "SELECT g from Group g where g.number = ?1")
    Optional<Group> findAllByNumber(Integer number);
}
