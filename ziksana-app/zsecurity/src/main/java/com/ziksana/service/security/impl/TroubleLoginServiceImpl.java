/**
 * 
 */
package com.ziksana.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.persistence.security.ProfileMapper;
import com.ziksana.persistence.security.TroubleLoginMapper;
import com.ziksana.service.security.TroubleLoginService;

/**
 * @author vtg-p13
 *
 */
@Service
public class TroubleLoginServiceImpl implements TroubleLoginService {

	@Autowired
	TroubleLoginMapper troubleLoginMapper;
	
	@Autowired
	ProfileMapper profileMapper;
	
	/*
	 * check whether the userId is already exists or not
	 */
	public boolean isUserIdExists(String userId) {

		return troubleLoginMapper.isUserIdExists(userId);
	}

	/* 
	 * check whether the secret answer is already exists or not
	 */
	public boolean isSecretAnswerExists(String answer, String secretQuestion, String memberId) {

		return troubleLoginMapper.isSecretAnswerExists(answer, secretQuestion, memberId);
	}

	
}
