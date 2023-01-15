package com.midwesttape.project.challengeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midwesttape.project.challengeapplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
