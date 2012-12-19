/**
 * 
 */
package com.ziksana.persistence.announcements;

import java.util.List;

import com.ziksana.domain.announcements.Announcement;

/**
 * @author
 * 
 */
public interface AnnouncementMapper {

	public List<Announcement> getAnnouncement(int memberRoleId);

	public void updateAnnouncement(Announcement announcement);

	public void deleteAnnouncement(int announcementId);

	public void createAnnouncement(Announcement announcement);
}
