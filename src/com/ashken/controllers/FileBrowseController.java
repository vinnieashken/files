package com.ashken.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashken.entities.SiteUser;
import com.ashken.entities.UserFile;
import com.ashken.jpaRepositories.UserFileRepository;
import com.ashken.jpaRepositories.UserRepository;
import com.ashken.utils.DataTablesResponse;

@Controller
public class FileBrowseController {
	
String rootFolder = "D:/userFiles";
	
	@Autowired
	UserRepository userepo;
	
	@Autowired
	UserFileRepository filesRepo;
	
	@RequestMapping("/amyfiles")
	public String getUserFiles(Model model,Pageable p,Principal user,HttpServletRequest request)
	{
		SiteUser owner = userepo.findByUsername(user.getName());
		Page<UserFile> page = filesRepo.findByOwner(owner, p);
		model.addAttribute("page", page);
		
		return "myfiles";
	}
	
	@RequestMapping("/myfiles")
	public String getUserFilesPage()
	{
		return "userfiles";
	}
	
	@RequestMapping("/publicfiles")
	public String getPublicFilesPage()
	{
		return "publicfiles";
	}
	
	@RequestMapping("/userfiles/list")
	@ResponseBody
	public DataTablesResponse<UserFile> getUserFiles(Principal user,Pageable p)
	{
		SiteUser owner = userepo.findByUsername(user.getName());
		Page<UserFile> page = filesRepo.findByOwner(owner, p);
		DataTablesResponse<UserFile> response = new DataTablesResponse<UserFile>();
		response.setData(page.getContent());
		response.setTotalDisplayRecords(page.getTotalElements());
		response.setTotalRecords(page.getTotalElements());
		return response;
	}
	
	@RequestMapping("/userfiles/search")
	@ResponseBody
	public DataTablesResponse<UserFile> searchUserFiles(Principal user,HttpServletRequest request,Pageable p)
	{
		String name = request.getParameter("name");
		SiteUser owner = userepo.findByUsername(user.getName());
		Page<UserFile> page = filesRepo.findByOwnerAndNameContaining(owner, name, p);
		DataTablesResponse<UserFile> response = new DataTablesResponse<UserFile>();
		response.setData(page.getContent());
		response.setTotalDisplayRecords(page.getTotalElements());
		response.setTotalRecords(page.getTotalElements());
		return response;
	}
	
	@RequestMapping("/publicfiles/list")
	@ResponseBody
	public DataTablesResponse<UserFile> getPublicFiles(Pageable p)
	{
	
		Page<UserFile> page = filesRepo.findByVisible(true, p);
		DataTablesResponse<UserFile> response = new DataTablesResponse<UserFile>();
		response.setData(page.getContent());
		response.setTotalDisplayRecords(page.getTotalElements());
		response.setTotalRecords(page.getTotalElements());
		return response;
	}
	
	@RequestMapping("/publicfiles/search")
	@ResponseBody
	public DataTablesResponse<UserFile> searchPublicFiles(HttpServletRequest request,Pageable p)
	{
		String name = request.getParameter("name");
		Page<UserFile> page = filesRepo.findByVisibleAndNameContaining(true, name, p);
		DataTablesResponse<UserFile> response = new DataTablesResponse<UserFile>();
		response.setData(page.getContent());
		response.setTotalDisplayRecords(page.getTotalElements());
		response.setTotalRecords(page.getTotalElements());
		return response;
	}

}
