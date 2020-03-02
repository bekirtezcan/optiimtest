package com.optiimtest.noteservice.repo;

import com.optiimtest.noteservice.model.Note;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@Configuration
public interface INoteRepository extends ReactiveMongoRepository<Note, String> {
}
