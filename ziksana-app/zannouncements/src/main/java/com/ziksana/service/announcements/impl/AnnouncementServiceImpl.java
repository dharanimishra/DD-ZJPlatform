/**
 * 
 */
package com.ziksana.service.announcements.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.model.Announcement;
import com.ziksana.persistence.announcements.AnnouncementMapper;
import com.ziksana.service.announcements.AnnouncementService;

/**
 * @author
 * 
 */
public class AnnouncementServiceImpl implements AnnouncementService {

	private static final Logger LOGGER = Logger
			.getLogger(AnnouncementServiceImpl.class);

	@Autowired
	AnnouncementMapper announcementMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.AnnouncementService#selectById(int)
	 */
	public Announcement getAnnouncement(int announcementId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int announcementDaoImpl)");
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :selectById(int announcementId) :categoryDaoImpl.selectById(announcementId):"
				+ announcementMapper.getAnnouncement(announcementId)
						.getAnnouncementId());
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int announcementId)");
		return announcementMapper.getAnnouncement(announcementId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.service.AnnouncementService#update(com.vtg.model.Announcement)
	 */
	public void updateAnnouncement(Announcement announcement) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :update(Announcement announcement) ");
		try {
			announcementMapper.updateAnnouncement(announcement);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(Announcement announcement) :announcementDaoImpl.update(category):");
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :update(Announcement announcement) :announcementDaoImpl.update(category): Exception :"
					+ e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :update(Announcement announcement) ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.AnnouncementService#delete(int)
	 */
	public void deleteAnnouncement(int announcementId) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :delete(int announcementId)");
		try {
			announcementMapper.deleteAnnouncement(announcementId);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :delete(int announcementId) :announcementDaoImpl.delete(announcementId):"
					+ announcementId);
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :delete(int announcementId) :announcementDaoImpl.delete(announcementId):"
					+ announcementId + " Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :delete(int announcementId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.service.AnnouncementService#insert(com.vtg.model.Announcement)
	 */
	public void createAnnouncement(Announcement announcement) {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :insert(Announcement announcement)");
		try {
			announcementMapper.createAnnouncement(announcement);
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(Announcement announcement) :announcementDaoImpl.insert(announcement);:"
					+ announcement.getAnnouncementId());
		} catch (Exception e) {
			LOGGER.debug("Class :"
					+ getClass()
					+ " : Method :insert(Announcement announcement) :categoryDaoImpl.insert(announcement);"
					+ announcement.getAnnouncementId() + "Exception :" + e);
		}
		LOGGER.info("Class :" + getClass()
				+ " : Leaving Method :insert(Announcement announcement)");

	}

}
