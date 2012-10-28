package com.ziksana.service.contacts;

import java.util.List;

import com.ziksana.domain.contacts.RelationshipType;
import com.ziksana.domain.member.MemberPersona;

public interface ContactService {
	
	public List<MemberPersona> getAllContacts();
	
	public List<MemberPersona> getContactsByCircle(RelationshipType relationshipType);
	
	
}
