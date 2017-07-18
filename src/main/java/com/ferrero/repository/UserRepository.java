package com.ferrero.repository;

import com.ferrero.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by drugo on 16/06/2017.
 */// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

}
