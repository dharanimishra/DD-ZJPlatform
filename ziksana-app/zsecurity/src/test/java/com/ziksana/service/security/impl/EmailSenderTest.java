package com.ziksana.service.security.impl;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.ziksana.domain.member.Member;
import com.ziksana.security.velocitymail.ZiksanaEmailSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/ziksanaMailContext.xml"})
public class EmailSenderTest {

    @Autowired
    private ZiksanaEmailSender emailSender;
    @Autowired
    private VelocityEngine velocityEngine;

    @Test
    public void testSendEmail() throws Exception {
    	  String body="";
           body+="Hello User,<br/>";
           body+= VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "mailtemplate/reminder.vm", "UTF-8", null);
           Member member = new Member();
           member.setPrimaryEmailId("selvan.kumar@vtgindia.com");
        emailSender.sendEmailText1( member);
    }

  } 
