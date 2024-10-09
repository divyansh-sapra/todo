package com.example.todo.repository;

import com.example.todo.entity.UsersEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UsersEntity, ObjectId> {
    UsersEntity findByUserName(String usersName);
}
