/**
 * 
 */
package com.ziksana.persistence.announcements;

import com.ziksana.model.Announcement;

/**
 * @author
 * 
 */
public interface AnnouncementMapper {

	public Announcement getAnnouncement(int id);

	public void updateAnnouncement(Announcement announcement);

	public void deleteAnnouncement(int announcementId);

	public void createAnnouncement(Announcement announcement);
}
