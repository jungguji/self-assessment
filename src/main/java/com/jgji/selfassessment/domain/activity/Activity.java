package com.jgji.selfassessment.domain.activity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED", nullable = false, updatable = false)
    private long id;

    @Comment("작성한 유저 아이디")
    @Column(name = "user_id", columnDefinition = "INT UNSIGNED", nullable = false)
    private long userId;

    @Comment("평가 대상일")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Comment("행동 시작시간")
    @Column(name = "start_time")
    private LocalTime startTime;

    @Comment("행동 종료시간")
    @CreatedDate
    @Column(name = "end_time")
    private LocalTime endTime;

    @Comment("설명")
    @LastModifiedDate
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Comment("생성일시")
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Comment("수정일시")
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;
}
