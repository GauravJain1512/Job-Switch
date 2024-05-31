package com.spring.security.jwt.two.serivice;

import com.spring.security.jwt.two.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface PublicService {

    public List<User> getAllUsers();

    public User saveUser(User user);

    public User getUserById(Long userId);

    public User updateUserDetails(Long userId, Map<String, Object> properties);

    public User updateUser(Long userId, User user);

    public void deleteUser(Long id) throws Exception;
}
