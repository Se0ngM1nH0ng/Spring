package com.spring.view.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(value="/test02.do", method=RequestMethod.POST)
	@ResponseBody
	public String test02(@RequestParam Map<String,Object> map) {
		System.out.println("count : "+map.get("count"));
		System.out.println("apple : "+map.get("apple"));
		System.out.println("banana : "+map.get("banana"));
		Integer count=(Integer)map.get("count");
		count++;
		return count.toString();
	}
	
	@RequestMapping(value="/test.do", method=RequestMethod.POST)
	@ResponseBody
	public String test(@RequestParam("count")int count, @RequestParam("apple")int apple, @RequestParam("banana")String banana) {
		System.out.println("count : "+count);
		System.out.println("apple : "+apple);
		System.out.println("banana : "+banana);
		count++;
		return String.valueOf(count);
	}
	
}
