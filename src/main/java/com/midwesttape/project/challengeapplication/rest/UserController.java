package com.midwesttape.project.challengeapplication.rest;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.midwesttape.project.challengeapplication.model.User;
import com.midwesttape.project.challengeapplication.model.UserDetails;
import com.midwesttape.project.challengeapplication.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

	@Resource
    private UserService userService;

    @GetMapping("/{userId}")
    public UserDetails user(@PathVariable final Long userId) {
    	return userService.getUserDetails(userId);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
	public void updateTopic(@RequestBody User user) {
    	userService.updateUser(user);
	}

}
