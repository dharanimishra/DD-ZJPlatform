/**
 * 
 */
package com.ziksana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.Node;
import com.ziksana.service.subscription.SubscriptionService;

/**
 * @author prabu
 * 
 */
public class SubscriptionController {

	private static final Logger logger = LoggerFactory
			.getLogger(SubscriptionController.class);

	@Autowired
	SubscriptionService subscriptionService;

	@RequestMapping(value = "/showmynotes/{memberId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showLearnerNotes(
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

		//TODO
		modelView.addObject("notes",
				subscriptionService.getLearnerContent(null, node));

		logger.info("Exiting showMyTodos(): ");
		return modelView;
	}
	
	
	
	
	

}
