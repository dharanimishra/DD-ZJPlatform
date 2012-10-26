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

	private static final Logger LOGGER = Logger.getLogger(MemberDaoImpl.class);

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
		LOGGER.info("Class :MemberDaoImpl : Method :setMemberMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#getNumberOfUsers()
	 */
	public int getNumberOfMembers() {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :getNumberOfMembers()");
		final List<MemberPersona> list = memberMapper.selectAll();
		LOGGER.info("Class :MemberDaoImpl : Method :getNumberOfMembers():"
				+ list.size());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :getNumberOfMembers()");
		return list.size();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#findUser(java.lang.String)
	 */
	public MemberPersona findMember(int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :findMember(int id)");
		MemberPersona list = memberMapper.selectById(id);
		LOGGER.info("Class :MemberDaoImpl : Method :findMember(int id):" + id
				+ "List:" + list);
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :findMember(int id)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#updateUser(com.vtg.model.Member)
	 */
	public void updateMember(MemberPersona member) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method : updateMember(MemberPersona member)");
		try {
			memberMapper.update(member);
			LOGGER.debug("Class :MemberDaoImpl : Method :updateMember(MemberPersona member) Successfully");
		} catch (Exception e) {
			LOGGER.error("Class :"
					+ getClass()
					+ " : Method :updateMember(MemberPersona member) Updated UnSuccessfully: Exception:"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :updateMember(MemberPersona member)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#enableUser(java.lang.String)
	 */
	public void enableMember(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method : enableMember(int id)");
		memberMapper.enableMember(id);
		LOGGER.info("Class :MemberDaoImpl : Method :enableMember(int id) : enableMember Successfully:Id "
				+ id);
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method : enableMember(int id)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberDao#disableUser(java.lang.String)
	 */
	public void disableMember(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method : disableMember(int id)");
		memberMapper.disableMember(id);
		LOGGER.info("Class :MemberDaoImpl : Method :disableMember(int id) : disableMember Successfully:Id "
				+ id);
		LOGGER.info("Class :" + getClass()
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
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :createMember(MemberPersona member): MemberPersona Added Successfully");
		} catch (Exception e) {
			LOGGER.error("Class :"
					+ getClass()
					+ " : Method :createMember(MemberPersona member): MemberPersona Added UnSuccessfully: Exception :"
					+ e);
		}
	}
}
