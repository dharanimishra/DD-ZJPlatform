/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.UserContent;
import com.ziksana.service.course.UserContentService;

/**
 * @author Ratnesh Kumar
 * 
 */

public class UserContentServiceImpl implements UserContentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(UserContentServiceImpl.class);

	@Autowired
	public UserContentService userContentService;

	public List<UserContent> getUserContent(Integer memberId) {
		LOGGER.info("Entering Class :" + getClass()
				+ " Method Name :getUserContent(Integer memberId)");

		List<UserContent> list = userContentService.getUserContent(memberId);

		LOGGER.info("Exiting Class :" + getClass()
				+ " Method Name :getUserContent(Integer memberId)");
		return list;
	}
}
