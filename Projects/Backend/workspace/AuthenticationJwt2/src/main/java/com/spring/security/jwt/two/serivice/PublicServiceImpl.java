package com.spring.security.jwt.two.serivice;

import com.spring.security.jwt.two.entity.User;
import com.spring.security.jwt.two.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PublicServiceImpl implements PublicService{

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUserDetails(Long userId, Map<String, Object> properties) {
        User user = userRepository.findById(userId).orElse(null);
        if(null == user){
            return null;
        }else{
            properties.forEach((key,value)->
                    {
                        Field field = ReflectionUtils.findField(User.class, key);
                        if (field != null) {
                            field.setAccessible(true);
                        }
                        if (field != null) {
                            ReflectionUtils.setField(field,user,value);
                        }
                    }
                    );
            return userRepository.save(user);
        }
    }

    @Override
    public User updateUser(Long userId, User user) {
        User user1 = userRepository.findById(userId).orElse(null);
        if(null == user1){
            return null;
        }else{
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setLastName(user.getLastName());
            user1.setFirstName(user.getFirstName());
            user1.setAddress(user.getAddress());
            return userRepository.save(user1);
        }
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        User user1 = userRepository.findById(userId).orElse(null);
        if(null == user1){
            throw new Exception("User not found");
        }else{
            userRepository.delete(user1);
        }
    }
}
