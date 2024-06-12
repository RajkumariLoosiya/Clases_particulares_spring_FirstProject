package com.migue.gestion_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migue.gestion_usuarios.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
