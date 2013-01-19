/**
 * 
 */
package com.ziksana.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.EducatorContent;
import com.ziksana.domain.course.EducatorNote;
import com.ziksana.domain.course.Node;
import com.ziksana.domain.course.Reference;
import com.ziksana.domain.course.subscription.ContentReference;
import com.ziksana.domain.course.Hotspot;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.service.data.ContentService;
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
	
	@Autowired
	ContentService contentService;

	@RequestMapping(value = "/getLearnerNotes", method = RequestMethod.GET)
	public @ResponseBody
	List<Note> showLearnerNotes(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId) {

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;

		Node node = new Node();
		String parsedNodeType = nodeId.split("_")[0];

		if (parsedNodeType.equals("LCONTENT")) {
			parsedContentId = nodeId.split("_")[3];
			parsedComponentId = nodeId.split("_")[2];

		} else if (parsedNodeType.equals("LCOMPONENT")) {
			parsedComponentId = nodeId.split("_")[1];

		} else if (parsedNodeType.equals("COURSE")) {

		}

		return subscriptionService.getLearnerNotes(Integer.valueOf(courseId),
				Integer.valueOf(parsedComponentId),
				Integer.valueOf(parsedContentId), 1000);
	}

	@RequestMapping(value = "/getLearnerQuestions", method = RequestMethod.GET)
	public @ResponseBody
	List<Note> showLearnerQuestions(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId) {

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;

		Node node = new Node();
		String parsedNodeType = nodeId.split("_")[0];

		if (parsedNodeType.equals("LCONTENT")) {
			parsedContentId = nodeId.split("_")[3];
			parsedComponentId = nodeId.split("_")[2];

		} else if (parsedNodeType.equals("LCOMPONENT")) {
			parsedComponentId = nodeId.split("_")[1];

		} else if (parsedNodeType.equals("COURSE")) {

		}

		return subscriptionService.getLearnerNotes(Integer.valueOf(courseId),
				Integer.valueOf(parsedComponentId),
				Integer.valueOf(parsedContentId), 2000);
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
		String parsedNodeId = nodeId.split("_")[3];
		String parsedParentNodeId = parentNodeId.split("_")[1];
		node.setId(Integer.valueOf(parsedNodeId));
		// node.setType(Integer.valueOf(nodeType));
		Node parent = new Node();
		parent.setId(Integer.valueOf(parsedParentNodeId));
		// parent.setType(Integer.valueOf(parentNodeType));
		node.setParent(parent);

		return subscriptionService.getEducatorNotes(Integer.valueOf(courseId),
				node);
	}

	@RequestMapping(value = "/educatorReferences", method = RequestMethod.GET)
	public @ResponseBody
	List<Reference> showEducatorReferences(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {

		Node node = new Node();
		String parsedNodeId = nodeId.split("_")[3];
		String parsedParentNodeId = parentNodeId.split("_")[1];
		node.setId(Integer.valueOf(parsedNodeId));
		// node.setType(Integer.valueOf(nodeType));
		Node parent = new Node();
		parent.setId(Integer.valueOf(parsedParentNodeId));
		// parent.setType(Integer.valueOf(parentNodeType));
		node.setParent(parent);

		return subscriptionService.getEducatorSuggestedReferences(
				Integer.valueOf(courseId), node);
	}
	
	
	@RequestMapping(value = "/getAllEducatorContent", method = RequestMethod.GET)
	public @ResponseBody
	List<EducatorContent> getAllEducatorContent(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "componentId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {

		Node node = new Node();
		String parsedNodeId = nodeId.split("_")[3];
		//String parsedParentNodeId = parentNodeId.split("_")[1];
		node.setId(Integer.valueOf(parsedNodeId));
		// node.setType(Integer.valueOf(nodeType));
		Node parent = new Node();
		parent.setId(Integer.valueOf(parentNodeId));
		// parent.setType(Integer.valueOf(parentNodeType));
		node.setParent(parent);

		return subscriptionService.getAllEducatorContent(Integer.valueOf(courseId), node);
		
		
		
		
	}
	
	
	

	@RequestMapping(value = "/getContentTOC", method = RequestMethod.GET)
	public @ResponseBody
	List<ContentReference> showContentReferences(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = false) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {

		Node node = new Node();
		String parsedNodeId = nodeId.split("_")[3];
		String parsedParentNodeId = nodeId.split("_")[2];
		node.setId(Integer.valueOf(parsedNodeId));
		// node.setType(Integer.valueOf(nodeType));
		Node parent = new Node();
		parent.setId(Integer.valueOf(parsedParentNodeId));
		// parent.setType(Integer.valueOf(parentNodeType));
		node.setParent(parent);

		return subscriptionService.getContentTOC(Integer.valueOf(courseId),
				node);

	}
	
	
	@RequestMapping(value = "/educatorHotspots", method = RequestMethod.GET)
	public @ResponseBody
	List<Hotspot> showEducatorHotspots(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {

		Node node = new Node();
		String parsedNodeId = nodeId.split("_")[3];
		String parsedParentNodeId = parentNodeId.split("_")[1];
		node.setId(Integer.valueOf(parsedNodeId));
		// node.setType(Integer.valueOf(nodeType));
		Node parent = new Node();
		parent.setId(Integer.valueOf(parsedParentNodeId));
		// parent.setType(Integer.valueOf(parentNodeType));
		node.setParent(parent);

		//this code should be modified to call getEducatorHotspots()
		//TODO 
		return subscriptionService.getEducatorHotspots(
				Integer.valueOf(courseId), node);
	}
	

	@RequestMapping(value = "/addLearnerQuestion", method = RequestMethod.POST)
	public @ResponseBody
	Integer addLearnerQuestion(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "questionTitle", required = true) String questionTitle,
			@RequestParam(value = "questionDuration", required = true) String questionDuration) {

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;

		Node node = new Node();
		String parsedNodeType = nodeId.split("_")[0];

		if (parsedNodeType.equals("LCONTENT")) {
			parsedContentId = nodeId.split("_")[3];
			parsedComponentId = nodeId.split("_")[2];

		} else if (parsedNodeType.equals("LCOMPONENT")) {
			parsedComponentId = nodeId.split("_")[1];

		} else if (parsedNodeType.equals("COURSE")) {

		}

		int key = subscriptionService.addLearnerContent(
				Integer.valueOf(courseId), Integer.valueOf(parsedComponentId),
				Integer.valueOf(parsedContentId), questionTitle, null,
				Integer.valueOf(questionDuration), 2000);
		return Integer.valueOf(key);

	}

	@RequestMapping(value = "/addLearnerNote", method = RequestMethod.POST)
	public @ResponseBody
	Integer addLearnerNote(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "noteTitle", required = true) String noteTitle,
			@RequestParam(value = "noteDescription", required = false) String noteDescription,
			@RequestParam(value = "noteDuration", required = true) String noteDuration) {

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;

		Node node = new Node();
		String parsedNodeType = nodeId.split("_")[0];

		if (parsedNodeType.equals("LCONTENT")) {
			parsedContentId = nodeId.split("_")[3];
			parsedComponentId = nodeId.split("_")[2];

		} else if (parsedNodeType.equals("LCOMPONENT")) {
			parsedComponentId = nodeId.split("_")[1];

		} else if (parsedNodeType.equals("COURSE")) {

		}

		int key = subscriptionService.addLearnerContent(
				Integer.valueOf(courseId), Integer.valueOf(parsedComponentId),
				Integer.valueOf(parsedContentId), noteTitle, noteDescription,
				Integer.valueOf(noteDuration), 1000);
		System.out.println(" THE ERROR ....KEY IS  " + key);
		return Integer.valueOf(key);

	}

	@RequestMapping(value = "/deleteLearnerContent", method = RequestMethod.POST)
	public @ResponseBody
	Integer deleteLearnerContent(
			@RequestParam(value = "contentId", required = true) String noteId) {

		return Integer.valueOf(subscriptionService.deleteLearnerContent(Integer
				.valueOf(noteId)));

	}

	@RequestMapping(value = "/editLearnerContent", method = RequestMethod.POST)
	public @ResponseBody
	Integer editLearnerContent(
			@RequestParam(value = "contentId", required = true) String noteId,
			@RequestParam(value = "contentTitle", required = true) String title,
			@RequestParam(value = "contentDuration", required = true) String duration,
			@RequestParam(value = "contentDescription", required = false) String desc) {

		return Integer.valueOf(subscriptionService.editLearnerContent(
				Integer.valueOf(noteId), desc, Integer.parseInt(duration),
				title));

	}

	@RequestMapping(value = "/addEducatorNote", method = RequestMethod.POST)
	public @ResponseBody
	Integer addEducatorNote(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "contentType", required = true) String contentType,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "title", required = true) String noteTitle,
			@RequestParam(value = "description", required = false) String noteDescription,
			@RequestParam(value = "duration", required = true) String noteDuration,
			@RequestParam(value = "url", required = true) String url,
			@RequestParam(value = "coordinates", required = true) String coordinates) {
		// add_educator_content(content_type, course_id, node_id, duration,
		// title, description, coordinates, url){

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;

		Node node = new Node();
		String parsedNodeType = nodeId.split("_")[0];

		if (parsedNodeType.equals("LCONTENT")) {
			parsedContentId = nodeId.split("_")[3];
			parsedComponentId = nodeId.split("_")[2];

		} else if (parsedNodeType.equals("LCOMPONENT")) {
			parsedComponentId = nodeId.split("_")[1];

		} else if (parsedNodeType.equals("COURSE")) {

		}

		int key = subscriptionService.addEducatorContent(
				Integer.valueOf(courseId), Integer.valueOf(parsedComponentId),
				Integer.valueOf(parsedContentId), Integer.valueOf(contentType),
				noteDescription, url, coordinates,
				Integer.valueOf(noteDuration),noteTitle );

		System.out.println(" THE ERROR ....KEY IS  " + key);
		System.out.println(" content id is  " + parsedContentId);
		System.out.println(" component id is  " + parsedComponentId);
		
		return Integer.valueOf(key);

	}

	@RequestMapping(value = "/deleteEducatorContent", method = RequestMethod.POST)
	public @ResponseBody
	Integer deleteEducatoContent(
			@RequestParam(value = "eduContentEnrichId", required = true) String eduContentEnrichId) {

		return Integer.valueOf(subscriptionService
				.deleteEducatorContent(Integer.valueOf(eduContentEnrichId)));

	}
	
	
	@RequestMapping(value = "/editEducatoContent", method = RequestMethod.POST)
	public @ResponseBody
	Integer editEducatoContent(
			@RequestParam(value = "eduContentEnrichId", required = true) String eduContentEnrichId,
			@RequestParam(value = "title", required = true) String noteTitle,
			@RequestParam(value = "description", required = false) String noteDescription,
			@RequestParam(value = "duration", required = true) String noteDuration,
			@RequestParam(value = "url", required = true) String url,
			@RequestParam(value = "coordinates", required = true) String coordinates
			) {

		return Integer.valueOf(subscriptionService
				.editEducatorContent(Integer.valueOf(eduContentEnrichId), noteDescription, url, coordinates, Integer.valueOf(noteDuration), noteTitle));

	}

	
	
	
	
	
	
	
	@RequestMapping(value = "/enrichplayer/{courseId}/{componentId}/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView  enrichPlayer(@PathVariable String courseId,
			@PathVariable String componentId,
			@PathVariable String contentId
			) {

		
		ModelAndView mv = new ModelAndView("courses/enrich_player");
		mv.addObject("courseId",   courseId);
		mv.addObject("componentId", componentId);
		mv.addObject("contentId", contentId);
		
		Content content = contentService.getContent(Integer.valueOf(contentId));
		mv.addObject("content", content);
				

		return mv;
		

	}

}
