/**
 * 
 */
package com.ziksana.persistence.todos;

import com.ziksana.domain.todos.MemberPersona;


/**
 * @author
 * 
 */
public interface MemberPersonaMapper {

	int getNumberOfMembers();

	MemberPersona findMember(int id);

	void updateMember(MemberPersona member);

	void enableMember(int id);

	void disableMember(int id);

	void createMember(MemberPersona member);

}
