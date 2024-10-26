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
public class WeeklyEvaluationsGroupId implements Serializable {

    @Comment("일단위 평가 그룹 아이디")
    @Column(name = "daily_evaluations_group_id", columnDefinition = "INT UNSIGNED", nullable = false)
    private long dailyEvaluationsGroupId;

    @Comment("주단위 평가 아이디")
    @Column(name = "weekly_evaluation_id", columnDefinition = "INT UNSIGNED", nullable = false)
    private long weeklyEvaluationId;

    public WeeklyEvaluationsGroupId(long dailyEvaluationsGroupId, long weeklyEvaluationId) {
        this.dailyEvaluationsGroupId = dailyEvaluationsGroupId;
        this.weeklyEvaluationId = weeklyEvaluationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeeklyEvaluationsGroupId that = (WeeklyEvaluationsGroupId) o;
        return dailyEvaluationsGroupId == that.dailyEvaluationsGroupId && weeklyEvaluationId == that.weeklyEvaluationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dailyEvaluationsGroupId, weeklyEvaluationId);
    }
}
