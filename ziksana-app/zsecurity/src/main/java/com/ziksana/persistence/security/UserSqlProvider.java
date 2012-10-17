/**
 * 
 */
package com.ziksana.persistence.security;

import static org.apache.ibatis.jdbc.SqlBuilder.*;
/**
 * @author prabu
 *
 */
public class UserSqlProvider {
	
	public String getUserSql() {
		BEGIN();
		SELECT("*");
		FROM("memmember");
		FROM("memmemberrole");
		FROM("secmembercredential");
		WHERE("memmember.ID=secmembercredential.MemberId");
		WHERE("memmember.ID=memmemberrole.memberId");
		WHERE("secmembercredential.UserName=#{userName}");
		return SQL();
	}

}
