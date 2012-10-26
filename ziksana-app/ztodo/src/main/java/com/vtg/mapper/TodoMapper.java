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

import com.vtg.model.Todo;

/**
 * @author
 * 
 */
public interface TodoMapper {

	final String SELECT_ALL = "SELECT * FROM memMemberToDo";
	final String SELECT_BY_ID = "SELECT * FROM memMemberToDo WHERE ID = #{id}";
	final String UPDATE = "UPDATE memMemberToDo SET  creationDate= #{creationDate},category=category#{category}  WHERE id = #{id}";
	final String DELETE = "DELETE FROM memMemberToDo WHERE ID = #{id}";
	final String INSERT = "INSERT INTO memMemberToDo(ID,category,description,complete,memberRoleId,createDate) "
			+ "VALUES (#{id},#{category},#{description},#{complete},#{memberRoleId},#{creationDate})";

	/**
	 * Returns the list of all Todo instances from the database.
	 * 
	 * @return the list of all Todo instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = { @Result(property = "id", column = "ID"),
			@Result(property = "category", column = "category"),
			@Result(property = "description", column = "description"),
			@Result(property = "complete", column = "complete"),
			@Result(property = "memberRoleId", column = "memberRoleId"),
			@Result(property = "creationDate", column = "creationDate") })
	List<Todo> selectAll();

	/**
	 * Returns a TodoList instance from the database.
	 * 
	 * @param id
	 *            primary key value used for lookup.
	 * @return A TodoList instance with a primary key value equals to pk. null
	 *         if there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = { @Result(property = "id", column = "ID"),
			@Result(property = "category", column = "category"),
			@Result(property = "description", column = "description"),
			@Result(property = "complete", column = "complete"),
			@Result(property = "memberRoleId", column = "memberRoleId"),
			@Result(property = "creationDate", column = "creationDate") })
	Todo selectById(String id);

	/**
	 * Updates an instance of TodoList in the database.
	 * 
	 * @param TodoList
	 *            the instance to be updated.
	 */
	@Update(UPDATE)
	void update(Todo todo) throws Exception;

	/**
	 * Updates an instance of TodoList in the database.
	 * 
	 * @param name
	 *            name value to be updated.
	 * @param id
	 *            primary key value used for lookup.
	 */
	@Update(UPDATE)
	void updateName(@Param("name") String name, @Param("id") String id)
			throws Exception;

	/**
	 * Delete an instance of TodoList from the database.
	 * 
	 * @param id
	 *            primary key value of the instance to be deleted.
	 */
	@Delete(DELETE)
	void delete(String id) throws Exception;

	/**
	 * Insert an instance of TodoList into the database.
	 * 
	 * @param Todo
	 *            the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Todo todo);

}
