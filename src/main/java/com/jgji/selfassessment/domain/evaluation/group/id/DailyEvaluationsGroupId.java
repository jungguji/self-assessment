package com.jgji.selfassessment.domain.evaluation.group.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class DailyEvaluationsGroupId implements Serializable {

    @Comment("평가 아이디")
    @Column(name = "evaluation_id", columnDefinition = "INT UNSIGNED", nullable = false)
    private long evaluationId;

    @Comment("평가 일단위 평가 아이디")
    @Column(name = "daily_evaluation_id", columnDefinition = "INT UNSIGNED", nullable = false)
    private long dailyEvaluationId;

    public DailyEvaluationsGroupId(long evaluationId, long dailyEvaluationId) {
        this.evaluationId = evaluationId;
        this.dailyEvaluationId = dailyEvaluationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyEvaluationsGroupId that = (DailyEvaluationsGroupId) o;
        return evaluationId == that.evaluationId && dailyEvaluationId == that.dailyEvaluationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(evaluationId, dailyEvaluationId);
    }
}
