/**
 * 
 */
package com.ziksana.service.subscription.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.persistence.subscription.SubscriptionMapper;
import com.ziksana.service.subscription.SubscriptionService;

/**
 * @author prabu
 *
 */
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionMapper subscriptionMapper;
	
	@Override
	public List<Note> getNotes(SubscriptionCourse course) {
		// TODO Auto-generated method stub
		return subscriptionMapper.getNotes(Integer.valueOf(course.getSubscriptionCourseId().getStorageID()));
	}

	

}
