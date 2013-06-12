package com.ziksana.persistence.course;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDecoration;
import com.ziksana.domain.course.LearningContentParts;

public interface LearningContentMapper {

	/**
	 * Saves the Learning Content
	 */
	Integer saveContent(LearningContent record);

	/**
	 * Updates the Learning Content
	 */
	LearningContent updateContent(LearningContent record);

	/**
	 * Saves the learningcontentparts
	 */
	Integer saveContentParts(LearningContentParts contentParts);

	/**
	 * Saves the learningcontentparts
	 */
	Integer updateContentParts(LearningContentParts contentParts);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select ID as learningcontentid, contentpath, contentformat, contenttype,"
			+ "contentname, contentdescription, thumbnailpicturepath, "
			+ "rightsowningmemberroleid from corlearningcontent where rightsowningmemberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	List<LearningContent> getListOfContentsByMemberRoleId(Integer memberRoleId);

	@Select({ "select ID as contentpartsid, partpath, partsequence, learningcontentid "
			+ "from corlearningcontentparts where ID = #{learningContentId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "contentPartsId", column = "contentpartsid"),
			@Result(property = "partPath", column = "partpath"),
			@Result(property = "partSequence", column = "partsequence"),
			@Result(property = "learningContent.learningContentId", column = "learningcontentid") })
	List<LearningContentParts> getContentPartsList(Integer learningContentId);

	@Update({ "update corlearningcontent set isdelete = #{isDelete, jdbcType=BOOLEAN} where ID =  #{learningContentId,jdbcType=INTEGER}" })
	void deleteContent(@Param("isDelete") Boolean isDelete,
			@Param("learningContentId") Integer learningContentId);

	@Select({ "select ID as contentpartsid from corlearningcontentparts where ID = #{learningContentId,jdbcType=INTEGER}" })
	List<Integer> getLearningContetPartsByContentId(Integer learningContentId);

	@Update({ "update corlearningcontentparts set isdelete = #{isDelete, jdbcType=BOOLEAN} where contentpartsid = #{contentPartsId,jdbcType=INTEGER}" })
	void deleteContentParts(@Param("isDelete") Boolean isDelete,
			@Param("learningContentPartsId") Integer learningContentPartsId);

	@Update({ "update corlearningcontent set isDelete = true where ID =  #{learningContentId,jdbcType=INTEGER}" })
	void learningContentdelete(Integer learningContentId);

	public Content getContent(Integer contentId);

	@Select({ "select ID , ContentType, Active,ContentPath,ContentName,ContentDescription,ThumbnailPicturePath,NumberOfThumbnails,ScreenshotPath from corlearningcontent where AuthoringMemberRoleId=#{memberId,jdbcType=INTEGER} and isdelete=false and active=true" })
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "contentTypeId", column = "ContentType"),
			@Result(property = "activeFlag", column = "active"),
			@Result(property = "contentUrl", column = "ContentPath"),
			@Result(property = "contentName", column = "ContentName"),
			@Result(property = "contentDescription", column = "ContentDescription"),
			@Result(property="learningContentDecorationList", javaType=ArrayList.class, column="id", many=@Many(select="getLearningContentDecorations")),			
			@Result(property = "thumbnailPicturePath", column = "ThumbnailPicturePath"),
			@Result(property = "numberOfThumbnails", column = "NumberOfThumbnails"),
			@Result(property = "screenshotPath", column = "ScreenshotPath") })
	List<LearningContent> getUserContent(Integer memberId);

	@Select({ "select ID , ContentType, Active,ContentPath,ContentName,ContentDescription,ThumbnailPicturePath,NumberOfThumbnails from corlearningcontent where id=#{learningContentId,jdbcType=INTEGER} " })
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "contentTypeId", column = "ContentType"),
			@Result(property = "activeFlag", column = "active"),
			@Result(property = "contentUrl", column = "ContentPath"),
			@Result(property = "contentName", column = "ContentName"),
			@Result(property = "contentDescription", column = "ContentDescription"),
			@Result(property = "thumbnailPicturePath", column = "ThumbnailPicturePath"),
			@Result(property = "numberOfThumbnails", column = "NumberOfThumbnails") })
	public LearningContent getLearningContent(Integer learningContentId);

	@Select({ "select ID, CreationDate, Active, ContentDecorationType, Version, description, AuthoringMemberRoleId, RightsOwningMemberRoleId, IsDelete from corlearningcontentdecoration where learningContentId=#{learningContentId,jdbcType=INTEGER} " })
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "contentDecorationTypeId", column = "ContentDecorationType"),
			@Result(property = "active", column = "active"),
			@Result(property = "isDelete", column = "isDelete"),
			@Result(property = "description", column = "description"),
			@Result(property = "version", column = "Version"),
			@Result(property = "numberOfThumbnails", column = "NumberOfThumbnails") })
	List<LearningContentDecoration> getLearningContentDecorations(Integer learningContentId);

}