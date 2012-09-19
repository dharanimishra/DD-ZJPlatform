package com.ziksana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@RequestMapping(value="/one")
	public String test() {
		System.out.println("TestController.test()....");
		return "test";
	}
}

