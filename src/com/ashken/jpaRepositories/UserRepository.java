package com.ashken.jpaRepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashken.entities.SiteUser;

public interface UserRepository extends JpaRepository<SiteUser,Long>{
	
	public SiteUser findByUsername(String username);
	public SiteUser findByEmail(String email);
	public List<SiteUser> findAll();

}
