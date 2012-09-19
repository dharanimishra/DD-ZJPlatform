package com.ziksana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value="/home")
	public String home() {
		System.out.println("Home Controller...");
		return "dashboard";
	}
	
	@RequestMapping(value="/home2")
	public String home2() {
		System.out.println("Home 2 Controller...");
		return "dashboard-div";
	}
	
	@RequestMapping(value="/courses/list")
	public String getCoursesAvailable() {
		System.out.println("HomeController::getCoursesAvailable()...");
		return "courses/course-list";
	}
}
