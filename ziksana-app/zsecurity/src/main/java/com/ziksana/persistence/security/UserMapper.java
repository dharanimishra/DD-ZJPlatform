/**
 * 
 */
package com.ziksana.persistence.security;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.member.Member;


/**
 * @author prabu
 *
 */
public interface UserMapper {
	
	
	
	@SelectProvider(type = UserSqlProvider.class, method = "getUserSql")
    public Member getMemberByUser(@Param("userName") String userId);

}
