/**
 * 
 */
package com.ziksana.service.todo;

import com.ziksana.domain.todos.MemberPersona;
import com.ziksana.todo.exception.UserAlreadyExistsException;


/**
 * @author
 * 
 */
public interface MemberService {

	int getNumberOfMembers();

	MemberPersona findMember(int id);

	void updateMember(MemberPersona member);

	void enableMember(int id);

	void disableMember(int id);

	void createMember(MemberPersona member) throws UserAlreadyExistsException;

}
