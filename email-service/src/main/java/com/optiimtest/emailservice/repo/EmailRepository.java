package com.optiimtest.emailservice.repo;

import com.optiimtest.emailservice.model.Email;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@Configuration
public interface EmailRepository extends ReactiveMongoRepository<Email, String> {
}
