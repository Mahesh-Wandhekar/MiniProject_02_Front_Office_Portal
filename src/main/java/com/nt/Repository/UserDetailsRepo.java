package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {

	public UserDetails findByEmail(String email);
	public UserDetails findByEmailAndPassword(String email,String password);
}
