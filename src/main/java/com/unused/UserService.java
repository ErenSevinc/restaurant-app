//package com.service;
//
//import com.entity.User;
//import com.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    public List<User> getAllUser(){
//        return userRepository.findAll();
//    }
//    public User getSelectedUser(int id){
//        return userRepository.findAll().stream().filter(usr-> usr.getId() == id).findFirst().get();
//    }
//    public User addUser(User user){
//        return userRepository.save(user);
//    }
//    public User updateUser(int id,User user){
//        Optional<User> optional = userRepository.findAll().stream().filter(p->p.getId() == id).findAny();
//        if (!optional.isPresent()){
//            System.out.println("Sonuç bulunamadı");
//            return null;
//        }
//        optional.get().setUsername(user.getUsername());
//        optional.get().setPassword(user.getPassword());
//        optional.get().setRole(user.getRole());
//
//
//        return userRepository.save(optional.get());
//    }
//    public List<User> deleteUser(int id){
//        userRepository.deleteById(id);
//        return userRepository.findAll();
//    }
//
//}
