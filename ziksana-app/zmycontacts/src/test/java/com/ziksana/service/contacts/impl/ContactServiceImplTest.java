package com.ziksana.service.contacts.impl;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.contacts.ContactService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ContactServiceImplTest {

	@Autowired
	private ContactService contactService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllContacts() {
           List<MemberPersona>  memberPersonas = contactService.getAllContacts();
           Assert.assertTrue(memberPersonas.size() == 3);
           
           
           
	}

	@Test
	public void testGetContacts() {
		fail("Not yet implemented");
	}

}
