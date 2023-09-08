package com.magic.project.repositories;

import com.magic.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT user.role FROM User user WHERE user.username = :username")
	String findRoleByUsername(String username);

}