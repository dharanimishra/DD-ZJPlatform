/**
 * 
 */
package com.vtg.service;

import com.vtg.exception.UserAlreadyExistsException;
import com.vtg.model.MemberPersona;

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
