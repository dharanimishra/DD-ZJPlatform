/**
 * 
 */
package com.vtg.dao.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtg.dao.MemberNotificationDao;
import com.vtg.mapper.MemberNotificationMapper;
import com.vtg.model.MemberNotification;

/**
 * @author
 * 
 */
public class MemberNotificationDaoImpl implements MemberNotificationDao {

	@Autowired
	private MemberNotificationMapper memberNotificationMapper;

	private static final Logger LOGGER = Logger
			.getLogger(MemberNotificationDaoImpl.class);

	public void setMemberNotificationMapper(
			MemberNotificationMapper memberNotificationMapper) {
		this.memberNotificationMapper = memberNotificationMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberNotificationDao#selectAll()
	 */
	public Collection<MemberNotification> selectAll() {
		LOGGER.info("Class :" + getClass() + " : Entering Method :selectAll()");
		final Collection<MemberNotification> list = memberNotificationMapper
				.selectAll();
		LOGGER.debug("Class :" + getClass()
				+ " : Method :selectAll():list.isEmpty()" + list.isEmpty());
		LOGGER.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberNotificationDao#selectById(int)
	 */
	public MemberNotification selectById(final long id) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		MemberNotification list = memberNotificationMapper.selectById(id);
		LOGGER.debug("Class :" + getClass()
				+ ": Method :selectById(int id):list.getId()" + list.getId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberNotificationDao#selectByNotificationType(int)
	 */
	public MemberNotification selectByNotificationType(
			final int notificationType) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :selectByNotificationType(int notificationType)");
		MemberNotification list = memberNotificationMapper
				.selectByNotificationType(notificationType);
		LOGGER.debug("Class :"
				+ getClass()
				+ ": Method :selectByNotificationType(int notificationType):list.getId()"
				+ list.getId());
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method : selectByNotificationType(int notificationType)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.dao.MemberNotificationDao#update(com.vtg.model.MemberNotification
	 * )
	 */
	public void update(final MemberNotification memberNotification) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :update(MemberNotification memberNotification)");
		try {
			memberNotificationMapper.update(memberNotification);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(MemberNotification memberNotification): Update Successfully");
		} catch (Exception e) {
			LOGGER.error("Class :"
					+ getClass()
					+ " : Method :update(MemberNotification memberNotification): Update UnSuccessfully: Exception :"
					+ e);
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method :update(MemberNotification memberNotification)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberNotificationDao#delete(int)
	 */
	public void delete(final int memberNotificationId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int memberNotificationId)");
		try {
			memberNotificationMapper.delete(memberNotificationId);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method :delete(int memberNotificationId): delete Successfully : memberNotificationId :"
					+ memberNotificationId);
		} catch (Exception e) {
			LOGGER.info("Class :MemberRoleDaoImpl : Method :delete(int memberNotificationId): delete UnSuccessfully : memberNotificationId :"
					+ memberNotificationId + " Exception :" + e.getMessage());
			e.printStackTrace();
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :delete(int memberNotificationId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.dao.MemberNotificationDao#insert(com.vtg.model.MemberNotification
	 * )
	 */
	public void insert(MemberNotification memNotification) {
		LOGGER.info("Class :"
				+ getClass()
				+ " : Entering Method :insert(MemberNotification memberNotification)");
		try {
			memberNotificationMapper.insert(memNotification);
			LOGGER.info("Class :"
					+ getClass()
					+ " : Method :insert(MemberNotification memberNotification): Added Successfully : MemberNotification :"
					+ memNotification.getId());
		} catch (Exception e) {
			LOGGER.info("Class :"
					+ getClass()
					+ ": Method :insert(MemberNotification MemberNotification): Added UnSuccessfully :Exception : "
					+ e);
		}
		LOGGER.info("Class :"
				+ getClass()
				+ " : Leaving Method :insert(MemberNotification memberNotification)");

	}

}
