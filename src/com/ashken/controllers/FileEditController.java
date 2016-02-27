package com.ashken.controllers;

import java.io.File;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashken.entities.SiteUser;
import com.ashken.entities.UserFile;
import com.ashken.jpaRepositories.UserFileRepository;
import com.ashken.jpaRepositories.UserRepository;

@Controller
public class FileEditController {
	
	String rootFolder = "D:/userFiles";
	
	@Autowired
	UserRepository userepo;
	
	@Autowired
	UserFileRepository filesRepo;
	
	@RequestMapping("/status/{ID}")
	@ResponseBody
	public void changeVisibility(@PathVariable("ID") int id, Principal p)
	{
		SiteUser siteUser = userepo.findByUsername(p.getName());
		UserFile file = filesRepo.findById(id);
		
		if(siteUser.getId() == file.getOwner().getId())
		{
			if(file.isVisible())
				file.setVisible(false);
			else
				file.setVisible(true);
			
			filesRepo.save(file);
		}
		
		return ;//"redirect:/myfiles";
	}
	
	@RequestMapping("/delete/{ID}")
	@ResponseBody
	public void deleteFile(@PathVariable("ID") int id,Principal p, HttpServletRequest request)
	{
		SiteUser siteUser = userepo.findByUsername(p.getName());
		UserFile file = filesRepo.findById(id);
		
		if(siteUser.getId() == file.getOwner().getId())
		{
			File f = new File(rootFolder+"/"+siteUser.getId() +"/"+file.getName());
			
			filesRepo.delete(file);
			
			if(f.exists())
				f.delete();

		}
		
		return; // "redirect:/myfiles";
	}
		

}
