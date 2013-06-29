package com.ziksana.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class PdfUtil {
	public static void main(String[] args){
		PdfUtil pdfUtil = new PdfUtil();
		pdfUtil.generatePlayBook("12312","ibnlive...");
		
	}
	public void generatePlayBook(String idStr, String outputfile){
/*	ProcessBuilder pb = new ProcessBuilder("wkhtmltopdf", "sourcURL", "outputfile");
	Map<String, String> env = pb.environment();
	env.put("sourcURL", "http://ibnlive.com");
	env.put("outputfile", "ibn.pdf");
	pb.directory(new File("D:/dev"));*/
	 try {
		 Runtime rt = Runtime.getRuntime();
		 Process p = rt.exec("wkhtmltopdf --margin-bottom 63mm --footer-html http://localhost:8080/ziksana-web/zplaybook/unsecure/extraPDFHtml/472 " +idStr+" " + outputfile);
		//Process p = pb.start();
		processLog(p.getErrorStream());
		processLog(p.getErrorStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	private void processLog(InputStream ins) throws IOException{
		BufferedReader bff = new BufferedReader(new InputStreamReader(ins));
		String s = null;
		while( (s=bff.readLine())!=null){
			System.out.println(s);
		}
	}
	
	
  	
} 
