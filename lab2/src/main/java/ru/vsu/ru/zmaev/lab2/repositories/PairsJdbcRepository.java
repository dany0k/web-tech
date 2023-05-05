package ru.vsu.ru.zmaev.lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.ru.zmaev.lab2.models.Pairs;

import java.time.LocalTime;

@Repository
public interface PairsJdbcRepository extends JpaRepository<Pairs, Long> {
    @Query(
            value = "insert into pairs(group_id, subject_id, timestamp) " +
                    "values (:groupId, :subjectId, :time)" +
//                    "on conflict(subject_id, group_id) do nothing " +
                    "returning id",
            nativeQuery = true
    )
    Long saveCustom(@Param("groupId") Long groupId,
                    @Param("subjectId") Long subjectId,
                    @Param("time") LocalTime time);
}