/**
 * 
 */
package com.ziksana.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.dao.AnnouncementDao;
import com.ziksana.mapper.AnnouncementMapper;
import com.ziksana.model.Announcement;

/**
 * @author Ratnesh
 * 
 */
public class AnnouncementDaoImpl implements AnnouncementDao {

	private static final Logger logger = Logger
			.getLogger(AnnouncementDaoImpl.class);

	@Autowired
	private AnnouncementMapper announcementMapper;

	public void setAnnouncementMapper(AnnouncementMapper announcementMapper) {
		this.announcementMapper = announcementMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.AnnouncementDao#selectAll()
	 */
	public Collection<Announcement> selectAll() {
		logger.info("Class :" + getClass() + " : Entering Method :selectAll()");
		List<Announcement> list = announcementMapper.selectAll();
		logger.info("Class :" + getClass()
				+ " : Method :selectAll(): List Size :" + list);
		logger.info("Class :" + getClass() + " : Leaving Method :selectAll()");
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.AnnouncementDao#selectById(int)
	 */
	public Announcement selectById(int id) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :selectById(int id)");
		Announcement list = announcementMapper.selectById(id);
		logger.info("Class :" + getClass()
				+ " : Method :selectById(int id): List Size :" + list);
		logger.info("Class :" + getClass()
				+ " : Leaving Method :selectById(int id)");
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.AnnouncementDao#update(com.vtg.model.Announcement)
	 */
	public void update(Announcement announcement) throws Exception {
		logger.info("Class :" + getClass()
				+ " : Entering Method : update(Announcement announcement)");
		try {
			announcementMapper.update(announcement);
			logger.debug("Class :"
					+ getClass()
					+ " : Method : update(Announcement announcement): announcementMapper.update(announcement);"
					+ announcement.getAnnouncementId());
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method : update(Announcement announcement): announcementMapper.update(announcement);"
					+ announcement.getAnnouncementId() + " Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method : update(Announcement announcement)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.AnnouncementDao#delete(int)
	 */
	public void delete(int announcementId) throws Exception {
		logger.info("Class :" + getClass()
				+ " : Entering Method :delete(int announcementId)");
		try {
			announcementMapper.delete(announcementId);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :delete(int announcementId) : announcementId :"
					+ announcementId);
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :delete(int announcementId) : announcementId :"
					+ announcementId + " Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :delete(int announcementId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.dao.AnnouncementDao#insert(com.vtg.model.Announcement)
	 */
	public void insert(Announcement announcement) {
		logger.info("Class :" + getClass()
				+ " : Entering Method :insert(Announcement announcement)");
		try {
			announcementMapper.insert(announcement);
			logger.debug("Class :"
					+ getClass()
					+ " : Method :insert(Announcement announcement) : announcement :"
					+ announcement.getAnnouncementId());
		} catch (Exception e) {
			logger.debug("Class :"
					+ getClass()
					+ " : Method :insert(Announcement announcement) : announcement :"
					+ announcement.getAnnouncementId() + " Exception :" + e);
		}
		logger.info("Class :" + getClass()
				+ " : Leaving Method :insert(Announcement announcement)");
	}

}
