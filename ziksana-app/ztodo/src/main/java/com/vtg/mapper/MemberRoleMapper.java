/**
 * 
 */
package com.vtg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.vtg.model.MemberRole;

/**
 * @author
 * 
 */

public interface MemberRoleMapper {

	final String SELECT_ALL = "SELECT * FROM MEMMEMBERROLE";
	final String SELECT_BY_ID = "SELECT * FROM MEMMEMBERROLE WHERE ID = #{id}";
	final String UPDATE = "UPDATE MEMMEMBERROLE SET  Role Type= #{roleType},Role Start Date= #{roleStartDate},Role End Date= #{roleEndDate},Active= #{active},Do Not Market Indicator= #{doNotMarketIndicator},Thumbnail Picture Path= #{thumbnailPicturePath} WHERE ID = #{id}";
	final String UPDATE_BY_ROLETYPE = "UPDATE MEMMEMBERROLE SET  Role Type= #{RoleType} WHERE ID = #{id}";
	final String DELETE = "DELETE FROM MEMMEMBERROLE ID = #{id}";
	final String INSERT = "INSERT INTO MEMMEMBERROLE (ID,RoleType,RoleStartDate,RoleEndDate,Active,DoNotMarketIndicator,ThumbnailPicturePath) VALUES (#{id},#{roleType}, #{roleStartDate}, #{roleEndDate}, #{doNotMarketIndicator}, #{thumbnailPicturePath})";

	/**
	 * Returns the list of all MemberRole instances from the database.
	 * 
	 * @return the list of all MemberRole instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "roleType", column = "RoleType"),
			@Result(property = "roleStartDate", column = "RoleStartDate"),
			@Result(property = "roleEndDate", column = "RoleEndDate"),
			@Result(property = "active", column = "Active"),
			@Result(property = "doNotMarketIndicator", column = "DoNotMarketIndicator"),
			@Result(property = "thumbnailPicturePath", column = "ThumbnailPicturePath") })
	List<MemberRole> selectAll();

	/**
	 * Returns a MemberRole instance from the database.
	 * 
	 * @param id
	 *            primary key value used for lookup.
	 * @return A MemberRole instance with a primary key value equals to pk. null
	 *         if there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "roleType", column = "RoleType"),
			@Result(property = "roleStartDate", column = "RoleStartDate"),
			@Result(property = "roleEndDate", column = "RoleEndDate"),
			@Result(property = "active", column = "Active"),
			@Result(property = "doNotMarketIndicator", column = "DoNotMarketIndicator"),
			@Result(property = "thumbnailPicturePath", column = "ThumbnailPicturePath") })
	MemberRole selectById(int memberRoleId);

	/**
	 * Updates an instance of MemberRole in the database.
	 * 
	 * @param MemberRole
	 *            the instance to be updated.
	 */
	@Update(UPDATE)
	void update(MemberRole memberRole) throws Exception;

	/**
	 * Updates an instance of MemberRole in the database.
	 * 
	 * @param name
	 *            name value to be updated.
	 * @param id
	 *            primary key value used for lookup.
	 */
	@Update(UPDATE_BY_ROLETYPE)
	void updateRoleType(@Param("RoleType") String MemberName,
			@Param("id") int memberRoleId) throws Exception;

	/**
	 * Delete an instance of MemberRole from the database.
	 * 
	 * @param id
	 *            primary key value of the instance to be deleted.
	 */
	@Delete(DELETE)
	void delete(int id) throws Exception;

	/**
	 * Insert an instance of MemberRole into the database.
	 * 
	 * @param MemberRole
	 *            the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(MemberRole memberRole);

}
