package com.ziksana.service.classtalk;

import java.util.List;

import com.ziksana.domain.classtalk.LearnerOnline;
import com.ziksana.domain.contacts.RelationshipType;
import com.ziksana.domain.course.Course;

public interface ClassTalkService {
	
	public List<LearnerOnline>  getAllOnlineLearners(Course course);
	
	public List<LearnerOnline>   getOnlineLearnersByCircle(Course course,RelationshipType relationshipType);
	
	

}
