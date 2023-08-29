package com.redmath.users;

import com.redmath.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from users where user_name = ?", nativeQuery = true)
    User findByUserName (String username);
}