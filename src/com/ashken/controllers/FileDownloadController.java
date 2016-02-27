package com.ashken.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashken.entities.SiteUser;
import com.ashken.entities.UserFile;
import com.ashken.jpaRepositories.UserFileRepository;
import com.ashken.jpaRepositories.UserRepository;

@Controller
public class FileDownloadController {
	
String rootFolder = "D:/userFiles";
	
	@Autowired
	UserRepository userepo;
	
	@Autowired
	UserFileRepository filesRepo;
	
	@RequestMapping("/download/{ID}")
	public void getFileDownload(@PathVariable("ID") int id, HttpServletRequest request, HttpServletResponse response,Principal p) throws IOException
	{
		UserFile file = filesRepo.findById(id);
		
		SiteUser user = userepo.findByUsername(p.getName());
		if(file.isVisible() || user.getId() == file.getOwner().getId())
		{
		    String path = rootFolder + "/"+user.getId()+"/"+file.getName();
			File f = new File(path);
			FileInputStream input = new FileInputStream(f);
			String mimetype = request.getServletContext().getMimeType(path);
			
			
			if(mimetype == null) mimetype = "application/octet-stream";
			
			response.setContentType(mimetype);
			response.setContentLengthLong(f.length());
			response.setHeader("Content-Disposition", "attachment; filename="+ file.getName());
			
			try
			{
				FileCopyUtils.copy(input, response.getOutputStream());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			input.close();
	
		}
		//return "redirect:/myfiles";
	}

}
