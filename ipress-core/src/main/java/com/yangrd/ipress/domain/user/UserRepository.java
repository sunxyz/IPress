package com.yangrd.ipress.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepository
 *
 * @author yangrd
 * @date 2019/05/13
 */
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByUsername(String username);
}
