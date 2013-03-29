package com.ziksana.controller.blogs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.blogs.BlogService;

@Controller
@RequestMapping("/zblogs")
public class BlogController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BlogController.class);
	
	@Autowired
	private BlogService blogService;
	
	
	@RequestMapping(value="/getblogs")
	public ModelAndView getBlogList() {

		ModelAndView mview = new ModelAndView("blog/bloglist");
		try{
		mview.addObject("blogList", blogService.getBlogs());
		}
		catch(ZiksanaException ze){
			mview.addObject("errorResponse", ze.getMessage());
			logger.error(ze.getMessage(), ze);
		}
		return mview;
	}
	
	
	
}
