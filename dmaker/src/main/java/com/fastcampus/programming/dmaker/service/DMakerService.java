package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DMakerService {
    private final DeveloperRepository developerRepository; // @RequiredArgsConstructor 를 썼기 때문에 자동으로 injection 받음
                                                            // => final이 들어간 생성자를 자동으로 만들어줌
    private final EntityManager em;

    // ACID
    // Atomic
    // Consistency
    // Isolation
    // Durability
    @Transactional
    public void createDeveloper(CreateDeveloper.Request request) {
        // busuiness logic start
        // Entity 만들기
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("Olaf")
                .age(5)
                .build(); // Developer.java에 @Builder를 넣어놔서 .build를 사용할 수 있음

        // DB에 저장
        developerRepository.save(developer);
        // business logic end
    }
}
