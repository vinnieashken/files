package com.ashken.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ashken.entities.SiteUser;
import com.ashken.entities.UserFile;
import com.ashken.jpaRepositories.UserFileRepository;
import com.ashken.jpaRepositories.UserRepository;

@Controller
public class FileUploadController {
	
	String rootFolder = "D:/userFiles";
	
	@Autowired
	UserRepository userepo;
	
	@Autowired
	UserFileRepository filesRepo;
	
	@RequestMapping("/uploads")
	public String getUploadPage()
	{
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String handleFileUpload(HttpServletRequest request,@RequestParam("fileUpload") CommonsMultipartFile[] fileUpload,Principal principal) throws Exception
	{
		SiteUser user = userepo.findByUsername(principal.getName());
		
		if(fileUpload != null && fileUpload.length > 0)
		{
			
			for(CommonsMultipartFile file: fileUpload)
			{
				if(!file.isEmpty())
				{
					UserFile userfile = new UserFile();
					userfile.setName(file.getOriginalFilename());
					userfile.setOwner(user);
					userfile.setVisible(false);
					//save file info
					filesRepo.save(userfile);
					File binFile = new File(rootFolder +"/" + user.getId() +"/"+ file.getOriginalFilename());
					
					if(!binFile.getParentFile().exists())
						binFile.getParentFile().mkdirs();
					if(!binFile.exists())
						binFile.createNewFile();
					
					FileOutputStream out = new FileOutputStream(binFile);
					out.write(file.getBytes());
					out.close();
				}
				
			}
		}
		return "redirect:/myfiles";
	}

}
