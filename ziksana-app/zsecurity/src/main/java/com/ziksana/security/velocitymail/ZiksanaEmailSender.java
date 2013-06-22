/**
 * 
 */
package com.ziksana.security.velocitymail;


import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.ziksana.domain.member.Member;

@Component
public class ZiksanaEmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;


    public void sendEmailText1(final Member member) {
    	 MimeMessagePreparator preparator = new MimeMessagePreparator() {
             public void prepare(MimeMessage mimeMessage) throws Exception {
                 MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
                 message.setTo(member.getPrimaryEmailId());
                 //message.setFrom(new InternetAddress(fromEmailAddress));
                 message.setSubject("Ziksana User Id"); 
                 String imagePath="http://app.dev.ziksana.com:8080/ziksana-web/resources/images/home/loginlogo.png";
 			 	Map model = new HashMap();
 				model.put("member", member);
 				model.put("path", imagePath);
 				String body;
 				body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "mailtemplate/reminder.vm", "UTF-8", model);
                 message.setText(body, true);
                 
             }
             
         };
         boolean alreadyExecuted = false;
			if(!alreadyExecuted) {
         mailSender.send(preparator);
         alreadyExecuted = true;
		}
	}
    
    public void sendEmailPasswordChanged(final Member member) {
   	 MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
                message.setTo(member.getPrimaryEmailId());
                //message.setFrom(new InternetAddress(fromEmailAddress));
                message.setSubject("Ziksana User Id"); 
                String imagePath="http://app.dev.ziksana.com:8080/ziksana-web/resources/images/home/loginlogo.png";
			 	Map model = new HashMap();
				model.put("member", member);
				model.put("path", imagePath);
				String body;
				body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "mailtemplate/passwordReminder.vm", "UTF-8", model);
                message.setText(body, true);
                
            }
            
        };
        boolean alreadyExecuted = false;
			if(!alreadyExecuted) {
        mailSender.send(preparator);
        alreadyExecuted = true;
		}
	}
    
    public void sendEmailText(final String toEmailAddresses,
                          final String subject,String body) {
        sendEmail(toEmailAddresses, subject, null, null,body);
    }

    public void sendEmailWithAttachment(final String toEmailAddresses, final String fromEmailAddress,
                                        final String subject, final String attachmentPath,
                                        final String attachmentName) {
        sendEmail(toEmailAddresses, subject, attachmentPath, attachmentName,null);
    }

    private void sendEmail(final String toEmailAddresses,
                           final String subject, final String attachmentPath,
                           final String attachmentName,final String body) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
                message.setTo(toEmailAddresses);
                
                message.setSubject(subject); 
              
                message.setText(body, true);
                if (!StringUtils.isBlank(attachmentPath)) {
                    FileSystemResource file = new FileSystemResource(attachmentPath);
                    message.addAttachment(attachmentName, file);
                }
            }
        };
        this.mailSender.send(preparator);
    }

	
}

