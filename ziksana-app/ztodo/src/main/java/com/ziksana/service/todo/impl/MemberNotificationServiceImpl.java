/**
 * 
 */
package com.ziksana.service.todo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.todos.MemberNotification;
import com.ziksana.persistence.todos.MemberNotificationMapper;
import com.ziksana.service.todo.MemberNotificationService;

/**
 * @author
 * 
 */
public class MemberNotificationServiceImpl implements MemberNotificationService {

	@Autowired
	MemberNotificationMapper memberNotificationMapper;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MemberNotificationServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberNotificationService#selectById(int)
	 */
	public MemberNotification getMemberNotification(final long id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :selectById(int id) :memberNotificationDaoImpl.selectById(id):"
				+ memberNotificationMapper.getMemberNotification(id).getId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return memberNotificationMapper.getMemberNotification(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberNotificationService#update(com.vtg.model.
	 * MemberNotification)
	 */
	public void updateMemberNotification(
			final MemberNotification memberNotification) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :update(MemberNotification memberNotification) ");
		try {
			memberNotificationMapper
					.updateMemberNotification(memberNotification);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(MemberNotification memberNotification) :memberNotificationDaoImpl.update(memberNotification):");
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(Category category) :memberNotificationDaoImpl.update(memberNotification): Exception :"
					+ e);
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method :update(MemberNotification memberNotification) ");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberNotificationService#delete(int)
	 */
	public void deleteMemberNotification(final int memberNotificationId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int memberNotificationId)");
		try {
			memberNotificationMapper
					.deleteMemberNotification(memberNotificationId);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :delete(int memberNotificationId) :memberNotificationDaoImpl.delete(memberNotificationId):"
					+ memberNotificationId);
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :delete(int memberNotificationId) :memberNotificationDaoImpl.delete(memberNotificationId):"
					+ memberNotificationId + " Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :delete(int memberNotificationId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberNotificationService#insert(com.vtg.model.
	 * MemberNotification)
	 */
	public void createMemberNotification(
			final MemberNotification memberNotification) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :insert(MemberNotification memberNotification)");
		try {
			memberNotificationMapper
					.createMemberNotification(memberNotification);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(MemberNotification memberNotification) :memberNotificationDaoImpl.insert(memberNotification);"
					+ memberNotification.getId());
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(MemberNotification memberNotification) :memberNotificationDaoImpl.insert(category);"
					+ memberNotification.getId() + "Exception :" + e);
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method :insert(MemberNotification memberNotification)");

	}

}
