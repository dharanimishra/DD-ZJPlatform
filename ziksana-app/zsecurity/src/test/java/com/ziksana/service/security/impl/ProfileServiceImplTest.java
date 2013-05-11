/**
 * 
 */
package com.ziksana.service.security.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.member.MemberProfile;
import com.ziksana.service.security.ProfileService;

/**
 * @author vtg-p13
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProfileServiceImplTest {
	
	@Autowired
	ProfileService profileService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
	}

	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Ignore
	public void testUpdateProfile(){
		String firstSecurityQuestionId = "1SQ1001";
		String secondSecurityQuestionId = "2SQ1001";
		String firstSecurityAnswer = "amma";
		String secondSecurityAnswer = "software";
		MemberProfile profile = new MemberProfile();
		profile.setSecurityQuestionId(firstSecurityQuestionId);
		profile.setMemberAnswer(firstSecurityAnswer);
		profile.setMemberId(1001);
		int response = profileService.updateMemberProfile(profile);
		if(response == 1){
			profile = new MemberProfile();
			profile.setSecurityQuestionId(secondSecurityQuestionId);
			profile.setMemberAnswer(secondSecurityAnswer);
			profile.setMemberId(1001);
			profileService.updateMemberProfile(profile);
		}

		
	}
	
	@Test
	public void testGetAllMemberProfile(){

		List<MemberProfile> profile = profileService.getMemberProfileList(1001);

			Assert.assertEquals(2, profile.size());

		}
	@Test
	public void testGetMemberProfile(){
		MemberProfile profile = profileService.getMemberProfile("ravip","1SQ%");
		Assert.assertEquals("What is your mother's maiden name?", profile.getSecurityQuestionText());
	}
	
	@Test
	public void isProfileUpdated(){
		int response = 0;
		
		response = profileService.isProfileCompleted("ravip");
		
		Assert.assertEquals(1, response);
	}
	
	
}
