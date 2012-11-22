package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;

public interface LearningContentMapper {

	/**
	 * Saves the Learning Content
	 */
	Integer save(LearningContent record);
	
	
	/** 
	 * Saves the learningcontentparts
	 */
	@Insert({
			"insert into corlearningcontentparts (creationdate, ",
			"partpath, partsequence, learningcontentid)",
			"values (sysdate(), ",
			"#{partPath,jdbcType=VARCHAR}, #{learningContentId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "contentPartsId", before = true, resultType = Integer.class)
	Integer save(LearningContentParts contentParts);


	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({"select learningcontentid, contentpath, contentformat, contenttype"+
			"contentname, contentdescription, thumbnailpicturepath, "+
			"rightsowningmemberroleid from corlearningcontent where rightsowningmemberroleid = #{memberRoleId,jdbcType=INTEGER}"})
	@ResultMap("BaseResultMap")
	List<LearningContent> getListOfContentsByMemberRoleId(Integer memberRoleId);
	
	
	@Select({"select contentpartsid, partpath, partsequence, learningcontentid " +
			"from corlearningcontentparts where learningcontentid = #{learningContentId,jdbcType=INTEGER}"})
	@Results(value={
			@Result(property="contentPartsId", column="contentpartsid"),
			@Result(property="partPath", column="partpath"),
			@Result(property="partSequence", column="partsequence"),
			@Result(property="learningContent.learningContentId", column="learningcontentid")
		})
	List<LearningContentParts> getContentPartsList(Integer learningContentId);
	

	@Update({"update corlearningcontent set isdelete = #{isDelete, jdbcType=BOOLEAN} where learningcontentid =  #{learningContentId,jdbcType=INTEGER}"})
	void updateContent(@Param("isDelete") Boolean isDelete, @Param("learningContentId") Integer learningContentId);

	@Select({"select contentpartsid from corlearningcontentparts where learningcontentid = #{learningContentId,jdbcType=INTEGER}"})
	List<Integer> getLearningContetPartsByContentId(Integer learningContentId);

	@Update({"update corlearningcontentparts set isdelete = #{isDelete, jdbcType=BOOLEAN} where contentpartsid = #{contentPartsId,jdbcType=INTEGER}"})
	void updateContentParts(@Param("isDelete") Boolean isDelete, @Param("learningContentPartsId") Integer learningContentPartsId);



}