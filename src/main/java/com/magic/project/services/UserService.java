package com.magic.project.services;

import com.magic.project.models.Password;
import com.magic.project.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.validation.Valid;
import java.util.List;

public interface UserService extends UserDetailsService {

	User updateUserPassword(@Valid Password updatedPassword, @Valid String username);

	void saveUser( User user);

	List<User> getUserList();

	org.springframework.security.core.userdetails.User loadUserByUsername(String username)
			throws UsernameNotFoundException;

	String getUserRole(String username);

}