package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.domain.course.TreeNode;

/**
 * @author ratneshkumar
 */
public interface CourseTreeNodeService {

	Course getCourseComponents(Integer courseId);

	List<CourseLearningComponent> getLearningComponents(Integer courseId);

	LearningComponentType getLearningComponentType(
			Integer learningComponentTypeId);

	LearningComponent getLearningComponent(Integer learningComponentId);

	LearningComponentNest getLearningComponentNest(
			Integer learningComponentNestId);

	List<LearningComponentContent> getLearningComponentContents(
			Integer learningComponentId);

	LearningContent getLearningContent(Integer learningContentId);

	List<LearningContentParts> getLearningContentParts(Integer learningContentId);

	List<TreeNode> getParentTreeComponents(Integer courseId);

	List<TreeNode> getTreeContentComponents(Integer courseId);

	List<TreeNode> getCourseComponent(Integer courseId);

	List<TreeNode> getModuleComponents(Integer courseId);

	List<TreeNode> getModuleContents(Integer courseId);

}
