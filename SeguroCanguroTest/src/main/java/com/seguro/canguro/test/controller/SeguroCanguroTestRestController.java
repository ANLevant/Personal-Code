package com.seguro.canguro.test.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seguro.canguro.test.service.impl.SeguroCanguroTestServiceImpl;

@RestController
@RequestMapping(path="/SeguroCanguro")
public class SeguroCanguroTestRestController {
	
	@Autowired
	private SeguroCanguroTestServiceImpl seguroService;

	@RequestMapping(path="/test", method=RequestMethod.GET)
	public List<HashMap<String, Object>> deliverTestData(){
		return seguroService.deliverTestData();
	}
	
}