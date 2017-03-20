package com.seguro.canguro.test.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguro.canguro.test.mapper.SeguroCanguroTestMapper;
import com.seguro.canguro.test.service.facade.SeguroCanguroTestService;

@Service
public class SeguroCanguroTestServiceImpl implements SeguroCanguroTestService{

	@Autowired
	private SeguroCanguroTestMapper seguroCanguroTestMapper;
	
	@Override
	public List<HashMap<String, Object>> deliverTestData() {
		return seguroCanguroTestMapper.findAllTestData();
	}

}
