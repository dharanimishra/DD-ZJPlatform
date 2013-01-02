/**
 * 
 */
package com.ziksana.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.EducatorNote;
import com.ziksana.domain.course.Node;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.service.subscription.SubscriptionService;

/**
 * @author prabu
 * 
 */
@Controller
@RequestMapping("/secure")
public class SubscriptionController {

	private static final Logger logger = LoggerFactory
			.getLogger(SubscriptionController.class);

	@Autowired
	SubscriptionService subscriptionService;

	@RequestMapping(value = "/showmynotes/{memberId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showLearnerNotes(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "nodeType", required = true) String nodeType,
			@RequestParam(value = "parentId", required = true) String parentId,
			@RequestParam(value = "parentNodeType", required = true) String parentNodeType) {
		logger.info("Entering showMyTodos(): ");
		ModelAndView modelView = new ModelAndView("xml/notes");

		Node node = new Node();

		node.setId(Integer.valueOf(id));
		node.setType(Integer.valueOf(nodeType));
		Node parent = new Node();
		parent.setId(Integer.valueOf(parentId));
		parent.setType(Integer.valueOf(parentNodeType));
		node.setParent(parent);

		// TODO
		modelView.addObject("notes",
				subscriptionService.getLearnerContent(null, node));

		logger.info("Exiting showMyTodos(): ");
		return modelView;
	}

	@RequestMapping(value = "/educatorNotes", method = RequestMethod.GET)
	public @ResponseBody
	List<EducatorNote> showEducatorNotes(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {

		
		
		Node node = new Node();
		String parsedNodeId = nodeId.split("_")[2];
		String parsedParentNodeId = parentNodeId.split("_")[1];
		node.setId(Integer.valueOf(parsedNodeId));
		//node.setType(Integer.valueOf(nodeType));
		Node parent = new Node();
		parent.setId(Integer.valueOf(parsedParentNodeId));
		//parent.setType(Integer.valueOf(parentNodeType));
		node.setParent(parent);

		
		return subscriptionService.getEducatorNotes(Integer.valueOf(courseId), node);
	}

	public void addLearnerQuestion(
			@RequestParam(value = "questinText", required = true) String questinText
			) {

	}

	public void addLearnerNote(
			@RequestParam(value = "note", required = true) String note
			) {

	}

}
