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

import com.ziksana.domain.recommendations.Recommendation;

/**
 * @author
 * 
 */

public interface RecommendationMapper {

	final String SELECT_ALL = "SELECT * FROM memmemberziksanarecommendation";
	final String SELECT_BY_ID = "SELECT * FROM memmemberziksanarecommendation WHERE MemziksanaRecommendationId = #{ID}";
	final String UPDATE = "UPDATE memmemberziksanarecommendation SET  Title= #{title} WHERE MemziksanaRecommendationId = #{ID}";
	final String DELETE = "DELETE FROM memmemberziksanarecommendation WHERE MemziksanaRecommendationId = #{ID}";
	final String INSERT = "INSERT INTO memmemberziksanarecommendation (MemziksanaRecommendationId,Title,Description,RecommendationCategory,CurrentState,TargetState,DurationtoBump,Active,CreationDate,MemberRoleId)"
			+ " VALUES (#{ID},#{title},#{description},#{category},#{currentState},#{targetState},#{durationtoBump},#{active},#{creationDate},#{memberRoleId})";

	/**
	 * Returns the list of all Announcement instances from the database.
	 * 
	 * @return the list of all Announcement instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(property = "ID", column = "MemziksanaRecommendationId"),
			@Result(property = "title", column = "Title"),
			@Result(property = "description", column = "Description"),
			@Result(property = "category", column = "RecommendationCategory"),
			@Result(property = "currentState", column = "CurrentState"),
			@Result(property = "targetState", column = "TargetState"),
			@Result(property = "durationtoBump", column = "DurationtoBump"),
			@Result(property = "active", column = "Active"),
			@Result(property = "creationDate", column = "CreationDate"),
			@Result(property = "memberRoleId", column = "MemberRoleId"), })
	List<Recommendation> selectAll();

	/**
	 * Returns a Announcement instance from the database.
	 * 
	 * @param id
	 *            primary key value used for lookup.
	 * @return A Announcement instance with a primary key value equals to pk.
	 *         null if there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = { @Result(property = "ID"),
			@Result(property = "title", column = "Title") })
	Recommendation selectById(int AnnouncementId);

	/**
	 * Updates an instance of Announcement in the database.
	 * 
	 * @param Announcement
	 *            the instance to be updated.
	 */
	@Update(UPDATE)
	void update(Recommendation recommendation) throws Exception;

	/**
	 * Updates an instance of Announcement in the database.
	 * 
	 * @param name
	 *            name value to be updated.
	 * @param id
	 *            primary key value used for lookup.
	 */
	void updateName(@Param("title") String Title, @Param("ID") int ID)
			throws Exception;

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
	@Options(useGeneratedKeys = true, keyProperty = "ID")
	void insert(Recommendation recommendation);

}
