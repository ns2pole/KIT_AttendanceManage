package com.example.AttandanceManage;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserCrudRepository extends CrudRepository<MyUser, Integer> {
    Optional<MyUser> findByName(String name);
    Optional<MyUser> findByid(int id);

}