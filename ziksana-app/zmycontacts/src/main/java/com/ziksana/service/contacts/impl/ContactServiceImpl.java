package com.ziksana.service.contacts.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.contacts.RelationshipType;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.persistence.contacts.ContactMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.contacts.ContactService;

public class ContactServiceImpl implements ContactService {

	@Autowired
	public ContactMapper contactMapper;

	public List<MemberPersona> getAllContacts() {
		return contactMapper.getAllContacts(Integer.valueOf(SecurityTokenUtil
				.getToken().getMemberPersonaId().getStorageID()));
	}

	public List<MemberPersona> getContactsByCircle(
			RelationshipType relationshipType) {

		Integer memberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		List<MemberPersona> list = null;

		if (relationshipType.equals(RelationshipType.CIRCLEFIRST)) {
			list = contactMapper.getContacts(memberRoleId,
					Integer.valueOf(1000));
		} else if (relationshipType.equals(RelationshipType.CIRCLESECOND)) {
			list = contactMapper.getContacts(memberRoleId,
					Integer.valueOf(1001));
		} else {
			list = contactMapper.getContacts(memberRoleId,
					Integer.valueOf(1002));
		}

		return list;
	}

}
