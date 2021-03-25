package com.markany.influxdbsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.markany.influxdbsample.dto.H2oFeet;
import com.markany.influxdbsample.service.MainService;

@Controller
@RequestMapping(path="/")
public class MainController {

	@Autowired
	private MainService mainService;

//	@GetMapping(path="/h2os")
//	public @ResponseBody List<H2oFeet> h2o_list() {
//
//		return mainService.h2o_list();
//	}
	
	@RequestMapping("/main")
	public List<H2oFeet> h2o_list(@PathVariable("list")String list){
		System.out.println("Main Controller!");
		 List<H2oFeet> rs=mainService.h2o_list();
		 return rs;
	}
}
