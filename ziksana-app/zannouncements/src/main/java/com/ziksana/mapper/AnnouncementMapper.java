
package com.ziksana.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.model.Announcement;

/**
 * @author Ratnesh
 * 
 */

public interface AnnouncementMapper {

	final String SELECT_ALL = "SELECT * FROM corannouncement";
	final String SELECT_BY_ID = "SELECT * FROM corannouncement WHERE AnnouncementId = #{announcementId}";
	final String UPDATE = "UPDATE corannouncement SET  Message= #{message} WHERE AnnouncementId = #{announcementId}";
	final String UPDATE_NAME = "UPDATE corannouncement SET  AnnouncementName= #{AnnouncementName} WHERE AnnouncementId = #{announcementId}";
	final String DELETE = "DELETE FROM corannouncement WHERE AnnouncementId = #{announcementId}";
	final String INSERT = "INSERT INTO corannouncement (AnnouncementId,AnnouncementDate,Message,MessageVisibility,ValidUntil,MemberRoleId,InstitutionId,InstitutionUnitId,CurriculumCourseId,LearningProgramId,CourseId,CourseLearningComponentId)"
			+ " VALUES (#{announcementId},#{AnnouncementDate},#{message},#{messageVisibility},#{validUntil},#{memberRoleId},#{institutionId},#{institutionUnitId},#{curriculumCourseId},#{LearningProgramId},#{courseId},#{courseLearningComponentId})";

	/**
	 * Returns the list of all Announcement instances from the database.
	 * 
	 * @return the list of all Announcement instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(property = "announcementId", column = "AnnouncementId"),
			@Result(property = "announcementDate", column = "AnnouncementDate"),
			@Result(property = "message", column = "Message"),
			@Result(property = "messageVisibility", column = "MessageVisibility"),
			@Result(property = "validUntil", column = "ValidUntil"),
			@Result(property = "memberRoleId", column = "MemberRoleId"),
			@Result(property = "institutionId", column = "InstitutionId"),
			@Result(property = "institutionUnitId", column = "InstitutionUnitId"),
			@Result(property = "curriculumCourseId", column = "CurriculumCourseId"),
			@Result(property = "learningProgramId", column = "LearningProgramId"),
			@Result(property = "courseId", column = "CourseId"),
			@Result(property = "courseLearningComponentId", column = "CourseLearningComponentId") })
	List<Announcement> selectAll();

	/**
	 * Returns a Announcement instance from the database.
	 * 
	 * @param id
	 *            primary key value used for lookup.
	 * @return A Announcement instance with a primary key value equals to pk.
	 *         null if there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = {
			@Result(property = "announcementId", column = "AnnouncementId"),
			@Result(property = "announcementDate", column = "AnnouncementDate"),
			@Result(property = "message", column = "Message"),
			@Result(property = "messageVisibility", column = "MessageVisibility"),
			@Result(property = "validUntil", column = "ValidUntil"),
			@Result(property = "memberRoleId", column = "MemberRoleId"),
			@Result(property = "institutionId", column = "InstitutionId"),
			@Result(property = "institutionUnitId", column = "InstitutionUnitId"),
			@Result(property = "curriculumCourseId", column = "CurriculumCourseId"),
			@Result(property = "learningProgramId", column = "LearningProgramId"),
			@Result(property = "courseId", column = "CourseId"),
			@Result(property = "courseLearningComponentId", column = "CourseLearningComponentId") })
	Announcement selectById(int AnnouncementId);

	/**
	 * Updates an instance of Announcement in the database.
	 * 
	 * @param Announcement
	 *            the instance to be updated.
	 */
	@Update(UPDATE)
	void update(Announcement announcement) throws Exception;

	/**
	 * Updates an instance of Announcement in the database.
	 * 
	 * @param name
	 *            name value to be updated.
	 * @param id
	 *            primary key value used for lookup.
	 */
	void updateName(@Param("message") String message,
			@Param("AnnouncementId") int announcementId) throws Exception;

	/**
	 * Delete an instance of Announcement from the database.
	 * 
	 * @param id
	 *            primary key value of the instance to be deleted.
	 */
	@Delete(DELETE)
	void delete(int AnnouncementId) throws Exception;

	/**
	 * Insert an instance of Announcement into the database.
	 * 
	 * @param Announcement
	 *            the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "announcementId")
	void insert(Announcement announcement);

}
