package com.eugeneprogram.st.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface StMapper {
	public List<Map<String, Object>> getPage(Map<String, Object>searchList);
}
