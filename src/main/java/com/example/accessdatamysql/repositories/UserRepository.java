package com.example.accessdatamysql.repositories;

import com.example.accessdatamysql.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
     * CRUD refers Create, Read, Update, Delete
     *
     */
    User findByUsername(String username);
}
