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

import com.vtg.model.MemberNotification;

/**
 * @author
 * 
 */
public interface MemberNotificationMapper {

	final String SELECT_ALL = "SELECT * FROM memMemberNotification";

	final String SELECT_BY_ID = "SELECT * FROM memMemberNotification WHERE ID = #{id}";

	final String SELECT_BY_NOTIFICATION_TYPE = "SELECT * FROM memMemberNotification WHERE Notification Type = #{notificationType}";

	final String UPDATE = "UPDATE memMemberNotification SET  CategoryName= #{CategoryName} WHERE ID = #{id}";

	final String UPDATE_NAME = "UPDATE memMemberNotification SET  Notification Content= #{notificationContent} WHERE ID = #{id}";

	final String DELETE = "DELETE FROM memMemberNotification WHERE ID = #{id}";

	final String INSERT = "INSERT INTO memMemberNotification(ID,Creation Date,Notification Type,Category,Notification Content,Priority,Status,Complete By,Creator Type,ActivationDate) "
			+ "VALUES (#{id},#{creationDate},#{notificationType},#{category},#{notificationContent},#{priority},#{status},#{completeBy},#{creatorType},#{activationDate})";

	/**
	 * Returns the list of all Category instances from the database.
	 * 
	 * @return the list of all Category instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "creationDate", column = "Creation Date"),
			@Result(property = "notificationType", column = "Notification Type"),
			@Result(property = "category", column = "Category"),
			@Result(property = "notificationContent", column = "Notification Content"),
			@Result(property = "priority", column = "Priority"),
			@Result(property = "Status", column = "Status"),
			@Result(property = "completeBy", column = "Complete By"),
			@Result(property = "creatorType", column = "Creator Type"),
			@Result(property = "activationDate", column = "ActivationDate")

	})
	List<MemberNotification> selectAll();

	/**
	 * Returns a MemberNotification instance from the database.
	 * 
	 * @param id
	 *            primary key value used for lookup.
	 * @return A MemberNotification instance with a primary key value equals to
	 *         pk. null if there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "creationDate", column = "Creation Date"),
			@Result(property = "notificationType", column = "Notification Type"),
			@Result(property = "category", column = "Category"),
			@Result(property = "notificationContent", column = "Notification Content"),
			@Result(property = "priority", column = "Priority"),
			@Result(property = "Status", column = "Status"),
			@Result(property = "completeBy", column = "Complete By"),
			@Result(property = "creatorType", column = "Creator Type"),
			@Result(property = "activationDate", column = "ActivationDate") })
	MemberNotification selectById(long id);

	/**
	 * Returns a MemberNotification instance from the database.
	 * 
	 * @param notificationType
	 *            primary key value used for lookup.
	 * @return A MemberNotification instance with a primary key value equals to
	 *         pk. null if there is no matching row.
	 */
	@Select(SELECT_BY_NOTIFICATION_TYPE)
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "creationDate", column = "Creation Date"),
			@Result(property = "notificationType", column = "Notification Type"),
			@Result(property = "category", column = "Category"),
			@Result(property = "notificationContent", column = "Notification Content"),
			@Result(property = "priority", column = "Priority"),
			@Result(property = "Status", column = "Status"),
			@Result(property = "completeBy", column = "Complete By"),
			@Result(property = "creatorType", column = "Creator Type"),
			@Result(property = "activationDate", column = "ActivationDate") })
	MemberNotification selectByNotificationType(int notificationType);

	/**
	 * Updates an instance of MemberNotification in the database.
	 * 
	 * @param Category
	 *            the instance to be updated.
	 */
	@Update(UPDATE)
	void update(MemberNotification memberNotification) throws Exception;

	/**
	 * Updates an instance of MemberNotification in the database.
	 * 
	 * @param name
	 *            name value to be updated.
	 * @param id
	 *            primary key value used for lookup.
	 */
	void updateName(@Param("Notification Content") String notificationContent,
			@Param("id") int id) throws Exception;

	/**
	 * Delete an instance of MemberNotification from the database.
	 * 
	 * @param id
	 *            primary key value of the instance to be deleted.
	 */
	@Delete(DELETE)
	void delete(int memberNotificationId) throws Exception;

	/**
	 * Insert an instance of MemberNotification into the database.
	 * 
	 * @param MemberNotification
	 *            the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(MemberNotification memberNotification);

}
