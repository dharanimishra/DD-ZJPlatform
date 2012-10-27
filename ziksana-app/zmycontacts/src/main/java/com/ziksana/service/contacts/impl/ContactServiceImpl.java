package com.ziksana.service.contacts.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.contacts.RelationshipType;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.persistence.contacts.ContactMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.contacts.ContactService;

public class ContactServiceImpl implements ContactService {

	@Autowired
	public ContactMapper contactMapper;
	
	@Override
	public List<MemberPersona> getAllContacts() {
		// TODO Auto-generated method stub
		return contactMapper.getAllContacts(Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID()));
	}

	
	
	@Override
	public List<MemberPersona> getContacts(RelationshipType relationshipType) {
		// TODO Auto-generated method stub
		return null;
	}

}
