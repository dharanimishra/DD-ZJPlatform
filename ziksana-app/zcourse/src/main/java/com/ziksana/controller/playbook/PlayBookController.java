package com.ziksana.controller.playbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.NestTreeNode;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.course.AssociateContentService;
import com.ziksana.service.course.CourseNestTreeService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.PlannerService;
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
	
	@Value("#{myProperties['url']}")
	private String url;
    
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
	

	
	@Autowired
	private AssociateContentService associateContentService;

	@Autowired
	private PlannerService plannerService;
	
/*	private String courseIcon = "/ziksana-web/resources/images/tree_icons/course.png";
	private String chapterIcon = "/ziksana-web/resources/images/tree_icons/chapter.png";
	private String parentIcon = "/ziksana-web/resources/images/tree_icons/chapter.png";
	private String videoIcon = "/ziksana-web/resources/images/tree_icons/video.png";
	private String audioIcon = "/ziksana-web/resources/images/tree_icons/audio.png";
	private String folderClosed = "/ziksana-web/resources/images/tree_icons/folderClosed.gif";
	private String folderOpen = "/ziksana-web/resources/images/tree_icons/folderOpen.gif";
	private String pptIcon = "/ziksana-web/resources/images/tree_icons/powerpoint.png";
	private String docIcon = "/ziksana-web/resources/images/tree_icons/word.png";
	private String excelIcon = "/ziksana-web/resources/images/tree_icons/excel.png";
	private String pdfIcon = "/ziksana-web/resources/images/tree_icons/pdf.png";
	private String imageIcon = "/ziksana-web/resources/images/tree_icons/image.png";
	private String noteIcon = "/ziksana-web/resources/images/tree_icons/note.png";
	private String linkIcon = "/ziksana-web/resources/images/tree_icons/link.png";*/
	
	@RequestMapping(value = "/1/downloadPlayBook/{courseId}", method =RequestMethod.GET)
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
		  String userName = (String) RequestContextHolder.currentRequestAttributes().getAttribute("userName", RequestAttributes.SCOPE_SESSION);
		 System.out.println("downloading file name " + fileName);
		 String htmlViewURL ="http://localhost:8080/ziksana-web/zplaybook/unsecure/pdfviewHtml/"+courseId+"?userName="+userName;
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
	
	@RequestMapping(value = "/1/save/", method =RequestMethod.POST)
	public ModelAndView save(){
		ModelAndView mv = new  ModelAndView("redirect:home");
		 return mv;	
	}
	
	@RequestMapping(value = "/1/htmlView/{courseId}", method =RequestMethod.GET)
	public ModelAndView htmlView(@PathVariable Integer courseId, HttpServletResponse response ){
		ModelAndView modelView = new  ModelAndView("playbook-viewHtml");
		System.out.println("mediaserver url " + url);
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
		List<NestTreeNode> treeNodeList = new ArrayList<NestTreeNode>();
		
	    	
		//Get Tree Datas
		try {
			
			 treeNodeList = courseNestTreeService
						.getModuleComponents(courseId);
		} catch (ZiksanaException exception) {
			//Logger.error(exception.getMessage(), exception);
		}
		
			modelView.addObject("parentList", treeNodeList);
			modelView.addObject("courseIds", courseId);
			modelView.addObject("course", course);
			modelView.addObject("courseDuration", course.getDuration());

		System.out.println("##############current loggedin user" + userName);
		
	//End
		
		modelView.addObject("member",member);
		modelView.addObject("course",course);
		modelView.addObject("mediaserver",url);
		modelView.addObject("treeNodeList",treeNodeList);
		System.out.println("mediaserver url " + url);
		 return modelView;
	}
    
	@RequestMapping(value = "/unsecure/extraPDFHtml/{courseId}", method =RequestMethod.GET)
	public ModelAndView extraPDFHtml(@PathVariable Integer courseId, HttpSession session){
		ModelAndView modelView = new  ModelAndView("playbook-extrapdfviewHtml");

		System.out.println("adfpdding view............. ");
		Integer pgNumber= (Integer) session.getAttribute("pgNumber");
		//Integer pgNumber= (Integer) RequestContextHolder.currentRequestAttributes().getAttribute("pgNumber", RequestAttributes.SCOPE_SESSION);
		if(pgNumber==null){
		  pgNumber = 0;	
		}
		pgNumber = pgNumber+1;
		//RequestContextHolder.currentRequestAttributes().setAttribute("pgNumber", RequestAttributes.SCOPE_SESSION,pgNumber);
		session.setAttribute("pgNumber",pgNumber);
		modelView.addObject("pgNumber", pgNumber);
		return modelView;
	}
	
	@RequestMapping(value = "/unsecure/pdfviewHtml/{courseId}", method =RequestMethod.GET)
	public ModelAndView pdfviewHtml(@PathVariable Integer courseId,@RequestParam String userName){
		//String userName = (String) RequestContextHolder.currentRequestAttributes().getAttribute("userName", RequestAttributes.SCOPE_SESSION);
		

		
		ModelAndView modelView = new  ModelAndView("playbook-pdfviewHtml");
		Member member = memberService.getMemberByUser(userName);
		Course course = courseService.getCourseByCourseId(courseId);
		System.out.println("##############current loggedin user" + userName);
		
		List<NestTreeNode> treeNodeList = new ArrayList<NestTreeNode>();
		
		
		//Get Tree Datas
		try {

		
			 treeNodeList = courseNestTreeService
						.getModuleComponents(courseId);			
		} catch (ZiksanaException exception) {
			//Logger.error(exception.getMessage(), exception);
		}
		
			modelView.addObject("parentList", treeNodeList);
			modelView.addObject("courseIds", courseId);
			modelView.addObject("course", course);
			modelView.addObject("courseDuration", course.getDuration());

	  
		modelView.addObject("member",member);
		modelView.addObject("course",course);
		modelView.addObject("treeNodeList",treeNodeList);
		modelView.addObject("mediaserver",url);
		
		 return modelView;
	}
	
	public Map<String, String> getPDFInfo(List<NestTreeNode> nodeList,Course course)
	{
        int numberOfPages=1;//dfault is one page... Now calculate the number of pages and insert footer at the end of page..
        int coursModuleOnPage=1;
        int plannerOnPage=1;
    	Map<String, String>  pdfInfo = new HashMap<String, String>();
	    int contentLength = 0; 
    	if(course.getDescription() !=null)
    		contentLength = course.getDescription().length();
    	
    	if(contentLength>5000){
    		coursModuleOnPage = 2;
    	    numberOfPages =2;
    	    pdfInfo.put("coursDescriptionFooter", "YES");
    	}
    	//contentLength =0;
	    int countNode =0;
	    System.out.println("content lenght nodelist size... " + nodeList.size());
		for (NestTreeNode node : nodeList) {
			countNode++;
			
			if(node.getTitle()!=null)
			  contentLength =contentLength + node.getTitle().length();
			
            if(node.getNodeDescription()!=null)	
            	contentLength = contentLength+ node.getNodeDescription().length();
            
            System.out.println("nodeDescription "  + node.getNodeDescription());
            System.out.println("content lenght " + contentLength+ "  " + countNode);
            if(contentLength>2500 || countNode>3){
				numberOfPages++;
				countNode=0;
			 }
            /*if(countNode>3){
            	numberOfPages++;
            	countNode=0;
            	pdfInfo.put("coursModuleFooterId",""+node.getId());
            }*/
		}
		 System.out.println("content lenght " + contentLength+ "  " + countNode);
		plannerOnPage=numberOfPages;
		pdfInfo.put("plannerOnPage", ""+plannerOnPage);
		pdfInfo.put("coursModuleOnPage", ""+coursModuleOnPage);
		return pdfInfo;
	}
}
