package com.midwesttape.project.challengeapplication.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.midwesttape.project.challengeapplication.exception.UserNotFoundException;
import com.midwesttape.project.challengeapplication.model.Address;
import com.midwesttape.project.challengeapplication.model.User;
import com.midwesttape.project.challengeapplication.model.UserDetails;
import com.midwesttape.project.challengeapplication.repository.AddressRepository;
import com.midwesttape.project.challengeapplication.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	
	@Resource
    private AddressRepository addressRepository;
	@Resource
    private UserRepository userRepository;

	public Address getAddress(Long addressId) {
		return addressRepository.findById(addressId).get();
	}
	
	public UserDetails getUserDetails(Long userId) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(userId);
		optionalUser.orElseThrow(() -> new UserNotFoundException("User Not found: " + userId));
		User user = optionalUser.get();
		return getUserDetails(user, user.getAddressid());
	}
	
	public UserDetails getUserDetails(User user, Long id) {
		UserDetails userDetails = new UserDetails();
		return userDetails.setFirstname(user.getFirstname()).setLastname(user.getLastname())
				.setPassword(user.getPassword()).setUsername(user.getUsername()).setId(user.getId())
				.setAddress(getAddress(id));
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
}
