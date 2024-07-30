package com.eugeneprogram.st.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.st.dao.StMapper;

@Service
public class StService {
	@Autowired
	StMapper stMapper;
	
	public List<Map<String, Object>> getPageList() throws Exception{
		/*
		Map<String, Object> searchList = new HashMap<String, Object>();
		searchList.put("search", "");
		
		System.out.println(searchList);
		*/
		
		return stMapper.getPageList();
	}
}
