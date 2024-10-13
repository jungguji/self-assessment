package com.jgji.selfassessment.domain.user.infrastructure;

import com.jgji.selfassessment.domain.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User findByEmail(String email);
}
