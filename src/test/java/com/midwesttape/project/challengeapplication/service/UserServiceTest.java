package com.midwesttape.project.challengeapplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.midwesttape.project.challengeapplication.exception.UserNotFoundException;
import com.midwesttape.project.challengeapplication.model.Address;
import com.midwesttape.project.challengeapplication.model.User;
import com.midwesttape.project.challengeapplication.model.UserDetails;
import com.midwesttape.project.challengeapplication.repository.AddressRepository;
import com.midwesttape.project.challengeapplication.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private static final Long USER_ID = 1L;
    private static final Long ADDRESS_ID = 1L;
    
	@InjectMocks
	private UserService userService;
	@Mock
    private AddressRepository addressRepository;
	@Mock
    private UserRepository userRepository;
	
    @Test
    public void should_get_user() {
    	Optional<User> optionalUser = Optional.of(getUser());
    	Optional<Address> optionalAddress = Optional.of(getAddress());
        when(userRepository.findById(USER_ID)).thenReturn(optionalUser);
        when(addressRepository.findById(ADDRESS_ID)).thenReturn(optionalAddress);
        UserDetails resultUserDetails = userService.getUserDetails(USER_ID);
        assertEquals(getUserDetails(), resultUserDetails);
        assertNotNull(resultUserDetails);
    }
    
    @Test
    void testExpectedExceptionWithNoValidUser() {
    	Optional<User> optionalUser = Optional.empty();
    	when(userRepository.findById(anyLong())).thenReturn(optionalUser);
    	Assertions.assertThrows(UserNotFoundException.class, () -> {
    		userService.getUserDetails(Long.valueOf(3));
    	});
    }
    
	public User getUser() {
		User user = new User();
		return user.setId(USER_ID).setFirstName("Phil").setLastName("Ingwell").setUsername("PhilIngwell")
				.setPassword("Password123").setAddressid(ADDRESS_ID);
	}
    
	public Address getAddress() {
		Address address = new Address();
		return address.setId(ADDRESS_ID).setAddress1("5400 River Rd").setAddress2("RiverGrove").setCity("Rockwell")
				.setState("IL").setPostal("60079");
	}

	public UserDetails getUserDetails() {
		UserDetails userDetails = new UserDetails();
		return userDetails.setId(USER_ID).setFirstName("Phil").setLastName("Ingwell").setUsername("PhilIngwell")
				.setPassword("Password123").setAddress(getAddress());
	}
}