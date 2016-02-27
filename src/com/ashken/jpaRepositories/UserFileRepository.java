package com.ashken.jpaRepositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ashken.entities.SiteUser;
import com.ashken.entities.UserFile;

public interface UserFileRepository extends JpaRepository<UserFile,Long>{
	
	public UserFile findById(int id);
	//public List<UserFile> findAll();
	public List<UserFile> findByOwner(SiteUser owner);
	public Page<UserFile> findByOwner(SiteUser owner,Pageable p);
	public Page<UserFile> findAll(Pageable p);
	public Page<UserFile> findByNameContaining(String name,Pageable p);
	public Page<UserFile> findByOwnerAndNameContaining(SiteUser owner,String name,Pageable p);
	public Page<UserFile> findByVisible(boolean visible,Pageable p);
	public Page<UserFile> findByVisibleAndNameContaining(boolean visible,String name,Pageable p);
}
