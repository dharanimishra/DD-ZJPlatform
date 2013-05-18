/**
 * 
 */
package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.LearningContent;

/**
 * @author prabu
 *
 */
public interface ContentMapper {
	
	public Content getContent(Integer contentId);
	
	
	@Select({ "select ID,ContentType,ContentPath,ContentName,ContentDescription,ThumbnailPicturePath from corlearningcontent where AuthoringMemberRoleId=#{memberId,jdbcType=INTEGER} and isdelete=false" })
	@Results(value = {
			@Result(property = "learningContentId", column = "ID"),
			@Result(property = "contentType", column = "ContentType"),
			@Result(property = "contentUrl", column = "ContentPath"),
			@Result(property = "contentName", column = "ContentName"),
			@Result(property = "contentDescription", column = "ContentDescription"),
			@Result(property = "thumbnailPicturePath", column = "ThumbnailPicturePath")

	})
	List<LearningContent> getUserContent(Integer memberId);

}
