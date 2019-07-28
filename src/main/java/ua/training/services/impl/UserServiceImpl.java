package ua.training.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.training.entities.Role;
import ua.training.entities.User;
import ua.training.repositories.RoleRepository;
import ua.training.repositories.UserRepository;
import ua.training.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.management.relation.RoleNotFoundException;
import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }


    @Override
    public User registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // user.setRoles(Collections.singleton(Role.getDefaultRoleInstance()));
        return userRepository.save(user);
    }




}


//    public static User getDefaultInspectorInstance() {
////        if (defaultInspectorByRegistrationInstance == null) {
////            synchronized (User.class) {
////                if (defaultInspectorByRegistrationInstance == null) {
////                    defaultInspectorByRegistrationInstance = new User();
////                    defaultInspectorByRegistrationInstance.setId(1L);
////                }
////            }
////        }
////        return defaultInspectorByRegistrationInstance;
////    }
