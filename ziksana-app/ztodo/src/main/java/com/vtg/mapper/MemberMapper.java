/**
 * 
 */
package com.vtg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.vtg.model.MemberPersona;

/**
 * @author
 * 
 */

public interface MemberMapper {

	final String SELECT_ALL = "SELECT * FROM MEMMEMBER";

	final String SELECT_BY_ID = "SELECT * FROM MEMMEMBER WHERE ID = #{id}";

	final String DELETE = "DELETE FROM MEMMEMBER WHERE ID = #{id}";

	final String ENABLE_MEMBER = "UPDATE MEMMEMBER SET Status=1 where ID = #{id}";

	final String DISABLE_MEMBER = "UPDATE MEMMEMBER SET Status=-1 where ID = #{id}";

	final String UPDATE = "UPDATE MEMMEMBER SET  CreationDate= #{creationDate}, NotificationType= #{notificationType}, NotificationContent= #{notificationContent} , Priority= #{priority}, Status= #{status} , CompleteBy= #{completeBy}, ForMemberId= #{forMemberId}, CreatingMemberId= #{creatingMemberId},categoryType=#{categoryType} WHERE MemberId = #{MemberId}";

	final String INSERT = "INSERT INTO MEMMEMBER(ID,MemberType,RelationshipStatus,JoinedDate,FirstName,Last Name,MiddleName,NickName,Salutation,DateofBirth,SunSign,MoonSign,Active,DoNotDistrubIndicator,PicturePath)"
			+ " VALUES (#{id},#{memberType}, #{relationshipStatus}, #{joinedDate}, #{firstname}, #{lastname}, #{middlename},#{nickname},#{salutation}, #{dateofBirth}, #{sunsign}, #{moonsign}, #{active}, #{doNotDistrubIndicator}, #{picturePath})";

	/**
	 * Returns the list of all Member instances from the database.
	 * 
	 * @return the list of all Member instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "memberType", column = "MemberType"),
			@Result(property = "relationshipStatus", column = "RelationshipStatus"),
			@Result(property = "joinedDate", column = "JoinedDate"),
			@Result(property = "firstname", column = "FirstName"),
			@Result(property = "lastname", column = "LastName"),
			@Result(property = "middlename", column = "MiddleName"),
			@Result(property = "nickname", column = "NickName"),
			@Result(property = "salutation", column = "Salutation"),
			@Result(property = "dateofBirth", column = "DateofBirth"),
			@Result(property = "sunsign", column = "SunSign"),
			@Result(property = "moonsign", column = "MoonSign"),
			@Result(property = "active", column = "Active"),
			@Result(property = "doNotDistrubIndicator", column = "DoNotDistrubIndicator"),
			@Result(property = "picturePath", column = "PicturePath") })
	List<MemberPersona> selectAll();

	/**
	 * Returns a Member instance from the database.
	 * 
	 * @param id
	 *            primary key value used for lookup.
	 * @return A Member instance with a primary key value equals to pk. null if
	 *         there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "memberType", column = "MemberType"),
			@Result(property = "relationshipStatus", column = "RelationshipStatus"),
			@Result(property = "joinedDate", column = "JoinedDate"),
			@Result(property = "firstname", column = "FirstName"),
			@Result(property = "lastname", column = "LastName"),
			@Result(property = "middlename", column = "MiddleName"),
			@Result(property = "nickname", column = "NickName"),
			@Result(property = "salutation", column = "Salutation"),
			@Result(property = "dateofBirth", column = "DateofBirth"),
			@Result(property = "sunsign", column = "SunSign"),
			@Result(property = "moonsign", column = "MoonSign"),
			@Result(property = "active", column = "Active"),
			@Result(property = "doNotDistrubIndicator", column = "DoNotDistrubIndicator"),
			@Result(property = "picturePath", column = "PicturePath") })
	MemberPersona selectById(int id);

	/**
	 * Updates an instance of Member in the database.
	 * 
	 * @param Member
	 *            the instance to be updated.
	 */
	@Update(UPDATE)
	void update(MemberPersona Member) throws Exception;

	/**
	 * @param id
	 */
	@Update(ENABLE_MEMBER)
	void enableMember(int id);

	/**
	 * @param id
	 */
	@Update(DISABLE_MEMBER)
	void disableMember(int id);

	/**
	 * Delete an instance of Member from the database.
	 * 
	 * @param id
	 *            primary key value of the instance to be deleted.
	 */
	@Delete(DELETE)
	void delete(int MemberId) throws Exception;

	/**
	 * Insert an instance of Member into the database.
	 * 
	 * @param Member
	 *            the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(MemberPersona Member);

}
