package com.procesos.tienda.service;

import com.procesos.tienda.model.User;
import com.procesos.tienda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User userReq){
        return userRepository.save(userReq);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }
    public User updateUser(User userReq, Long id){
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            return null;
        }
        userBd.get().setFirstName(userReq.getFirstName());
        userBd.get().setLastName(userReq.getLastName());
        userBd.get().setPhone(userReq.getPhone());
        return userRepository.save(userBd.get());
    }

    public boolean deleteUser(Long id){
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            return false;
        }
        userRepository.delete(userBd.get());
        return true;
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }
}
