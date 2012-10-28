/**
 * 
 */
package com.ziksana.service.todo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.todos.MemberRole;
import com.ziksana.persistence.todos.MemberRoleMapper;
import com.ziksana.service.todo.MemberRoleService;

/**
 * @author
 * 
 */
public class MemberRoleServiceImpl implements MemberRoleService {

	@Autowired
	MemberRoleMapper memberRoleMapper;

	private static final Logger LOGGER = Logger
			.getLogger(MemberRoleServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberRoleService#selectById(int)
	 */
	public MemberRole getMemberRole(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :selectById(int id) : memberRoleDaoImpl.selectById(id):"
				+ memberRoleMapper.getMemberRole(id));
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return memberRoleMapper.getMemberRole(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberRoleService#update(com.vtg.model.MemberRole)
	 */
	public void updateMemberRole(final MemberRole memberrole) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :update(MemberRole memberrole)");
		try {
			memberRoleMapper.updateMemberRole(memberrole);
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(MemberRole memberrole) :memberRoleDaoImpl.update(memberrole);Exeption :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :update(MemberRole memberrole)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberRoleService#delete(int)
	 */
	public void deleteMemberRole(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int id)");
		try {
			memberRoleMapper.deleteMemberRole(id);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :delete(int id) :memberRoleDaoImpl.delete(id);"
					+ id);
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :delete(int id) :memberRoleDaoImpl.delete(id);Exeption :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :delete(int id)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberRoleService#insert(com.vtg.model.MemberRole)
	 */
	public void createMemberRole(final MemberRole memberrole) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :insert(MemberRole memberrole)");
		try {
			memberRoleMapper.createMemberRole(memberrole);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(MemberRole memberrole) :memberRoleDaoImpl.insert(memberrole);"
					+ memberrole);
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(MemberRole memberrole) :memberRoleDaoImpl.insert(memberrole);"
					+ memberrole + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :insert(MemberRole memberrole)");
	}

}
