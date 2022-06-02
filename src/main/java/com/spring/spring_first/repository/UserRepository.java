package com.spring.spring_first.repository;

import com.spring.spring_first.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
    int countByUsername(String username);
    int countByEmail(String email);
    int countByEmailAndId(String email, Long id);
    int countByPhoneNo(String phoneNo);

}
