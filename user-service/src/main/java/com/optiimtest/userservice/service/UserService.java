package com.optiimtest.userservice.service;

import com.optiimtest.userservice.model.User;
import com.optiimtest.userservice.repo.IUserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@Service
public class UserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public Mono<User> findById(String id){
        return userRepository.findById(id).delayElement(Duration.ofMillis(10000));
    }

    public Flux<User> findAll(){
        return userRepository.findAll();
    }

    public Mono<User> insert(User user){
        return userRepository.insert(user);
    }

    public Mono<Void> deleteAll(){
        return userRepository.deleteAll();
    }

    public Mono<Void> deleteById(String id){
        return userRepository.deleteById(id);
    }
}
