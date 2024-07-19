package com.eugeneprogram.tc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TcController {
	@GetMapping(value="selectTc.do")
	public List<Map<String, Object>> selectTc()	{
		List<Map<String, Object>> tcList = new ArrayList<>();		
		return tcList;
	}
}
