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

import com.vtg.model.TodoList;

/**
 * @author
 * 
 */
public interface TodoListMapper {

	final String SELECT_ALL = "SELECT * FROM todo_list";
	final String SELECT_BY_ID = "SELECT * FROM todo_list WHERE id = #{id}";
	final String UPDATE = "UPDATE todo_list SET  name= #{name} WHERE id = #{id}";
	final String DELETE = "DELETE FROM todo_list WHERE id = #{id}";
	final String INSERT = "INSERT INTO todo_list (id,name,lastUpdate) VALUES (#{id},#{name},#{lastUpdate})";

	/**
	 * Returns the list of all TodoList instances from the database.
	 * 
	 * @return the list of all TodoList instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "lastUpdate", column = "lastUpdate") })
	List<TodoList> selectAll();

	/**
	 * Returns a TodoList instance from the database.
	 * 
	 * @param id
	 *            primary key value used for lookup.
	 * @return A TodoList instance with a primary key value equals to pk. null
	 *         if there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = { @Result(property = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "lastUpdate", column = "lastUpdate") })
	TodoList selectById(String id);

	/**
	 * Updates an instance of TodoList in the database.
	 * 
	 * @param TodoList
	 *            the instance to be updated.
	 */
	@Update(UPDATE)
	void update(TodoList todoList) throws Exception;

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
	 * @param TodoList
	 *            the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(TodoList TodoList);

}
