/**
 * 
 */
package com.vtg.dao.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.vtg.dao.MemberRoleDao;
import com.vtg.mapper.MemberRoleMapper;
import com.vtg.model.MemberRole;

/**
 * @author
 * 
 */
public class MemberRoleDaoImpl implements MemberRoleDao {

	@Autowired
	MemberRoleMapper memberRoleMapper;

	private static final Logger LOGGER = Logger
			.getLogger(MemberRoleDaoImpl.class);

	public void setMemberRoleMapper(MemberRoleMapper memberRoleMapper) {
		this.memberRoleMapper = memberRoleMapper;
		LOGGER.info("Class :MemberRoleDaoImpl : Method :setMemberRoleMapper(MemberRoleMapper memberRoleMapper)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#selectAll()
	 */
	public Collection<MemberRole> selectAll() {
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");
		final Collection<MemberRole> list = memberRoleMapper.selectAll();
		LOGGER.debug("Class :" + getClass()
				+ " : Method :selectAll():list.isEmpty()" + list.isEmpty());
		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#selectById(int)
	 */
	public MemberRole selectById(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		final MemberRole list = memberRoleMapper.selectById(id);
		LOGGER.debug("Class :" + getClass()
				+ ": Method :selectById(int id):list.getRoleType()"
				+ list.getRoleType());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#update(com.vtg.model.MemberRole)
	 */
	public void update(final MemberRole memberrole) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :update(MemberRole memberrole)");
		try {
			memberRoleMapper.update(memberrole);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(MemberRole memberrole): Update Successfully");
		} catch (Exception e) {
			LOGGER.error("Class :"
					+ getClass()
					+ " : Method :update(MemberRole memberrole): Update UnSuccessfully: Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :update(MemberRole memberrole)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#delete(int)
	 */
	public void delete(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int id)");
		try {
			memberRoleMapper.delete(id);
			LOGGER.info("Class :" + getClass()
					+ " : Method :delete(int id): delete Successfully : Id :"
					+ id);
		} catch (Exception e) {
			LOGGER.info("Class :MemberRoleDaoImpl : Method :delete(int id): delete UnSuccessfully : Id :"
					+ id);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :delete(int id)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#insert(com.vtg.model.MemberRole)
	 */
	public void insert(final MemberRole memberrole) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :insert(MemberRole memberrole)");
		try {
			memberRoleMapper.insert(memberrole);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method :insert(MemberRole memberrole): Added Successfully : memberrole :"
					+ memberrole.getRoleType());
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ ": Method :insert(MemberRole memberrole): Added UnSuccessfully :Exception : "
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :insert(MemberRole memberrole)");

	}

}
