package com.ziksana.persistence.contacts;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.member.MemberPersona;

public interface ContactMapper {
	
	List<MemberPersona> getAllContacts(Integer memberRoleId);
	List<MemberPersona> getContacts(@Param("memberRoleId") Integer memberRoleId, @Param("relationshipType") Integer relationshipType); 

}
