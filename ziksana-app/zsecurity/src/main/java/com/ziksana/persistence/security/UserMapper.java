/**
 * 
 */
package com.ziksana.persistence.security;




import com.ziksana.domain.member.Member;


/**
 * @author prabu
 *
 */
public interface UserMapper {
	
	
	
	//@SelectProvider(type = UserSqlProvider.class, method = "getUserSql")
    public Member getMemberByUser(String userName);

}
