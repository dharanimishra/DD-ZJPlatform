package com.ziksana.service.course.impl;

import java.util.List;

import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.TreeNodeObject;

public class TreeNodeObjXML {

	public String getTreeNodeXML(TreeNodeObject treeObject) {
		StringBuffer sb = new StringBuffer();
		sb.append("<Node ID='"
				+ treeObject.getCourse().getCourseId().getDisplayID()
				+ "' Name='" + treeObject.getCourse().getName() + "'>\n");

		List<CourseLearningComponent> courseLearningComponentList = treeObject
				.getCourseLearningComponent();
		for (CourseLearningComponent courseLearningComponent : courseLearningComponentList) {

			sb.append("<Node ID=\""
					+ courseLearningComponent.getCourseLearningComponentId()
							.getDisplayID()
					+ "\" Name="
					+ courseLearningComponent.getLearningComponent()
							.getDescription() + "\">\n");
			String getCourseLearningComponentId = courseLearningComponent
					.getCourseLearningComponentId().getStorageID();

			List<LearningContent> learningContentList = treeObject.getMap()
					.get(getCourseLearningComponentId);
			for (LearningContent learningContent : learningContentList) {

				sb.append("<Node ID=\""
						+ learningContent.getLearningContentId().getDisplayID()
						+ "\" Name='" + learningContent.getContentName()
						+ "\">\n");

				sb.append("</Node>\n");
			}
			sb.append("</Node>\n");
		}
		sb.append("</Node>\n");

		return sb.toString();

	}

	public String getTreeNodeXMLArun(TreeNodeObject treeObject) {
		StringBuffer sb = new StringBuffer();
		sb.append("<Node ID='"
				+ treeObject.getCourse().getCourseId().getDisplayID()
				+ "' Name='" + treeObject.getCourse().getName() + "'>\n");

		List<CourseLearningComponent> courseLearningComponentList = treeObject
				.getCourseLearningComponent();
		for (CourseLearningComponent courseLearningComponent : courseLearningComponentList) {

			sb.append("<Node ID=\""
					+ courseLearningComponent.getCourseLearningComponentId()
							.getDisplayID()
					+ "\" Name="
					+ courseLearningComponent.getLearningComponent()
							.getDescription() + "\">\n");
			String getCourseLearningComponentId = courseLearningComponent
					.getCourseLearningComponentId().getStorageID();

			List<LearningContent> learningContentList = treeObject.getMap()
					.get(getCourseLearningComponentId);
			for (LearningContent learningContent : learningContentList) {

				sb.append("<Node ID=\""
						+ learningContent.getLearningContentId().getDisplayID()
						+ "\" Name='" + learningContent.getContentName()
						+ "\">\n");

				sb.append("</Node>\n");
				sb.append("</Node>\n");
			}
		}
		sb.append("</Node>\n");

		return sb.toString();

	}
}
