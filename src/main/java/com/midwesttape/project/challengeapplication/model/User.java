package com.midwesttape.project.challengeapplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Entity
@Accessors(chain = true)
public class User {
	
	@Id
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Long addressid;
}
