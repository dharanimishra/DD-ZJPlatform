/**
 * 
 */
package com.ziksana.persistence.subscription;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.course.subscription.Note;

/**
 * @author prabu
 *
 */
public interface SubscriptionMapper {
	
	public List<Note> getLearnerNotes(@Param("memberRoleId") Integer memberRoleId,@Param("subscrCourseId") Integer subscrCourseId, @Param("learnCompId") Integer learnCompId,  @Param("learnCmpContId") Integer learnCmpContId);
	
	public List<Note> getEducatorNotes(@Param("memberRoleId") Integer memberRoleId,@Param("subscrCourseId") Integer subscrCourseId);
	
	public List<Note> getContentByType(@Param("subscrCourseId") Integer subscrCourseId, @Param("learnCompId") Integer learnCompId,  Integer learnCmpContId, 
			@Param("memberRoleId") Integer memberRoleId, @Param("noteType") Integer noteType);
	
	public void addNote(Note note);
	

}
