package com.eugeneprogram.st.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eugeneprogram.st.service.StService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class StController {
	@Autowired
	StService stService;
	
	@GetMapping(value="stPage.do")
	public List<Map<String, Object>> getPageList() throws Exception{
		System.out.println("thsi is stPage");
		return stService.getPageList();
	}
	
	@GetMapping("/st/stList")
	public void goStRetrive(HttpServletResponse response) throws IOException{
		response.sendRedirect("/st/stRetrieve.html");
	}
	
	@PostMapping(value="stAdd.do")
	public void addStudent(@RequestParam("name") String name,
						   @RequestParam("school") String school) throws Exception{
		
	}
	
	@GetMapping("/st/stForm")
	public void goStForm(HttpServletResponse response) throws IOException{
		response.sendRedirect("/st/stForm.html");
	}
}
