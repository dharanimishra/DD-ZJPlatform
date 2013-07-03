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
	public List<Announcement> getAllAnnouncement();

	public List<Announcement> getAnnouncement(Integer startIndex, int itemsPerPage);

	public void updateAnnouncement(Announcement announcement);

	public void deleteAnnouncement(int announcementId);

	public void createAnnouncement(Announcement announcement);

	public Announcement getAnnouncementById(int anouncementId);

	// get Announcements BY Category
	public List<Announcement> getAllAnnouncementsByDate(String startDate,
			String endDate);

	public List<Announcement> getInstitutionAnnouncements(Integer startIndex,int itemsPerPage);

	public List<Announcement> getdepartmentAnnouncements(Integer startIndex,int itemsPerPage);

	public List<Announcement> getCourseAnnouncements(Integer startIndex,
			int itemsPerPage);

	public int getAllAnnouncementsSize();

	public int getUniversityAnnouncementsSize();

	public int getDepartmentAnnouncementsSize();

	public int getCourseAnnouncementsSize();
}
