package com.ziksana.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.sample.Blog;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.blogs.BlogService;
import com.ziksana.service.sample.SampleService;

@Controller
public class HomeController {
	
	
	@Autowired
	SampleService sampleService;
	
	@Autowired
	BlogService blogService;
	
	

	@RequestMapping(value="/home")
	public String home() {
		System.out.println("Entering Home Controller...");
		return "dashboard";
	}
	
	@RequestMapping(value="/home2")
	public ModelAndView home2() {
		System.out.println("Entering Home 2 Controller...");
		ModelAndView mview = new ModelAndView("dashboard-div");
		
		mview.addObject("firstname", "Chris");
		mview.addObject("lastname", "Anderson");
		mview.addObject("title", "Associate Professor");
		mview.addObject("memberId", "A1b2c3d4E5F6");
		
		Map<String, String> blogPost1 = new HashMap<String, String>();
		blogPost1.put("subject", "The Innovative Educator");
		blogPost1.put("detail", "As many of you already know �");
		blogPost1.put("date", "10th Aug");
		blogPost1.put("tags", "Educational Technology, Research");
		
		Map<String, String> blogPost2 = new HashMap<String, String>();
		blogPost2.put("subject", "Storytelling for New Media");
		blogPost2.put("detail", "Education can be redefined �.");
		blogPost2.put("date", "15th Aug");
		blogPost2.put("tags", " Game Design, Research ... ");
		
		mview.addObject("blogPost1", blogPost1);
		mview.addObject("blogPost2", blogPost2);
		
		return mview;
	}
	
	@RequestMapping(value="/courses/list")
	public String getCoursesAvailable() {
		System.out.println("HomeController::getCoursesAvailable()...");
		return "courses/course-list";
	}
	
	
	@RequestMapping(value="/blog/list")
	public ModelAndView getBlogList() {
		
		System.out.println("HomeController::getBlogList()...");
		
		
		
		ModelAndView mview = new ModelAndView("blog/bloglist");
		
				
		
		mview.addObject("blogList", blogService.getBlogs());
		return mview;
	}
	
	
	
}
