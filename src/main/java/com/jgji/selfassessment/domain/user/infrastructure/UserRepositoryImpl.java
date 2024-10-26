package com.jgji.selfassessment.domain.user.infrastructure;

import com.jgji.selfassessment.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public User findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }

}
