package com.eugeneprogram.tc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

import com.eugeneprogram.tc.service.TcService;

@RestController
public class TcController {
	@Autowired
    TcService tcService;
	
	@GetMapping(value="selectTC.do")
	public List<Map<String, Object>> getTc() throws Exception	{
		return tcService.getAllList();
	}
	
	@GetMapping("/testPage")
    public void getTestPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/tc/test.html");
    }
}
