package com.spring.spring_first.service;

import com.spring.spring_first.model.User;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user, Model model);

    List<User> list();

    User editUser(Long id);

    boolean deleteUser(Long id);
}
