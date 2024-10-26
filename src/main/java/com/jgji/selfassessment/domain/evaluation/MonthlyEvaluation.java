package com.jgji.selfassessment.domain.evaluation;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "monthly_evaluations", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "month"})
})
public class MonthlyEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED", nullable = false, updatable = false)
    private long id;

    @Comment("유저 아이디")
    @Column(name = "user_id", columnDefinition = "INT UNSIGNED", nullable = false)
    private long userId;

    @Comment("평가 월")
    @Column(name = "month", nullable = false)
    private LocalDate month;

    @Comment("점수")
    @Column(name = "score", nullable = false)
    private BigDecimal score;

    @Comment("코멘트")
    @Column(name = "comment")
    private String comment;
}
