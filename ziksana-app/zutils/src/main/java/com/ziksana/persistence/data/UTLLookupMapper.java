/**
 * 
 */
package com.ziksana.persistence.data;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.utils.UTLLookup;

/**
 * @author Arvind
 * 
 */
public interface UTLLookupMapper {

	@Select({ "select u.categoryName as cName, utl.LookupValueId as LookupValueId,utl.LookupValue as  LookupValue from utllookup u,  utllookupvalue utl where u.LookupId=utl.LookupId" })
	@Results(value = { @Result(property = "cName", column = "cName"),
			@Result(property = "lookupValueId", column = "LookupValueId"),
			@Result(property = "lookupValue", column = "LookupValue")

	})
	List<UTLLookup> getUTLLookupList();

	@Select({ "select u.categoryName as cName, utl.LookupValueId as LookupValueId,utl.LookupValue as  LookupValue from utllookup u,  utllookupvalue utl where u.LookupId=utl.LookupId and CategoryName=#{category,jdbcType=STRING}" })
	@Results(value = { @Result(property = "cName", column = "cName"),
			@Result(property = "lookupValueId", column = "LookupValueId"),
			@Result(property = "lookupValue", column = "LookupValue")

	})
	List<UTLLookup> getUTLLookupList(String category);
}
