/**
 * 
 */
package com.vtg.service.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtg.dao.impl.MemberRoleDaoImpl;
import com.vtg.model.MemberRole;
import com.vtg.service.MemberRoleService;

/**
 * @author
 * 
 */
public class MemberRoleServiceImpl implements MemberRoleService {

	@Autowired
	MemberRoleDaoImpl memberRoleDaoImpl;

	private static final Logger LOGGER = Logger
			.getLogger(MemberRoleServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberRoleService#selectAll()
	 */
	public Collection<MemberRole> selectAll() {
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");
		Collection<MemberRole> list = memberRoleDaoImpl.selectAll();
		LOGGER.info("Class :" + getClass()
				+ " : Method :selectAll() : memberRoleDaoImpl.selectAll():"
				+ list.isEmpty());
		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberRoleService#selectById(int)
	 */
	public MemberRole selectById(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :selectById(int id) : memberRoleDaoImpl.selectById(id):"
				+ memberRoleDaoImpl.selectById(id).getId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return memberRoleDaoImpl.selectById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberRoleService#update(com.vtg.model.MemberRole)
	 */
	public void update(final MemberRole memberrole) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :update(MemberRole memberrole)");
		try {
			memberRoleDaoImpl.update(memberrole);
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
	public void delete(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int id)");
		try {
			memberRoleDaoImpl.delete(id);
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
	public void insert(final MemberRole memberrole) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :insert(MemberRole memberrole)");
		try {
			memberRoleDaoImpl.insert(memberrole);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(MemberRole memberrole) :memberRoleDaoImpl.insert(memberrole);"
					+ memberrole.getId());
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(MemberRole memberrole) :memberRoleDaoImpl.insert(memberrole);"
					+ memberrole.getId() + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :insert(MemberRole memberrole)");
	}

}
