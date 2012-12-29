package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.TreeNodeObject;
import com.ziksana.service.course.CourseTreeNodeService;
import com.ziksana.service.course.TreeNodeObjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TreeNodeObjectTest extends BaseTest {

	@Autowired
	public CourseTreeNodeService courseTreeNodeService;

	@Autowired
	public TreeNodeObjectService treeNodeObjectService;

	@Test
	public void getCourseComponetTest() throws Exception {
		Integer courseId = 100;

		TreeNodeObject nodeObject = new TreeNodeObject();
		Course course = courseTreeNodeService.getCourseComponents(courseId);

		nodeObject.setCourse(course);
		System.out.println("course :" + course.getName() + course);

		System.out.println("<Node ID=" + course.getCourseId().getDisplayID()
				+ " Name=" + course.getName() + ">");

		List<CourseLearningComponent> courseLearningComponentList = courseTreeNodeService
				.getLearningComponents(courseId);

		nodeObject.setCourseLearningComponent(courseLearningComponentList);

		Map<String, List<LearningContent>> contentMap = new HashMap<String, List<LearningContent>>();

		List<LearningContent> learningContentList = new ArrayList<LearningContent>();
		for (CourseLearningComponent courseLearningComponent : courseLearningComponentList) {
			System.out.println("Second Loop ------");
			System.out.println("<Node ID=\""
					+ courseLearningComponent.getCourseLearningComponentId()
							.getDisplayID() + "\" Name="
					+ courseLearningComponent.getLearningComponent().getName()
					+ "\">");
			String getCourseLearningComponentId = courseLearningComponent
					.getCourseLearningComponentId().getStorageID();
			System.out.println("Second Loop ------" + courseLearningComponent);

			LearningContent LearningContent = courseTreeNodeService
					.getLearningContent(Integer
							.valueOf(getCourseLearningComponentId));
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			System.out.println("<Node ID=\""
					+ LearningContent.getLearningContentId() + "\" Name='"
					+ LearningContent.getContentName() + "\">");

			learningContentList.add(LearningContent);

			contentMap.put(LearningContent.getLearningContentId()
					.getStorageID(), learningContentList);

			System.out.println("nodeObject :" + nodeObject.getMap().get("6"));
			System.out.println("LearningContent :" + LearningContent);
			System.out.println("</Node>");
			System.out.println("</Node>");
			System.out.println("Second Loop End ------");
		}
		nodeObject.setMap(contentMap);

		System.out.println("</Node>");
		System.out.println("First Loop End------");

		System.out.println("nodeObject :" + nodeObject.getCourse());
		System.out.println("nodeObject :"
				+ nodeObject.getCourseLearningComponent().size());
		System.out.println("nodeObject :" + nodeObject.getMap().size());

	}

	@Test
	public void getTreeNodeObjectTest() throws Exception {
		Integer courseId = 100;

		TreeNodeObject obj;
		obj = treeNodeObjectService.getTreeNodeObject(courseId);

		TreeNodeObjXML tree = new TreeNodeObjXML();

		System.out.print(" tree :" + tree);

		String s = tree.getTreeNodeXML(obj);

		System.out.print("Tree Node :" + s);

	}

	@Test
	public void getTreeNodeObjectArunTest() throws Exception {
		Integer courseId = 100;

		TreeNodeObject obj;
		obj = treeNodeObjectService.getTreeNodeObject(courseId);

		TreeNodeObjXML tree = new TreeNodeObjXML();

		System.out.print(" tree :" + tree);

		String s = tree.getTreeNodeXMLArun(obj);

		System.out.print("Tree Node :" + s);

	}
}
