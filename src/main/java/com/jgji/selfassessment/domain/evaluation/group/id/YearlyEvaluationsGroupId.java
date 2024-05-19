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
public class YearlyEvaluationsGroupId implements Serializable {

    @Comment("월단위 평가 그룹 아이디")
    @Column(name = "monthly_evaluations_group_id", nullable = false)
    private long monthlyEvaluationsGroupId;

    @Comment("연단위 평가 아이디")
    @Column(name = "yearly_evaluation_id", nullable = false)
    private long yearlyEvaluationId;

    public YearlyEvaluationsGroupId(long monthlyEvaluationsGroupId, long yearlyEvaluationId) {
        this.monthlyEvaluationsGroupId = monthlyEvaluationsGroupId;
        this.yearlyEvaluationId = yearlyEvaluationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearlyEvaluationsGroupId that = (YearlyEvaluationsGroupId) o;
        return monthlyEvaluationsGroupId == that.monthlyEvaluationsGroupId && yearlyEvaluationId == that.yearlyEvaluationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthlyEvaluationsGroupId, yearlyEvaluationId);
    }
}