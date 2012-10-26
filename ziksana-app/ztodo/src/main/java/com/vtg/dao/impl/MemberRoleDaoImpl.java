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

	private static final Logger logger = Logger
			.getLogger(MemberRoleDaoImpl.class);

	public void setMemberRoleMapper(MemberRoleMapper memberRoleMapper) {
		this.memberRoleMapper = memberRoleMapper;
		logger.info("Class :MemberRoleDaoImpl : Method :setMemberRoleMapper(MemberRoleMapper memberRoleMapper)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#selectAll()
	 */
	public Collection<MemberRole> selectAll() {
		logger.info("Class :" + getClass() + " : Entering Method :selectAll()");
		Collection<MemberRole> list = memberRoleMapper.selectAll();
		logger.debug("Class :" + getClass()
				+ " : Method :selectAll():list.isEmpty()" + list.isEmpty());
		logger.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#selectById(int)
	 */
	public MemberRole selectById(int id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		MemberRole list = memberRoleMapper.selectById(id);
		logger.debug("Class :" + getClass()
				+ ": Method :selectById(int id):list.getRoleType()"
				+ list.getRoleType());
		logger.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#update(com.vtg.model.MemberRole)
	 */
	public void update(MemberRole memberrole) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :update(MemberRole memberrole)");
		try {
			memberRoleMapper.update(memberrole);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :update(MemberRole memberrole): Update Successfully");
		} catch (Exception e) {
			logger.error("Class :"
					+ getClass()
					+ " : Method :update(MemberRole memberrole): Update UnSuccessfully: Exception :"
					+ e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :update(MemberRole memberrole)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#delete(int)
	 */
	public void delete(int id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :delete(int id)");
		try {
			memberRoleMapper.delete(id);
			logger.info("Class :" + getClass()
					+ " : Method :delete(int id): delete Successfully : Id :"
					+ id);
		} catch (Exception e) {
			logger.info("Class :MemberRoleDaoImpl : Method :delete(int id): delete UnSuccessfully : Id :"
					+ id);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :delete(int id)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberRoleDao#insert(com.vtg.model.MemberRole)
	 */
	public void insert(MemberRole memberrole) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :insert(MemberRole memberrole)");
		try {
			memberRoleMapper.insert(memberrole);
			logger.info("Class :"
					+ getClass()
					+ " : Method :insert(MemberRole memberrole): Added Successfully : memberrole :"
					+ memberrole.getRoleType());
		} catch (Exception e) {
			logger.info("Class :"
					+ getClass()
					+ ": Method :insert(MemberRole memberrole): Added UnSuccessfully :Exception : "
					+ e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :insert(MemberRole memberrole)");

	}

}
