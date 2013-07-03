/**
 * 
 */
package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.UserContent;

/**
 * @author Ratnesh Kumar
 * 
 */
public interface UserContentMapper {

	@Select({ "select * from corlearningcontent where AuthoringMemberRoleId=#{memberId,jdbcType=INTEGER} and isdelete=false" })
	@Results(value = {
			@Result(property = "contentId", column = "ID"),
			@Result(property = "contentType", column = "ContentType"),
			@Result(property = "contentUrl", column = "ContentPath"),
			@Result(property = "contentName", column = "ContentName"),
			@Result(property = "numberOfThumbnails", column = "NumberOfThumbnails")

	})
	List<UserContent> getUserContent(Integer memberId);

}
