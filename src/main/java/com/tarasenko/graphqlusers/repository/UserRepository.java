package com.tarasenko.graphqlusers.repository;

import org.springframework.data.repository.CrudRepository;

import com.tarasenko.graphqlusers.entity.User;

public interface UserRepository extends CrudRepository<User, Long>
{
}
