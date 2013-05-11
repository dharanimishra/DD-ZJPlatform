package com.ziksana.service.announcements.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Service;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.announcements.Announcement;
import com.ziksana.exception.DataBaseException;
import com.ziksana.exception.announcements.AnnouncementsException;
import com.ziksana.persistence.announcements.AnnouncementMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.announcements.AnnouncementService;

/**
 * @author
 * 
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AnnouncementServiceImpl.class);

	@Autowired
	AnnouncementMapper announcementMapper;

	public List<Announcement> getAnnouncement() {

		List<Announcement> announcementList = new ArrayList<Announcement>();
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		int offset = 0;
		int limit = 2;
		RowBounds rowBounds = new RowBounds(offset, limit);
		announcementList = announcementMapper.getAnnouncement(memberRoleId,
				rowBounds);
		return announcementList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.service.AnnouncementService#update(com.vtg.model.Announcement)
	 */
	public void updateAnnouncement(Announcement announcement) {
		LOGGER.debug("Class :" + getClass()
				+ " : Entering Method :update(Announcement announcement) ");
		announcementMapper.updateAnnouncement(announcement);
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :update(Announcement announcement) :announcementDaoImpl.update(category):");
		LOGGER.debug("Class :" + getClass()
				+ " : Leaving Method :update(Announcement announcement) ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.AnnouncementService#delete(int)
	 */
	public void deleteAnnouncement(int announcementId) {
		LOGGER.debug("Class :" + getClass()
				+ " : Entering Method :delete(int announcementId)");
		announcementMapper.deleteAnnouncement(announcementId);
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :delete(int announcementId) :announcementDaoImpl.delete(announcementId):"
				+ announcementId);
		LOGGER.debug("Class :" + getClass()
				+ " : Leaving Method :delete(int announcementId)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vtg.service.AnnouncementService#insert(com.vtg.model.Announcement)
	 */
	public void createAnnouncement(Announcement announcement) {
		LOGGER.debug("Class :" + getClass()
				+ " : Entering Method :insert(Announcement announcement)");
		announcementMapper.createAnnouncement(announcement);
		LOGGER.debug("Class :"
				+ getClass()
				+ " : Method :insert(Announcement announcement) :announcementDaoImpl.insert(announcement);:"
				+ announcement.getAnnouncementId());
	}

	public List<Announcement> getInstitutionAnnouncements(String startDate,
			String endDate) {

		List<Announcement> announcement = new ArrayList<Announcement>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date formatStartDate = dateFormat.parse(startDate);
			Date formatDate = dateFormat.parse(endDate);
			Date formatEndDate = combineDateTime(formatDate);

			Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());

			announcement = announcementMapper.getInstitutionAnnouncements(
					memberRoleId, formatStartDate, formatEndDate);

		} catch (ParseException pe) {
			throw new AnnouncementsException(
					ZiksanaConstants.ANNOUNCEMENT_PARSE_ERROR, pe);
		}
		return announcement;
	}

	public List<Announcement> getInstitutionUnitAnnouncements(String startDate,
			String endDate) {
		List<Announcement> announcement = new ArrayList<Announcement>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date formatStartDate = (Date) dateFormat.parse(startDate);
			Date formatDate = dateFormat.parse(endDate);
			Date formatEndDate = combineDateTime(formatDate);

			Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());

			announcement = announcementMapper.getInstitutionUnitAnnouncements(
					memberRoleId, formatStartDate, formatEndDate);
		} catch (ParseException pe) {
			throw new AnnouncementsException(
					ZiksanaConstants.ANNOUNCEMENT_PARSE_ERROR, pe);
		}
		return announcement;
	}

	public List<Announcement> getCourseAnnouncements(String startDate,
			String endDate) {
		List<Announcement> announcement = new ArrayList<Announcement>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date formatStartDate = (Date) dateFormat.parse(startDate);
			Date formatDate = dateFormat.parse(endDate);
			Date formatEndDate = combineDateTime(formatDate);

			Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());

			announcement = announcementMapper.getCourseAnnouncements(
					memberRoleId, formatStartDate, formatEndDate);
		} catch (ParseException pe) {
			throw new AnnouncementsException(
					ZiksanaConstants.ANNOUNCEMENT_PARSE_ERROR, pe);
		}
		return announcement;
	}

	public List<Announcement> getAllAnnouncement() {
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		List<Announcement> announcementList = new ArrayList<Announcement>();
		announcementList = announcementMapper.getAllAnnouncements(memberRoleId);
		if (announcementList.isEmpty()) {
			throw new AnnouncementsException(
					ZiksanaConstants.ANNOUNCEMENT_NOT_FOUND);
		}
		return announcementList;
	}

	public Announcement getAnnouncementById(int anouncementId) {

		Announcement announcement = new Announcement();
		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		announcement = announcementMapper.getAnnouncementById(memberRoleId,
				anouncementId);
		return announcement;
	}

	public List<Announcement> getAllAnnouncementsByDate(String startDate,
			String endDate) {
		List<Announcement> announcement = new ArrayList<Announcement>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date formatStartDate = (Date) dateFormat.parse(startDate);
			Date formatDate = dateFormat.parse(endDate);
			Date formatEndDate = combineDateTime(formatDate);

			Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());

			announcement = announcementMapper.getAllAnnouncementsByDate(
					memberRoleId, formatStartDate, formatEndDate);
		} catch (ParseException pe) {
			throw new AnnouncementsException(
					ZiksanaConstants.ANNOUNCEMENT_PARSE_ERROR, pe);
		}
		return announcement;
	}

	private static Date combineDateTime(Date dateFormat) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

}
