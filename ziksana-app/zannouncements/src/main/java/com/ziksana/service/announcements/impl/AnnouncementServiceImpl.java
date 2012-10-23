/**
 * 
 */
package com.ziksana.service.announcements.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtg.dao.impl.AnnouncementDaoImpl;
import com.vtg.model.Announcement;
import com.vtg.service.AnnouncementService;

/**
 * @author
 * 
 */
public class AnnouncementServiceImpl implements AnnouncementService {

	private static final Logger logger = Logger
			.getLogger(AnnouncementServiceImpl.class);

	@Autowired
	AnnouncementDaoImpl announcementDaoImpl;

	public void setAnnouncementDaoImpl(AnnouncementDaoImpl announcementDaoImpl) {
		this.announcementDaoImpl = announcementDaoImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.AnnouncementService#selectAll()
	 */
	public Collection<Announcement> selectAll() {
		logger.info("Class :" + getClass() + " : Entering Method :selectAll()");
		logger.info("Class :" + getClass()
				+ " : Method :selectAll() :announcementDaoImpl.selectAll():"
				+ announcementDaoImpl.selectAll().isEmpty());

		logger.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return announcementDaoImpl.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.AnnouncementService#selectById(int)
	 */
	public Announcement selectById(int announcementId) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :selectById(int announcementDaoImpl)");
		logger.debug("Class :"
				+ getClass()
				+ " : Method :selectById(int announcementId) :categoryDaoImpl.selectById(announcementId):"
				+ announcementDaoImpl.selectById(announcementId)
						.getAnnouncementId());
		logger.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int announcementId)");
		return announcementDaoImpl.selectById(announcementId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.service.AnnouncementService#update(com.vtg.model.Announcement)
	 */
	public void update(Announcement announcement) throws Exception {
		logger.info("Class :" + getClass()
				+ " : Entering Method :update(Announcement announcement) ");
		try {
			announcementDaoImpl.update(announcement);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :update(Announcement announcement) :announcementDaoImpl.update(category):");
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :update(Announcement announcement) :announcementDaoImpl.update(category): Exception :"
					+ e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :update(Announcement announcement) ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.AnnouncementService#delete(int)
	 */
	public void delete(int announcementId) throws Exception {
		logger.info("Class :" + getClass()
				+ " : Entering Method :delete(int announcementId)");
		try {
			announcementDaoImpl.delete(announcementId);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :delete(int announcementId) :announcementDaoImpl.delete(announcementId):"
					+ announcementId);
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :delete(int announcementId) :announcementDaoImpl.delete(announcementId):"
					+ announcementId + " Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :delete(int announcementId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.service.AnnouncementService#insert(com.vtg.model.Announcement)
	 */
	public void insert(Announcement announcement) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :insert(Announcement announcement)");
		try {
			announcementDaoImpl.insert(announcement);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :insert(Announcement announcement) :announcementDaoImpl.insert(announcement);:"
					+ announcement.getAnnouncementId());
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :insert(Announcement announcement) :categoryDaoImpl.insert(announcement);"
					+ announcement.getAnnouncementId() + "Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :insert(Announcement announcement)");

	}

}
