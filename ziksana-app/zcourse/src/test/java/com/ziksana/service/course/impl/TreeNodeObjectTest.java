package com.ziksana.service.course.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.TreeNode;
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
	public void getTreeComponetTest() throws Exception {
		Integer courseId = 100;

		System.out.print(" list :");
		List<TreeNode> list = courseTreeNodeService.getParentTreeComponents(courseId);
		System.out.print(" list :" + list.size());

		for (TreeNode node : list) {

			System.out.println(" node.getCourseId() :" + node.getCourseId());
			System.out
					.println(" node.getCoursename() :" + node.getCoursename());
			System.out.println(" node.getContentType() :"
					+ node.getContentType());
			System.out.println(" node.getContentTypeId() :"
					+ node.getContentTypeId());

		}

	}
}
