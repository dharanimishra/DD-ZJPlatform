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

import com.vtg.model.Category;

/**
 * @author
 * 
 */

public interface CategoryMapper  {

	final String SELECT_ALL = "SELECT CategoryId,CategoryName FROM category";
	final String SELECT_BY_ID = "SELECT CategoryId,CategoryName FROM category WHERE CategoryId = #{categoryId}";
	final String UPDATE = "UPDATE category SET  CategoryName= #{CategoryName} WHERE CategoryId = #{categoryId}";
	final String UPDATE_NAME = "UPDATE category SET  CategoryName= #{categoryName} WHERE CategoryId = #{categoryId}";
	final String DELETE = "DELETE FROM category WHERE CategoryId = #{categoryId}";
	final String INSERT = "INSERT INTO category (CategoryId,CategoryName) VALUES (#{categoryId},#{categoryName})";

	/**
	 * Returns the list of all Category instances from the database.
	 * 
	 * @return the list of all Category instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = { @Result(property = "categoryId", column = "CategoryId"),
			@Result(property = "categoryName", column = "CategoryName") })
	List<Category> selectAll();

	/**
	 * Returns a Category instance from the database.
	 * 
	 * @param id
	 *            primary key value used for lookup.
	 * @return A Category instance with a primary key value equals to pk. null
	 *         if there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = { @Result(property = "categoryId"),
			@Result(property = "categoryName", column = "CategoryName") })
	Category selectById(int categoryId);

	/**
	 * Updates an instance of Category in the database.
	 * 
	 * @param Category
	 *            the instance to be updated.
	 */
	@Update(UPDATE)
	void update(Category Category) throws Exception;

	/**
	 * Updates an instance of Category in the database.
	 * 
	 * @param name
	 *            name value to be updated.
	 * @param id
	 *            primary key value used for lookup.
	 */
	void updateName(@Param("categoryName") String categoryName,
			@Param("categoryId") int categoryId) throws Exception;

	/**
	 * Delete an instance of Category from the database.
	 * 
	 * @param id
	 *            primary key value of the instance to be deleted.
	 */
	@Delete(DELETE)
	void delete(int categoryId) throws Exception;

	/**
	 * Insert an instance of Category into the database.
	 * 
	 * @param Category
	 *            the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "categoryId")
	void insert(Category category);

}
