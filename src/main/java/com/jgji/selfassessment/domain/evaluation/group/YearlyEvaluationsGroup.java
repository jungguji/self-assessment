package com.jgji.selfassessment.domain.evaluation.group;

import com.jgji.selfassessment.domain.evaluation.group.id.YearlyEvaluationsGroupId;
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
@Table(name = "yearly_evaluations_group")
public class YearlyEvaluationsGroup {

    @EmbeddedId
    private YearlyEvaluationsGroupId id;
}
