package com.example.service;

import com.example.domain.Person;
import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class UserServiceImpl implements UserService {

    private @Autowired UserRepository userRepository;

    public User createUser(String name, String surname) {
        String password = "123456";
        Person person = Person.builder()
                .name(name)
                .surname(surname)
                .build();
        User user = new User();
        user.setPassword(password);
        user.setPerson(person);

        return userRepository.save(user);
    }
}
