/**
 * 
 */
package com.ziksana.service.announcements;


import com.ziksana.model.Announcement;

/**
 * @author
 * 
 */
public interface AnnouncementService {

	public Announcement getAnnouncement(int id);

	public void updateAnnouncement(Announcement announcement);

	public void deleteAnnouncement(int announcementId);

	public void createAnnouncement(Announcement announcement);
}
