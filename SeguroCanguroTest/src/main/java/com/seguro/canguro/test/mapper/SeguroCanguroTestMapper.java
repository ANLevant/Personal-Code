package com.seguro.canguro.test.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SeguroCanguroTestMapper {

	@Select("SELECT * FROM Sample_Data ORDER BY sample_data_title DESC")
	public List<HashMap<String, Object>> findAllTestData();
	
}
