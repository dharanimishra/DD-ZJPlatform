package com.vtg.memberrole.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.todos.MemberRole;
import com.ziksana.service.todo.MemberRoleService;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberRoleTestCase {

	@Autowired
	MemberRoleService memberRoleService;

	@BeforeClass
	public static void runBeforeClass() {

	}

	@AfterClass
	public static void runAfterClass() {

	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryMapper#insert(com.vtg.model.CategoryMapper)}.
	 */
	@Test
	public void testInsert() {

		MemberRole actual = new MemberRole(1, 1, new Date(), new Date(), 1, 1,
				"thumbnailPicturePath");
		memberRoleService.createMemberRole(actual);

		assertEquals(1, actual.getId());
		MemberRole expected = memberRoleService.getMemberRole(actual.getId());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryMapper#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		// List<MemberRoleMapper> list = (List<MemberRoleMapper>) memberRoleDAO
		// .selectAll();
		// assertNotNull(list);
		// assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryMapper#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		MemberRole actual = new MemberRole(1, 1, new Date(), new Date(), 1, 1,
				"thumbnailPicturePath");
		actual.setId(1);
		MemberRole expected = memberRoleService.getMemberRole(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryMapper#update(com.vtg.model.CategoryMapper)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		MemberRole actual = new MemberRole(1, 1, new Date(), new Date(), 1, 1,
				"thumbnailPicturePath");

		MemberRole expected = memberRoleService.getMemberRole(actual.getId());
		expected.setActive(1);
		memberRoleService.updateMemberRole(expected);
		expected = memberRoleService.getMemberRole(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryMapper#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		memberRoleService.deleteMemberRole(1);
		MemberRole expected = memberRoleService.getMemberRole(1);
		assertNull(expected);
	}

}
