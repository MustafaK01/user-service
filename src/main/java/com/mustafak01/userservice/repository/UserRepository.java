package com.mustafak01.userservice.repository;

import com.mustafak01.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);

}