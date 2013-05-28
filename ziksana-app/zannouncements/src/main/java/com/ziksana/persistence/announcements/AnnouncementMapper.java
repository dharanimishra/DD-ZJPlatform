/**
 * 
 */
package com.ziksana.persistence.announcements;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.announcements.Announcement;

/**
 * @author
 * 
 */
public interface AnnouncementMapper {

	public List<Announcement> getAllAnnouncements(int memberRoleId);

	public List<Announcement> getAnnouncement(@Param("memberRoleId")int memberRoleId,@Param("startIndex") Integer startIndex,@Param("itemsPerPage") int itemsPerPage);

	public void updateAnnouncement(Announcement announcement);

	public void deleteAnnouncement(int announcementId);

	public void createAnnouncement(Announcement announcement);

	public Announcement getAnnouncementById(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("announcementId") Integer announcementId);

	// get Announcements BY Category
	public List<Announcement> getAllAnnouncementsByDate(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	public List<Announcement> getInstitutionAnnouncements(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("startIndex") Integer startIndex, @Param("itemsPerPage") int itemsPerPage);

	public List<Announcement> getInstitutionUnitAnnouncements(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("startIndex") Integer startIndex,@Param("itemsPerPage") int itemsPerPage);

	public List<Announcement> getCourseAnnouncements(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("startIndex") Integer startIndex, @Param("itemsPerPage") int itemsPerPage);

	public int getAllAnnoucementSize(Integer memberRoleId);

	public int getUniversityAnnouncementsSize(Integer memberRoleId);

	public int getDepartmentAnnouncementsSize(Integer memberRoleId);

	public int getCourseAnnouncementsSize(Integer memberRoleId);

}
