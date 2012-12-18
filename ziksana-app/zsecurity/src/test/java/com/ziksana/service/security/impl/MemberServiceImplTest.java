/**
 * 
 */
package com.ziksana.service.security.impl;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.service.security.MemberService;

/**
 * @author prabu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MemberServiceImplTest {

	@Autowired
	MemberService memberService;
	
	
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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ziksana.service.security.impl.MemberServiceImpl#getMemberByUser(java.lang.String)}.
	 */
	@Test
	public void testGetMemberByUser() {
		Member member = memberService.getMemberByUser("prabu");
		
		List<MemberPersona> memberPersonas = member.getMemberPersonas();
		MemberRoleType role = null;
		
		//TODO
		for (MemberPersona memberPersona: memberPersonas)
		{
			if (memberPersona.getRoleType() == MemberRoleType.EDUCATOR)
			{
				role = memberPersona.getRoleType();
			}
			
		}
		
		
		//System.out.println(" Role type is "+member.)
		assertTrue( member.getMemberPersonas().size() == 4);
		assertTrue(role!=null);

	}
	@Test
	public void testGetMemberByMemberId() {
		Member member = memberService.getMemberByMemberId(1000);
		
		List<MemberPersona> memberPersonas = member.getMemberPersonas();
		MemberRoleType role = null;
		
		
		for (MemberPersona memberPersona: memberPersonas)
		{
			if (memberPersona.getRoleType() == MemberRoleType.EDUCATOR)
			{
				role = memberPersona.getRoleType();
			}
			
		}
		
		
		//System.out.println(" Role type is "+member.)
		assertTrue( member.getMemberPersonas().size() == 4);
		assertTrue(role!=null);

	}
}
