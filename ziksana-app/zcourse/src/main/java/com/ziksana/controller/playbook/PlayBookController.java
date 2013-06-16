package com.ziksana.controller.playbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.NestTreeNode;
import com.ziksana.domain.member.Member;
import com.ziksana.service.course.CourseNestTreeService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.security.AuthenticationService;
import com.ziksana.service.security.MediaService;
import com.ziksana.service.security.MemberService;
import com.ziksana.service.security.ProfileService;
import com.ziksana.util.PdfUtil;

@Controller
@RequestMapping("/zplaybook")
public class PlayBookController {
    @Autowired
    ServletContext context;
	
    @Autowired
	private CourseService courseService;
	
	@Autowired
	private AuthenticationService authService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private MediaService mediaService;

	@Autowired
	private ProfileService profileService;
    
	@Autowired
	CourseNestTreeService courseNestTreeService;
	
	@RequestMapping(value = "/unsecure/downloadPlayBook/{courseId}", method =RequestMethod.GET)
	public void downloadPlayBook(@PathVariable Integer courseId, HttpServletResponse response ){
		 System.out.println("this is path variable..  "+ courseId);
		 String resourcePath = context.getRealPath("/static/playbook");
		 System.out.println("resourcePath " + resourcePath);
		 Course course = courseService.getCourseByCourseId(courseId);
		 String fileName = "pdffile"; 
		   if(course.getName()!=null){
		    fileName = course.getName().replaceAll(" ", "");
		   }
		  fileName = fileName+".pdf";
		 System.out.println("downloading file name " + fileName);
		 String htmlViewURL ="http://localhost:8080/ziksana-web/zplaybook/unsecure/pdfviewHtml/"+courseId;
		 System.out.println("htmlViewURL " + htmlViewURL);
		 File file = new File(resourcePath+"/" +courseId);
		 if(!file.exists()){
			file.mkdirs();
			//PdfUtil pdfUtil = new PdfUtil();
			//pdfUtil.generatePlayBook(htmlViewURL,file.getAbsolutePath()+"/"+fileName);
		 }
			PdfUtil pdfUtil = new PdfUtil();
			pdfUtil.generatePlayBook(htmlViewURL,file.getAbsolutePath()+"/"+fileName);
		 response.setContentType("application/pdf");
		 response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		 System.out.println("context..." + context.getRealPath("/static/playbook/"));
		 //logic to implement if playbook generated...

		 try {
			 
			// InputStream is = context.getResourceAsStream("/static/playbook/compressed.tracemonkey-pldi-09.pdf");
			 InputStream is = context.getResourceAsStream("/static/playbook/"+courseId+"/"+fileName);
			 OutputStream os = response.getOutputStream();
			int read=0;
			byte[] bytes = new byte[1024];
			while((read = is.read(bytes))!= -1){
				os.write(bytes, 0, read);
			}
			//os.write(download.getBytes());
			os.flush();
			os.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/unsecure/create/", method =RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView mv = new  ModelAndView("create-playbook");
		 return mv;	
	}
	
	@RequestMapping(value = "/unsecure/save/", method =RequestMethod.POST)
	public ModelAndView save(){
		ModelAndView mv = new  ModelAndView("redirect:home");
		 return mv;	
	}
	@RequestMapping(value = "/unsecure/htmlView/{courseId}", method =RequestMethod.GET)
	public ModelAndView htmlView(@PathVariable Integer courseId, HttpServletResponse response ){
		System.out.println("##############3playbook controller courseId" + courseId);
		Course course = courseService.getCourseByCourseId(courseId);
		System.out.println("##############course description" + course.getDescription());
		System.out.println("##############course created by" + course.getCreatedBy());
		System.out.println("##############course course name" + course.getName());
		System.out.println("##############course course total credit" + course.getTotalCredits());
		String userName = (String) RequestContextHolder.currentRequestAttributes().getAttribute("userName", RequestAttributes.SCOPE_SESSION);
		Member member = memberService.getMemberByUser(userName);
		//CourseLearningComponent clc =
		//courseService.getCourseComponents(courseId)
		List<NestTreeNode> nodeList = courseNestTreeService
				.getCourseComponent(courseId);
		
		System.out.println("##############current loggedin user" + userName);
		ModelAndView mv = new  ModelAndView("playbook-viewHtml");
		mv.addObject("member",member);
		mv.addObject("course",course);
		 return mv;
	}

	@RequestMapping(value = "/unsecure/pdfviewHtml/{courseId}", method =RequestMethod.GET)
	public ModelAndView pdfviewHtml(@PathVariable Integer courseId){
		String userName = (String) RequestContextHolder.currentRequestAttributes().getAttribute("userName", RequestAttributes.SCOPE_SESSION);
		Member member = memberService.getMemberByUser(userName);
		Course course = courseService.getCourseByCourseId(courseId);
		System.out.println("##############current loggedin user" + userName);
		ModelAndView mv = new  ModelAndView("playbook-pdfviewHtml");
		mv.addObject("member",member);
		mv.addObject("course",course);
		
		 return mv;
	}
	
}
