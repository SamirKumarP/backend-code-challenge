package com.midwesttape.project.challengeapplication.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDetails {
	
	private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Address address;

}
