package com.vtg.memberrole.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtg.dao.MemberRoleDao;
import com.vtg.dao.impl.MemberRoleDaoImpl;
import com.vtg.model.MemberRole;

/**
 * Test Case
 * 
 * @author
 */

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberRoleTestCase {

	private static MemberRoleDao memberRoleDAO;

	@BeforeClass
	public static void runBeforeClass() {
		memberRoleDAO = new MemberRoleDaoImpl();
	}

	@AfterClass
	public static void runAfterClass() {
		memberRoleDAO = null;
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryDao#insert(com.vtg.model.Category)}.
	 */
	@Test
	public void testInsert() {

		MemberRole actual = new MemberRole();
		memberRoleDAO.insert(actual);

		assertEquals(1, actual.getId());
		MemberRole expected = memberRoleDAO.selectById(actual.getId());
		assertEquals(actual, expected);
		assertNotSame(actual, expected);

	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		List<MemberRole> list = (List<MemberRole>) memberRoleDAO.selectAll();
		assertNotNull(list);
		assertEquals(1, 1);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#selectById(int)}.
	 */
	@Test
	public void testSelectById() {
		MemberRole actual = new MemberRole();
		MemberRole expected = memberRoleDAO.selectById(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for
	 * {@link com.vtg.dao.CategoryDao#update(com.vtg.model.Category)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		MemberRole actual = new MemberRole();

		MemberRole expected = memberRoleDAO.selectById(actual.getId());
		expected.setActive(1);
		memberRoleDAO.update(expected);
		expected = memberRoleDAO.selectById(actual.getId());

		assertNotNull(expected);
		assertEquals(actual, expected);
		assertNotSame(actual, expected);
	}

	/**
	 * Test method for {@link com.vtg.dao.CategoryDao#delete(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		memberRoleDAO.delete(1);
		MemberRole expected = memberRoleDAO.selectById(1);
		assertNull(expected);
	}

}
