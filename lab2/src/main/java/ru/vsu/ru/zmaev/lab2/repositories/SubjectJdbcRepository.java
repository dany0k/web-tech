package ru.vsu.ru.zmaev.lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.ru.zmaev.lab2.models.Subject;

@Repository
public interface SubjectJdbcRepository extends JpaRepository<Subject, Long> {
    @Query(
            value = "insert into subject(name, description) " +
                    "values (:name, :description) " +
                    "on conflict (name) do update set " +
                    "name = excluded.name " +
                    "returning id;",
            nativeQuery = true
    )
    Long saveCustom(@Param("name") String name, @Param("description") String description);
}
