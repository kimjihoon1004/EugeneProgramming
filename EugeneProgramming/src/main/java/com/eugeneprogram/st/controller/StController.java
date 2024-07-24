package com.eugeneprogram.st.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eugeneprogram.st.service.StService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class StController {
	@Autowired
	StService stService;
	
	@GetMapping("/stRetrieve")
	public void goStRetrive(HttpServletResponse response) throws IOException{
		response.sendRedirect("/st/stRetrieve.html");
	}
	
	@GetMapping(value="stPage")
	public List<Map<String, Object>> getPageList(@RequestParam(name="search", required=false, defaultValue="") String search) throws Exception{
		return stService.getPageList(search);
	}
}
