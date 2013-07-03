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
	
	
	@Select({ "select ID,ContentType,ContentPath,ContentName,ContentDescription,ThumbnailPicturePath from corlearningcontent where AuthoringMemberRoleId=#{memberId,jdbcType=INTEGER} and isdelete=false and active=true" })
	@Results(value = {
			@Result(property = "learningContentId", column = "ID"),
			@Result(property = "contentTypeId", column = "ContentType"),
			@Result(property = "activeFlag", column = "activeFlag"),
			@Result(property = "active", column = "active"),
			@Result(property = "contentUrl", column = "ContentPath"),
			@Result(property = "contentName", column = "ContentName"),
			@Result(property = "contentDescription", column = "ContentDescription"),
			@Result(property = "thumbnailPicturePath", column = "ThumbnailPicturePath"),
			@Result(property = "creationDate", column = "creationDate")

	})
	List<LearningContent> getUserContent(Integer memberId);

	
	//TODO following is not complete
	@Select({ "select content.ID, content.ContentType, content.ContentPath, content.ContentName, content.ContentDescription, content.ThumbnailPicturePath " + 
	" from corlearningcontent content, corlearningcomponentcontent componentcontent where "+
	" content.AuthoringMemberRoleId=#{memberId,jdbcType=INTEGER} "+
	" and content.isdelete=false and content.active=true "+
	" and componentcontent.LearningComponentId != #{componentId,jdbcType=INTEGER} and componentcontent.isdelete=false " })
	@Results(value = {
			@Result(property = "learningContentId", column = "ID"),
			@Result(property = "contentTypeId", column = "ContentType"),
			@Result(property = "activeFlag", column = "activeFlag"),
			@Result(property = "active", column = "active"),
			@Result(property = "contentUrl", column = "ContentPath"),
			@Result(property = "contentName", column = "ContentName"),
			@Result(property = "contentDescription", column = "ContentDescription"),
			@Result(property = "thumbnailPicturePath", column = "ThumbnailPicturePath"),
			@Result(property = "creationDate", column = "creationDate")

	})
	List<LearningContent> getContentsToBeAssociated(Integer memberId, Integer componentId);
	//TODO This method will be required when we will start filtering on the basis of component id, NOT TESTED
	/**
	 * This method only returns the list of contents which are not associated for the provided component id 
	 * @param learningContentId
	 * @return
	 */
	public LearningContent getLearningContent(Integer learningContentId);
}
