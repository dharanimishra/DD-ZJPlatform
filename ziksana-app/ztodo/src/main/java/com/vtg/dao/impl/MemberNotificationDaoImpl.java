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

	private static final Logger logger = Logger
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
		logger.info("Class :" + getClass() + " : Entering Method :selectAll()");
		Collection<MemberNotification> list = memberNotificationMapper
				.selectAll();
		logger.debug("Class :" + getClass()
				+ " : Method :selectAll():list.isEmpty()" + list.isEmpty());
		logger.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberNotificationDao#selectById(int)
	 */
	public MemberNotification selectById(long id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		MemberNotification list = memberNotificationMapper.selectById(id);
		logger.debug("Class :" + getClass()
				+ ": Method :selectById(int id):list.getId()" + list.getId());
		logger.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberNotificationDao#selectByNotificationType(int)
	 */
	public MemberNotification selectByNotificationType(int notificationType) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method :selectByNotificationType(int notificationType)");
		MemberNotification list = memberNotificationMapper
				.selectByNotificationType(notificationType);
		logger.debug("Class :"
				+ getClass()
				+ ": Method :selectByNotificationType(int notificationType):list.getId()"
				+ list.getId());
		logger.info("Class :"
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
	public void update(MemberNotification memberNotification) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method :update(MemberNotification memberNotification)");
		try {
			memberNotificationMapper.update(memberNotification);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :update(MemberNotification memberNotification): Update Successfully");
		} catch (Exception e) {
			logger.error("Class :"
					+ getClass()
					+ " : Method :update(MemberNotification memberNotification): Update UnSuccessfully: Exception :"
					+ e);
		}
		logger.info("Class :"
				+ getClass()
				+ " : Leaving Method :update(MemberNotification memberNotification)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.MemberNotificationDao#delete(int)
	 */
	public void delete(int memberNotificationId) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :delete(int memberNotificationId)");
		try {
			memberNotificationMapper.delete(memberNotificationId);
			logger.info("Class :"
					+ getClass()
					+ " : Method :delete(int memberNotificationId): delete Successfully : memberNotificationId :"
					+ memberNotificationId);
		} catch (Exception e) {
			logger.info("Class :MemberRoleDaoImpl : Method :delete(int memberNotificationId): delete UnSuccessfully : memberNotificationId :"
					+ memberNotificationId + " Exception :" + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :delete(int memberNotificationId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.dao.MemberNotificationDao#insert(com.vtg.model.MemberNotification
	 * )
	 */
	public void insert(MemberNotification memberNotification) {
		logger.info("Class :"
				+ getClass()
				+ " : Entering Method :insert(MemberNotification memberNotification)");
		try {
			memberNotificationMapper.insert(memberNotification);
			logger.info("Class :"
					+ getClass()
					+ " : Method :insert(MemberNotification memberNotification): Added Successfully : MemberNotification :"
					+ memberNotification.getId());
		} catch (Exception e) {
			logger.info("Class :"
					+ getClass()
					+ ": Method :insert(MemberNotification MemberNotification): Added UnSuccessfully :Exception : "
					+ e);
		}
		logger.info("Class :"
				+ getClass()
				+ " : Leaving Method :insert(MemberNotification memberNotification)");

	}

}
