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
public class MonthlyEvaluationsGroupId implements Serializable {

    @Comment("주단위 평가 그룹 아이디")
    @Column(name = "weekly_evaluations_group_id", nullable = false)
    private long weeklyEvaluationsGroupId;

    @Comment("월단위 평가 아이디")
    @Column(name = "monthly_evaluation_id", nullable = false)
    private long monthlyEvaluationId;

    public MonthlyEvaluationsGroupId(long weeklyEvaluationsGroupId, long monthlyEvaluationId) {
        this.weeklyEvaluationsGroupId = weeklyEvaluationsGroupId;
        this.monthlyEvaluationId = monthlyEvaluationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthlyEvaluationsGroupId that = (MonthlyEvaluationsGroupId) o;
        return weeklyEvaluationsGroupId == that.weeklyEvaluationsGroupId && monthlyEvaluationId == that.monthlyEvaluationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weeklyEvaluationsGroupId, monthlyEvaluationId);
    }
}
