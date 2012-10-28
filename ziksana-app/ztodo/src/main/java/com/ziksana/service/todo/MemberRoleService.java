/**
 * 
 */
package com.ziksana.service.todo;

import com.ziksana.domain.todos.MemberRole;

/**
 * @author
 * 
 */
public interface MemberRoleService {

	public MemberRole getMemberRole(int id);

	public void updateMemberRole(MemberRole memberrole);

	public void deleteMemberRole(int id);

	public void createMemberRole(MemberRole memberrole);

}
