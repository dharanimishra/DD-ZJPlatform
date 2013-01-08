/**
 * 
 */
package com.ziksana.service.announcements;


import java.util.List;

import com.ziksana.domain.announcements.Announcement;

/**
 * @author
 * 
 */
public interface AnnouncementService {
	public List<Announcement> getAllAnnouncement(int memberRoleId);
	
	

	public List<Announcement> getAnnouncement(int memberRoleId);

	public void updateAnnouncement(Announcement announcement);

	public void deleteAnnouncement(int announcementId);

	public void createAnnouncement(Announcement announcement);
	
	public Announcement getAnnouncementById(int memberRoleId,int anouncementId);
	
	//get Announcements BY Category
	public List<Announcement> getAllAnnouncementsByDate(int memberRoleId,String startDate, String endDate);
	
	public List<Announcement> getInstitutionAnnouncements(int memberRoleId,String startDate, String endDate);
		
	public List<Announcement> getInstitutionUnitAnnouncements(int memberRoleId,String startDate, String endDate);
		
	public List<Announcement> getCourseAnnouncements(int memberRoleId,String startDate, String endDate);
}
