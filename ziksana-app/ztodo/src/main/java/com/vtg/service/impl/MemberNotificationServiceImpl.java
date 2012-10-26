/**
 * 
 */
package com.vtg.service.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtg.dao.impl.MemberNotificationDaoImpl;
import com.vtg.model.MemberNotification;
import com.vtg.service.MemberNotificationService;

/**
 * @author
 * 
 */
public class MemberNotificationServiceImpl implements MemberNotificationService {

	@Autowired
	MemberNotificationDaoImpl memberNotificationDaoImpl;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MemberNotificationServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberNotificationService#selectAll()
	 */
	public Collection<MemberNotification> selectAll() {
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");
		LOGGER.info("Class :"
				+ getClass()
				+ " : Method :selectAll() :memberNotificationDaoImpl.selectAll():"
				+ memberNotificationDaoImpl.selectAll().isEmpty());

		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return memberNotificationDaoImpl.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberNotificationService#selectById(int)
	 */
	public MemberNotification selectById(final int id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :selectById(int id) :memberNotificationDaoImpl.selectById(id):"
				+ memberNotificationDaoImpl.selectById(id).getId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return memberNotificationDaoImpl.selectById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.MemberNotificationService#update(com.vtg.model.
	 * MemberNotification)
	 */
	public void update(final MemberNotification memberNotification) throws Exception {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :update(MemberNotification memberNotification) ");
		try {
			memberNotificationDaoImpl.update(memberNotification);
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
	public void delete(final int memberNotificationId) throws Exception {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int memberNotificationId)");
		try {
			memberNotificationDaoImpl.delete(memberNotificationId);
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
	public void insert(final MemberNotification memberNotification) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :insert(MemberNotification memberNotification)");
		try {
			memberNotificationDaoImpl.insert(memberNotification);
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
