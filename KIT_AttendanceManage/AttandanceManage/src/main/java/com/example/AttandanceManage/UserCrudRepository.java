package com.example.AttandanceManage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCrudRepository extends CrudRepository<MyUser, Integer> {
    Optional<MyUser> findByName(String name);

}