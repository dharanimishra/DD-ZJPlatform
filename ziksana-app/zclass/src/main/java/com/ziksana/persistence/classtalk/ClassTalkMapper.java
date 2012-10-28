package com.ziksana.persistence.classtalk;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.classtalk.LearnerOnline;
import com.ziksana.domain.course.Course;

public interface ClassTalkMapper {
	
	List<LearnerOnline>  getAllOnlineLearners(Integer courseId);
	List<LearnerOnline>  getOnlineLearnersByCircle(@Param("memberRoleId") Integer memberRoleId, @Param("relationshipType") Integer relationshipType);
	
	

}
