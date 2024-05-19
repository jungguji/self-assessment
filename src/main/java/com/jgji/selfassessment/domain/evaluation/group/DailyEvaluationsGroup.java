package com.jgji.selfassessment.domain.evaluation.group;

import com.jgji.selfassessment.domain.evaluation.group.id.DailyEvaluationsGroupId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "daily_evaluations_group")
public class DailyEvaluationsGroup {

    @EmbeddedId
    private DailyEvaluationsGroupId id;
}
