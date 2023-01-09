package com.fastcampus.programming.dmaker.entity;


import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class RetiredDeveloper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String memberId;
    private String name;

    // @EnableJpaAuditing를 DmakerApplication.java에 추가하고,
    // @EntityListeners(AuditingEntityListener.class)를 현재 Entity에 추가하면
    // JPA가 CreatedDate, LastModifiedDate를 자동으로 수정해준다.
    // 참고자료: Baeldung https://www.baeldung.com/database-auditing-jpa
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
