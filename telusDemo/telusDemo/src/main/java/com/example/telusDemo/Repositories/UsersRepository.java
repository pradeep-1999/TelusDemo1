package com.example.telusDemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.telusDemo.Entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
