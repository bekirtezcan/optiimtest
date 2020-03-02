package com.optiimtest.userservice.repo;

import com.optiimtest.userservice.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@Configuration
public interface IUserRepository extends ReactiveMongoRepository<User, String> {
}
