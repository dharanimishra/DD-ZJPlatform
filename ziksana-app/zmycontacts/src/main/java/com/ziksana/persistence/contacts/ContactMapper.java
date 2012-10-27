package com.ziksana.persistence.contacts;

import java.util.List;

import com.ziksana.domain.member.MemberPersona;

public interface ContactMapper {
	
	List<MemberPersona> getAllContacts(Integer memberRoleId);

}
