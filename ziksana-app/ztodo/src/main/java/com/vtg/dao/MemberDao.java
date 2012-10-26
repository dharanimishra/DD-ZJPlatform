/**
 * 
 */
package com.vtg.dao;

import com.vtg.model.MemberPersona;

/**
 * @author
 * 
 */
public interface MemberDao {

	int getNumberOfMembers();

	MemberPersona findMember(int id);

	void updateMember(MemberPersona member);

	void enableMember(int id);

	void disableMember(int id);

	void createMember(MemberPersona member);

}
