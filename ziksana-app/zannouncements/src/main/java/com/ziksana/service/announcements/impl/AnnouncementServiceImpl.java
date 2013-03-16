/**
 * 
 */
package com.ziksana.service.announcements.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.announcements.Announcement;
import com.ziksana.persistence.announcements.AnnouncementMapper;
import com.ziksana.security.util.ThreadLocalUtil;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vtg.service.AnnouncementService#selectById(int)
	 */
	public List<Announcement> getAnnouncement() {
		LOGGER.info("Class :" + getClass()
				+ " : Entering Method :selectById(int announcementDaoImpl)");
		
		List<Announcement> announcement = new  ArrayList<Announcement>();

		
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		int offset = 0;
		int limit = 2;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return announcementMapper.getAnnouncement(memberRoleId, rowBounds);
		
		
		
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

	
	
	@Override
	public List<Announcement> getInstitutionAnnouncements(String startDate, String endDate) {
		
		List<Announcement> announcement = new  ArrayList<Announcement>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try{
		Date formatStartDate = dateFormat.parse(startDate);
		Date formatedStartDate = combineDateTime(formatStartDate);
		Date formatDate = dateFormat.parse(endDate);
		Date formatEndDate = combineDateTime(formatDate);
		System.out.println(" start date is "+formatEndDate);
		
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		
		announcement = announcementMapper.getInstitutionAnnouncements(memberRoleId, formatStartDate, formatEndDate);
		LOGGER.info("Institution Announcement Size :"+announcement.size());
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return announcement;
	}

	@Override
	public List<Announcement> getInstitutionUnitAnnouncements(String startDate, String endDate) {
		List<Announcement> announcement = new  ArrayList<Announcement>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try{
		Date formatStartDate = (Date)dateFormat.parse(startDate);
		Date formatedStartDate = combineDateTime(formatStartDate);
		Date formatDate = dateFormat.parse(endDate);
		Date formatEndDate = combineDateTime(formatDate);
		 System.out.println(" end date is "+formatEndDate);
		
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		
		announcement = announcementMapper.getInstitutionUnitAnnouncements(memberRoleId, formatStartDate, formatEndDate);
		LOGGER.info("Institution Announcement Size :"+announcement.size());
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return announcement;
	}

	@Override
	public List<Announcement> getCourseAnnouncements(String startDate, String endDate) {
		List<Announcement> announcement = new  ArrayList<Announcement>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try{
		Date formatStartDate = (Date)dateFormat.parse(startDate);
		Date formatedStartDate = combineDateTime(formatStartDate);
		Date formatDate = dateFormat.parse(endDate);
		Date formatEndDate = combineDateTime(formatDate);
        System.out.println(" end date is "+formatEndDate);
        
        Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
        
		announcement = announcementMapper.getCourseAnnouncements(memberRoleId, formatStartDate, formatEndDate);
				LOGGER.info("Institution Announcement Size :"+announcement.size());
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return announcement;
	}

	@Override
	public List<Announcement> getAllAnnouncement() {
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
				return announcementMapper.getAllAnnouncements(memberRoleId);
	}

	@Override
	public Announcement getAnnouncementById(
			int anouncementId) {
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		return announcementMapper.getAnnouncementById(memberRoleId, anouncementId);
	}

	@Override
	public List<Announcement> getAllAnnouncementsByDate(
			String startDate, String endDate) {
		List<Announcement> announcement = new  ArrayList<Announcement>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try{
		Date formatStartDate = (Date)dateFormat.parse(startDate);
		Date formatedStartDate = combineDateTime(formatStartDate);
		Date formatDate = dateFormat.parse(endDate);
		Date formatEndDate = combineDateTime(formatDate);
		 System.out.println(" end date is "+formatEndDate);
        
        Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
        
		announcement = announcementMapper.getAllAnnouncementsByDate(memberRoleId, formatStartDate, formatEndDate);
				LOGGER.info("All Announcement Size :"+announcement.size());
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return announcement;
	}

	private static Date combineDateTime(Date dateFormat){
		Date time = new Date();
		 time.setHours(23);
		 time.setMinutes(59);
		 time.setSeconds(59);
		 Calendar calendar=Calendar.getInstance();
        calendar.setTime(dateFormat);
        Calendar calendar1=Calendar.getInstance();
        calendar1.setTime(time);
        calendar.set(Calendar.HOUR_OF_DAY, calendar1.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar1.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar1.get(Calendar.SECOND));
        
        return calendar.getTime();
	}

}

