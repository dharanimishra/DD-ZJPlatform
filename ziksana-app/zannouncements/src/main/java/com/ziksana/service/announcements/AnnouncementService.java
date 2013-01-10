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

	public List<Announcement> getAnnouncement();

	public void updateAnnouncement(Announcement announcement);

	public void deleteAnnouncement(int announcementId);

	public void createAnnouncement(Announcement announcement);

	public Announcement getAnnouncementById(int anouncementId);

	// get Announcements BY Category
	public List<Announcement> getAllAnnouncementsByDate(String startDate,
			String endDate);

	public List<Announcement> getInstitutionAnnouncements(String startDate,
			String endDate);

	public List<Announcement> getInstitutionUnitAnnouncements(String startDate,
			String endDate);

	public List<Announcement> getCourseAnnouncements(String startDate,
			String endDate);
}
