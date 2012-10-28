/**
 * 
 */
package com.ziksana.service.todo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.todos.MemberPersona;
import com.ziksana.persistence.todos.MemberPersonaMapper;
import com.ziksana.service.todo.MemberService;
import com.ziksana.todo.exception.UserAlreadyExistsException;

/**
 * @author
 * 
 */
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberPersonaMapper memberPersonaMapper;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MemberServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberService#getNumberOfUsers()
	 */
	public int getNumberOfMembers() {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :getNumberOfMembers()");
		LOGGER.info("Class :"
				+ getClass()
				+ " : Method :getNumberOfMembers() :memberDaoImpl.getNumberOfMembers():"
				+ memberPersonaMapper.getNumberOfMembers());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :getNumberOfMembers()");
		return memberPersonaMapper.getNumberOfMembers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberService#findUser(java.lang.String)
	 */
	public MemberPersona findMember(int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :findMember(int id)");
		final MemberPersona member = memberPersonaMapper.findMember(id);
		LOGGER.info("Class :"
				+ getClass()
				+ " : Method :findMember(int id) :memberDaoImpl.findMember(id):"
				+ member.getId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :findMember(int id)");
		return member;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberService#updateUser(com.vtg.model.Member)
	 */
	public void updateMember(final MemberPersona member) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :updateMember(MemberPersona member)");
		try {
			memberPersonaMapper.updateMember(member);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method :updateMember(MemberPersona member) :memberDaoImpl.updateMember(member):");
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method :updateMember(MemberPersona member) :memberDaoImpl.updateMember(member): Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :updateMember(MemberPersona member)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberService#enableUser(java.lang.String)
	 */
	public void enableMember(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :enableMember(int id)");
		memberPersonaMapper.enableMember(id);
		LOGGER.info("Class :"
				+ getClass()
				+ " : Method :enableMember(int id) :memberDaoImpl.enableMember(id):Id :"
				+ id);

		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :enableMember(int id)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberService#disableUser(java.lang.String)
	 */
	public void disableMember(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :disableMember(int id)");
		memberPersonaMapper.disableMember(id);
		LOGGER.info("Class :"
				+ getClass()
				+ " : Method :disableMember(int id) :memberDaoImpl.disableMember(id):Id :"
				+ id);

		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :disableMember(int id)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberService#createUser(com.vtg.model.Member)
	 */
	public void createMember(final MemberPersona member)
			throws UserAlreadyExistsException {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :createMember(MemberPersona member)");
		try {
			final MemberPersona user = memberPersonaMapper.findMember(member
					.getId());
			if (user != null) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("User login '" + user.getFirstname()
							+ "' already exists.");
				}
				throw new UserAlreadyExistsException("User already exists.");
			}
			memberPersonaMapper.createMember(member);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method :createMember(MemberPersona member) :memberDaoImpl.createMember(member):");
		} catch (Exception e) {
			LOGGER.error("Class :"
					+ getClass()
					+ " : Method :createMember(MemberPersona member) :memberDaoImpl.createMember(member): Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :createMember(MemberPersona member)");
	}
}
