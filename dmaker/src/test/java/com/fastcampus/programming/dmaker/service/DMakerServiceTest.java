package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.dto.DeveloperDto;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Integrated Test // 실행할 때와 동일한 환경으로 등록된 Bean을 다 띄워서 돌려보겠다!
class DMakerServiceTest {

    @Autowired
    private DMakerService dMakerService;

    @Test
    public void testSomething() {
        dMakerService.createDeveloper(CreateDeveloper.Request.builder()
                .developerLevel(DeveloperLevel.SENIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(12)
                .memberId("memberId")
                .name("name")
                .age(31)
                .build());
        List<DeveloperDto> allEmployedDevelopers = dMakerService.getAllEmployedDevelopers();

        System.out.println("==========================");
        System.out.println(allEmployedDevelopers);
        System.out.println("==========================");
    }
}