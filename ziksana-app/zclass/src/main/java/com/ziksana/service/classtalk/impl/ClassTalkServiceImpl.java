package com.ziksana.service.classtalk.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.classtalk.LearnerOnline;
import com.ziksana.domain.contacts.RelationshipType;
import com.ziksana.domain.course.Course;
import com.ziksana.persistence.classtalk.ClassTalkMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.classtalk.ClassTalkService;

public class ClassTalkServiceImpl implements ClassTalkService {

	@Autowired
	public ClassTalkMapper classTalkMapper;

	@Override
	public List<LearnerOnline> getAllOnlineLearners(Course course) {
		// TODO Auto-generated method stub

		// return
		// classTalkMapper.getAllOnlineLearners(Integer.valueOf(course.getCourseId().getStorageID()));
		return null;
	}

	@Override
	public List<LearnerOnline> getOnlineLearnersByCircle(Course course,
			RelationshipType relationshipType) {
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID());

		if (relationshipType.equals(RelationshipType.CIRCLEFIRST)) {
			return classTalkMapper.getOnlineLearnersByCircle(
					Integer.valueOf(course.getCourseId().getStorageID()),
					memberRoleId, Integer.valueOf(1000));
		} else if (relationshipType.equals(RelationshipType.CIRCLESECOND)) {
			return classTalkMapper.getOnlineLearnersByCircle(
					Integer.valueOf(course.getCourseId().getStorageID()),
					memberRoleId, Integer.valueOf(1001));
		} else {
			return classTalkMapper.getOnlineLearnersByCircle(
					Integer.valueOf(course.getCourseId().getStorageID()),
					memberRoleId, Integer.valueOf(1002));
		}

	}

}
