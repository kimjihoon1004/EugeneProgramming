package com.eugeneprogram.tc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.tc.dao.TcMapper;

@Service
public class TcService {
	@Autowired
    TcMapper tcMapper;
	
	public int comparePw(String pw, String id) throws Exception  {
        return tcMapper.comparePw(pw, id);
    }
	
	public List<Map<String, Object>> getAllList() throws Exception  {
        return tcMapper.getAllList();
    }
}
