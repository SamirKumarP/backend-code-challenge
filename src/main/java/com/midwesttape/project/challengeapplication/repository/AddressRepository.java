package com.midwesttape.project.challengeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midwesttape.project.challengeapplication.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
