package ru.vsu.ru.zmaev.lab2.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.vsu.ru.zmaev.lab2.models.SubjectGroupDto;
import ru.vsu.ru.zmaev.lab2.repositories.GroupJdbcRepository;
import ru.vsu.ru.zmaev.lab2.repositories.PairsJdbcRepository;
import ru.vsu.ru.zmaev.lab2.repositories.SubjectJdbcRepository;

@Service
public class SubjectGroupService {
    private final JdbcTemplate template;
    private final GroupJdbcRepository groupJdbcRepository;
    private final SubjectJdbcRepository subjectJdbcRepository;
    private final PairsJdbcRepository pairsJdbcRepository;

    public SubjectGroupService(JdbcTemplate template,
                               GroupJdbcRepository groupJdbcRepository,
                               SubjectJdbcRepository subjectJdbcRepository,
                               PairsJdbcRepository pairsJdbcRepository) {
        this.template = template;
        this.groupJdbcRepository = groupJdbcRepository;
        this.subjectJdbcRepository = subjectJdbcRepository;
        this.pairsJdbcRepository = pairsJdbcRepository;
    }

    public long createGroup(SubjectGroupDto dto) {
        return groupJdbcRepository.saveCustom(dto.getGroupNum());
    }
    public long createSubject(SubjectGroupDto dto) {
        return subjectJdbcRepository.saveCustom(dto.getSubjectName(), dto.getSubjectDesc());
    }

    public long createPair(Long groupId, Long subjectId, SubjectGroupDto dto) {
        return pairsJdbcRepository.saveCustom(groupId, subjectId, dto.getTimestamp());
    }
}
