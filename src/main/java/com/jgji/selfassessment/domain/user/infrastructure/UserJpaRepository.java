package com.jgji.selfassessment.domain.user.infrastructure;

import com.jgji.selfassessment.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
