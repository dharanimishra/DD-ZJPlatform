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
		SELECT("distinct memmember.*");
		FROM("memmember");
		FROM("memmemberrole");
		FROM("secmembercredential");
		WHERE("memmember.MemberId=secmembercredential.MemberId");
		WHERE("memmember.MemberId=memmemberrole.memberId");
		WHERE("secmembercredential.UserName=#{userName}");
		return SQL();
	}

}
