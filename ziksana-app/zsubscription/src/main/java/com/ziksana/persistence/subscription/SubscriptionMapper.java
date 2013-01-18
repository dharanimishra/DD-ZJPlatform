/**
 * 
 */
package com.ziksana.persistence.subscription;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.EducatorNote;
import com.ziksana.domain.course.Reference;
import com.ziksana.domain.course.subscription.ContentReference;
import com.ziksana.domain.course.subscription.Hotspot;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.institution.LearningProgram;

/**
 * @author prabu
 * 
 */
public interface SubscriptionMapper {

	public List<Note> getLearnerNotes(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("subscrCourseId") Integer subscrCourseId,
			@Param("learnCompId") Integer learnCompId,
			@Param("learnCmpContId") Integer learnCmpContId,
			@Param("type") Integer type);

	public List<EducatorNote> getEducatorNotes(
			@Param("contentType") Integer contentType,
			@Param("memberRoleId") Integer memberRoleId,
			@Param("subscrCourseId") Integer subscrCourseId,
			@Param("learnCompId") Integer learnCompId,
			@Param("learnCmpContId") Integer learnCmpContId);

	public List<Reference> getEducatorReferences(
			@Param("contentType") Integer contentType,
			@Param("memberRoleId") Integer memberRoleId,
			@Param("subscrCourseId") Integer subscrCourseId,
			@Param("learnCompId") Integer learnCompId,
			@Param("learnCmpContId") Integer learnCmpContId);

	public List<ContentReference> getContentTOC(
			@Param("contentType") Integer contentType,
			@Param("memberRoleId") Integer memberRoleId,
			@Param("subscrCourseId") Integer subscrCourseId,
			@Param("learnCompId") Integer learnCompId,
			@Param("learnCmpContId") Integer learnCmpContId);
	
	
	public List<Hotspot> getHotspots(
			@Param("contentType") Integer contentType,
			@Param("memberRoleId") Integer memberRoleId,
			@Param("subscrCourseId") Integer subscrCourseId,
			@Param("learnCompId") Integer learnCompId,
			@Param("learnCmpContId") Integer learnCmpContId);
	
	
	

	public List<Note> getContentByType(
			@Param("subscrCourseId") Integer subscrCourseId,
			@Param("learnCompId") Integer learnCompId,
			@Param("learnCmpContId") Integer learnCmpContId,
			@Param("memberRoleId") Integer memberRoleId,
			@Param("noteType") Integer noteType);

	public int addNote(Note note);

	public int deleteNote(Integer noteId);

	public int deleteEducatorContent(Integer contentId);

	public int updateNote(@Param("noteId") Integer noteId,
			@Param("desc") String desc, @Param("duration") int duration,
			@Param("title") String title);

	public List<LearningProgram> getLearningPrograms(Integer memberRoleId);

	public List<Course> getCoursesByLearningProgram(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("learningProgramId") Integer learningProgramId);

	public Integer addEducatorContent(
			@Param("memberRoleId") Integer memberRoleId,
			@Param("type") Integer type, 
			@Param("learningCompId") Integer learningCompId,
			@Param("learningContId") Integer learningContId,
			@Param("courseId") Integer courseId,
			@Param("description") String description,
			@Param("url") String url, 
			@Param("coordinates") String coordinates,
			@Param("duration") Integer duration
			);
}
