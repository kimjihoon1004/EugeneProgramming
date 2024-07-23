package com.eugeneprogram.tc.dao;

import java.util.List;
import java.util.Map;


public interface TcMapper {
	public int comparePw(String pw, String id) throws Exception;
	public List<Map<String, Object>> getAllList() throws Exception;
}
