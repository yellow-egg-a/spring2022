package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.code.StatusCode;
import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcampus.programming.dmaker.dto.DeveloperDto;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.repository.RetiredDeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

//@SpringBootTest // Integrated Test // 실행할 때와 동일한 환경으로 등록된 Bean을 다 띄워서 돌려보겠다!
@ExtendWith(MockitoExtension.class) // Mockito라는 외부 툴을 이용해 테스트 하겠다!
class DMakerServiceTest {

    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private RetiredDeveloperRepository retiredDeveloperRepository;

    //    @Autowired
    @InjectMocks // 가짜를 DMakerService에 Inject 해준다!
    private DMakerService dMakerService;

    @Test
    public void testSomething() {
        // findByMemberId에 아무 문자열이나 주면 아래와 같이 응답하도록 mocking 해놓겠다!
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(Developer.builder()
                        .developerLevel(DeveloperLevel.SENIOR)
                        .developerSkillType(DeveloperSkillType.FRONT_END)
                        .experienceYears(12)
                        .statusCode(StatusCode.EMPLOYED)
                        .memberId("memberId")
                        .name("name")
                        .age(31)
                        .build()));

        DeveloperDetailDto developerDetail = dMakerService.getDeveloperDetail("memberId");

        assertEquals(DeveloperLevel.SENIOR, developerDetail.getDeveloperLevel());
        assertEquals(DeveloperSkillType.FRONT_END, developerDetail.getDeveloperSkillType());
        assertEquals(12, developerDetail.getExperienceYears());
    }

//    @Test
//    public void testSomething() {
//        dMakerService.createDeveloper(CreateDeveloper.Request.builder()
//                .developerLevel(DeveloperLevel.SENIOR)
//                .developerSkillType(DeveloperSkillType.FRONT_END)
//                .experienceYears(12)
//                .memberId("memberId")
//                .name("name")
//                .age(31)
//                .build());
//        List<DeveloperDto> allEmployedDevelopers = dMakerService.getAllEmployedDevelopers();
//
//        System.out.println("==========================");
//        System.out.println(allEmployedDevelopers);
//        System.out.println("==========================");
//    }
}