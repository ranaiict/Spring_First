package com.spring.spring_first.service.impl;

import com.spring.spring_first.model.User;
import com.spring.spring_first.repository.UserRepository;
import com.spring.spring_first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user, Model model) {
        int emailExistCount = userRepository.countByEmail(user.getEmail());
        if(user.getId() != null && emailExistCount == 1){
            emailExistCount = userRepository.countByEmailAndId(user.getEmail(), user.getId());
            if(emailExistCount == 0){
                model.addAttribute("result", "Email Already Exist");
                return null;
            }
            emailExistCount = 0;
        }
        if(emailExistCount > 0){
            model.addAttribute("result", "Email Already Exist");
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> list(){
        return userRepository.findAll();
    }

    @Override
    public User editUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
