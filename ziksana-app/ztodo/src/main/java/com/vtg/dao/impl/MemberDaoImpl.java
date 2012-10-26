/**
 * 
 */
package com.vtg.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.vtg.dao.MemberDao;
import com.vtg.mapper.MemberMapper;
import com.vtg.model.MemberPersona;

/**
 * @author
 * 
 */
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private MemberMapper memberMapper;

	private static final Logger logger = Logger.getLogger(MemberDaoImpl.class);

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
		logger.info("Class :MemberDaoImpl : Method :setMemberMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#getNumberOfUsers()
	 */
	public int getNumberOfMembers() {
		logger.info("Class :" + getClass()
				+ " : Entering Method :getNumberOfMembers()");
		List<MemberPersona> list = memberMapper.selectAll();
		logger.info("Class :MemberDaoImpl : Method :getNumberOfMembers():"
				+ list.size());
		logger.info("Class :" + getClass()
				+ " : Leaving Method :getNumberOfMembers()");
		return list.size();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#findUser(java.lang.String)
	 */
	public MemberPersona findMember(int id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :findMember(int id)");
		MemberPersona list = memberMapper.selectById(id);
		logger.info("Class :MemberDaoImpl : Method :findMember(int id):" + id
				+ "List:" + list);
		logger.info("Class :" + getClass()
				+ " : Leaving Method :findMember(int id)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#updateUser(com.vtg.model.Member)
	 */
	public void updateMember(MemberPersona member) {
		logger.info("Class :" + getClass()
				+ " : Entering Method : updateMember(MemberPersona member)");
		try {
			memberMapper.update(member);
			logger.debug("Class :MemberDaoImpl : Method :updateMember(MemberPersona member) Successfully");
		} catch (Exception e) {
			logger.error("Class :"
					+ getClass()
					+ " : Method :updateMember(MemberPersona member) Updated UnSuccessfully: Exception:"
					+ e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :updateMember(MemberPersona member)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#enableUser(java.lang.String)
	 */
	public void enableMember(int id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method : enableMember(int id)");
		memberMapper.enableMember(id);
		logger.info("Class :MemberDaoImpl : Method :enableMember(int id) : enableMember Successfully:Id "
				+ id);
		logger.info("Class :" + getClass()
				+ " : Leaving Method : enableMember(int id)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#disableUser(java.lang.String)
	 */
	public void disableMember(int id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method : disableMember(int id)");
		memberMapper.disableMember(id);
		logger.info("Class :MemberDaoImpl : Method :disableMember(int id) : disableMember Successfully:Id "
				+ id);
		logger.info("Class :" + getClass()
				+ " : Leaving Method : disableMember(int id)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#createUser(com.vtg.model.Member)
	 */
	public void createMember(MemberPersona member) {
		try {
			memberMapper.insert(member);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :createMember(MemberPersona member): MemberPersona Added Successfully");
		} catch (Exception e) {
			logger.error("Class :"
					+ getClass()
					+ " : Method :createMember(MemberPersona member): MemberPersona Added UnSuccessfully: Exception :"
					+ e);
		}
	}
}
