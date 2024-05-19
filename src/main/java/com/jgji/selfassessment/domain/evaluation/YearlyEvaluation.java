package com.jgji.selfassessment.domain.evaluation;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "yearly_evaluations", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "year"})
})
public class YearlyEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Comment("유저 아이디")
    @Column(name = "user_id", nullable = false)
    private long userId;

    @Comment("평가 연도")
    @Column(name = "year", nullable = false)
    private LocalDate year;

    @Comment("점수")
    @Column(name = "score", nullable = false)
    private float score = 0.0f;
}