package com.losung.contactApplication.repository;

import com.losung.contactApplication.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    Optional<Users> findByUserName(String username);
}
