/**
 * 
 */
package com.ziksana.persistence.todos;

import com.ziksana.domain.todos.MemberRole;

/**
 * @author
 * 
 */
public interface MemberRoleMapper {

	public MemberRole getMemberRole(int id);

	public void updateMemberRole(MemberRole memberrole);

	public void deleteMemberRole(int id);

	public void createMemberRole(MemberRole memberrole);

}
