package com.ziksana.controller.playbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.util.PdfUtil;

@Controller
@RequestMapping("/zplaybook")
public class PlayBookController {
    @Autowired
    ServletContext context;
    
	@RequestMapping(value = "/unsecure/downloadPlayBook/{playbookId}", method =RequestMethod.GET)
	public void downloadPlayBook(@PathVariable String playbookId, HttpServletResponse response ){
		 System.out.println("this is path variable..  "+ playbookId);
		 String resourcePath = context.getRealPath("/static/playbook");
		 String fileName = "test.pdf";
		 String htmlViewURL ="http://localhost:8080/ziksana-web/zplaybook/unsecure/htmlView/"+playbookId;
		 File file = new File(resourcePath+"/" +playbookId);
		 if(!file.exists()){
			file.mkdirs();
			PdfUtil pdfUtil = new PdfUtil();
			pdfUtil.generatePlayBook(htmlViewURL,file.getAbsolutePath()+"/"+fileName);
		 }
		 response.setContentType("application/pdf");
		 response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		 System.out.println("context..." + context.getRealPath("/static/playbook/"));
		 //logic to implement if playbook generated...

		 try {
			 
			// InputStream is = context.getResourceAsStream("/static/playbook/compressed.tracemonkey-pldi-09.pdf");
			 InputStream is = context.getResourceAsStream("/static/playbook/"+playbookId+"/"+fileName);
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
	
	@RequestMapping(value = "/unsecure/htmlView/{playbookId}", method =RequestMethod.GET)
	public ModelAndView htmlView(@PathVariable String playbookId, HttpServletResponse response ){
		ModelAndView mv = new  ModelAndView("playbook-viewHtml");
		 return mv;
	}
}
