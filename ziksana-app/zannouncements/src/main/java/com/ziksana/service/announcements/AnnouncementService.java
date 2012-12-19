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

	public List<Announcement> getAnnouncement(int memberRoleId);

	public void updateAnnouncement(Announcement announcement);

	public void deleteAnnouncement(int announcementId);

	public void createAnnouncement(Announcement announcement);
}
