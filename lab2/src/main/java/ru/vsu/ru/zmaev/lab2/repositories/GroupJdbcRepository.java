package ru.vsu.ru.zmaev.lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.ru.zmaev.lab2.models.Group;

@Repository
public interface GroupJdbcRepository extends JpaRepository<Group, Long> {
    @Query(
            value = "insert into student_group(number)" +
                    "values (?1) on conflict(number) " +
                    "do update set number = excluded.number " +
                    "RETURNING id;",
            nativeQuery = true
    )
    Long saveCustom(@Param("number") Integer number);
}
