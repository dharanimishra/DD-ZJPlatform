package com.ziksana.util;

import java.util.List;

import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.TreeNodeObject;

public class TreeNodeObjXML {

	public String getTreeNodeXML(TreeNodeObject treeObject) {
		StringBuffer sb = new StringBuffer();
		sb.append("<NODE");
		sb.append("<Node ID='" + treeObject.getCourse().getCourseId()
				+ "' Name='" + treeObject.getCourse().getName() + "'>");

		List<CourseLearningComponent> courseLearningComponentList = treeObject
				.getCourseLearningComponent();
		for (CourseLearningComponent courseLearningComponent : courseLearningComponentList) {

			sb.append("<Node ID=\""
					+ courseLearningComponent.getCourseLearningComponentId()
							.getDisplayID() + "\" Name="
					+ courseLearningComponent.getLearningComponent().getName()
					+ "\">");
			String getCourseLearningComponentId = courseLearningComponent
					.getCourseLearningComponentId().getStorageID();

			List<LearningContent> learningContentList = treeObject.getMap()
					.get(getCourseLearningComponentId);
			for (LearningContent learningContent : learningContentList) {

				sb.append("<Node ID=\""
						+ learningContent.getLearningContentId() + "\" Name='"
						+ learningContent.getContentName() + "\">");

				sb.append("</Node>");
			}
			sb.append("</Node>");
		}
		sb.append("</Node>");

		return sb.toString();

	}
}
