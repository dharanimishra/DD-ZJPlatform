/**
 * 
 */
package com.ziksana.service.subscription.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.persistence.subscription.SubscriptionMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.subscription.SubscriptionService;

/**
 * @author prabu
 *
 */
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionMapper subscriptionMapper;
	
	@Override
	public List<Note> getLearnerNotes(SubscriptionCourse course) {
		
		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID();
		
		return subscriptionMapper.getLearnerNotes(Integer.valueOf(memberRoleId), Integer.valueOf(course.getSubscriptionCourseId().getStorageID()));
	}

	@Override
	public List<Note> getEducatorNotes(SubscriptionCourse course) {
		// TODO Auto-generated method stub
		
		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID();
		
		return subscriptionMapper.getEducatorNotes(Integer.valueOf(memberRoleId), Integer.valueOf(course.getSubscriptionCourseId().getStorageID()));
	}

	

}
