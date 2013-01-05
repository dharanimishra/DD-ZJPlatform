/**
 * 
 */
package com.ziksana.persistence.subscription;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.course.EducatorNote;
import com.ziksana.domain.course.Reference;
import com.ziksana.domain.course.subscription.Note;

/**
 * @author prabu
 *
 */
public interface SubscriptionMapper {
	
	public List<Note> getLearnerNotes(@Param("memberRoleId") Integer memberRoleId,@Param("subscrCourseId") Integer subscrCourseId, @Param("learnCompId") Integer learnCompId,  @Param("learnCmpContId") Integer learnCmpContId, @Param("type") Integer type);
	
	public List<EducatorNote> getEducatorNotes(@Param("contentType") Integer contentType, @Param("memberRoleId") Integer memberRoleId,@Param("subscrCourseId") Integer subscrCourseId,  @Param("learnCompId") Integer learnCompId,  @Param("learnCmpContId") Integer learnCmpContId);
	
	
	public List<Reference> getEducatorReferences(@Param("contentType") Integer contentType, @Param("memberRoleId") Integer memberRoleId,@Param("subscrCourseId") Integer subscrCourseId,  @Param("learnCompId") Integer learnCompId,  @Param("learnCmpContId") Integer learnCmpContId);
	
	public List<Note> getContentByType(@Param("subscrCourseId") Integer subscrCourseId, @Param("learnCompId") Integer learnCompId,  @Param("learnCmpContId") Integer learnCmpContId, 
			@Param("memberRoleId") Integer memberRoleId, @Param("noteType") Integer noteType);
	
	public int addNote(Note note);
	

}
