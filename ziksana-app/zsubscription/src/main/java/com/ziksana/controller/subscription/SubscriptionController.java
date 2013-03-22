package com.ziksana.controller.subscription;

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

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.EducatorContent;
import com.ziksana.domain.course.EducatorNote;
import com.ziksana.domain.course.Hotspot;
import com.ziksana.domain.course.Node;
import com.ziksana.domain.course.Reference;
import com.ziksana.domain.course.subscription.ContentReference;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.data.ContentService;
import com.ziksana.service.security.MediaService;
import com.ziksana.service.subscription.SubscriptionService;

/**
 * @author prabu
 * 
 */
@Controller
@RequestMapping("/subscription")
public class SubscriptionController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SubscriptionController.class);

	@Autowired
	private SubscriptionService subscriptionService;

	@Autowired
	private ContentService contentService;

	@Autowired
	private MediaService mediaService;

	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "/getlearnernotes", method = RequestMethod.GET)
	public @ResponseBody
	List<Note> showLearnerNotes(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId) {

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;
		List<Note> notes = null;

		try {
			Node node = new Node();
			String parsedNodeType = nodeId.split("_")[0];

			if (parsedNodeType.equals("LCONTENT")) {
				parsedContentId = nodeId.split("_")[3];
				parsedComponentId = nodeId.split("_")[2];

			} else if (parsedNodeType.equals("LCOMPONENT")) {
				parsedComponentId = nodeId.split("_")[1];

			} else if (parsedNodeType.equals("COURSE")) {

			}
			notes = subscriptionService.getLearnerNotes(
					Integer.valueOf(courseId),
					Integer.valueOf(parsedComponentId),
					Integer.valueOf(parsedContentId), 1000);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return notes;
	}

	@RequestMapping(value = "/getlearnerquestions", method = RequestMethod.GET)
	public @ResponseBody
	List<Note> showLearnerQuestions(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId) {

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;
		List<Note> notes = null;

		try {
			Node node = new Node();
			String parsedNodeType = nodeId.split("_")[0];

			if (parsedNodeType.equals("LCONTENT")) {
				parsedContentId = nodeId.split("_")[3];
				parsedComponentId = nodeId.split("_")[2];

			} else if (parsedNodeType.equals("LCOMPONENT")) {
				parsedComponentId = nodeId.split("_")[1];

			} else if (parsedNodeType.equals("COURSE")) {

			}
			notes = subscriptionService.getLearnerNotes(
					Integer.valueOf(courseId),
					Integer.valueOf(parsedComponentId),
					Integer.valueOf(parsedContentId), 2000);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return notes;
	}

	@RequestMapping(value = "/educatornotes", method = RequestMethod.GET)
	public @ResponseBody
	List<EducatorNote> showEducatorNotes(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {
		List<EducatorNote> educatorNotes = null;
		try {
			Node node = new Node();
			String parsedNodeId = nodeId.split("_")[3];
			String parsedParentNodeId = parentNodeId.split("_")[1];
			node.setId(Integer.valueOf(parsedNodeId));
			// node.setType(Integer.valueOf(nodeType));
			Node parent = new Node();
			parent.setId(Integer.valueOf(parsedParentNodeId));
			// parent.setType(Integer.valueOf(parentNodeType));
			node.setParent(parent);

			educatorNotes = subscriptionService.getEducatorNotes(
					Integer.valueOf(courseId), node);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return educatorNotes;
	}

	// Get Hotspot
	@RequestMapping(value = "/gethotspot", method = RequestMethod.GET)
	public @ResponseBody
	List<EducatorNote> showHotspotNotes(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {

		List<EducatorNote> educatorNotes = null;
		try {
			Node node = new Node();
			String parsedNodeId = nodeId.split("_")[3];
			String parsedParentNodeId = parentNodeId.split("_")[1];
			node.setId(Integer.valueOf(parsedNodeId));
			// node.setType(Integer.valueOf(nodeType));
			Node parent = new Node();
			parent.setId(Integer.valueOf(parsedParentNodeId));
			// parent.setType(Integer.valueOf(parentNodeType));
			node.setParent(parent);
			educatorNotes = subscriptionService.getHotspotNotes(
					Integer.valueOf(courseId), node);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		return educatorNotes;
	}

	@RequestMapping(value = "/educatorreferences", method = RequestMethod.GET)
	public @ResponseBody
	List<Reference> showEducatorReferences(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {
		List<Reference> references = null;
		try {
			Node node = new Node();
			String parsedNodeId = nodeId.split("_")[3];
			String parsedParentNodeId = parentNodeId.split("_")[1];
			node.setId(Integer.valueOf(parsedNodeId));
			// node.setType(Integer.valueOf(nodeType));
			Node parent = new Node();
			parent.setId(Integer.valueOf(parsedParentNodeId));
			// parent.setType(Integer.valueOf(parentNodeType));
			node.setParent(parent);
			references = subscriptionService.getEducatorSuggestedReferences(
					Integer.valueOf(courseId), node);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return references;
	}

	@RequestMapping(value = "/getalleducatorcontent", method = RequestMethod.GET)
	public @ResponseBody
	List<EducatorContent> getAllEducatorContent(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "componentId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {
		List<EducatorContent> educatorContents = null;
		try {
			Node node = new Node();
			String parsedNodeId = nodeId.split("_")[3];
			// String parsedParentNodeId = parentNodeId.split("_")[1];
			node.setId(Integer.valueOf(parsedNodeId));
			// node.setType(Integer.valueOf(nodeType));
			Node parent = new Node();
			parent.setId(Integer.valueOf(parentNodeId));
			// parent.setType(Integer.valueOf(parentNodeType));
			node.setParent(parent);

			educatorContents = subscriptionService.getAllEducatorContent(
					Integer.valueOf(courseId), node);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return educatorContents;

	}

	@RequestMapping(value = "/getcontenttoc", method = RequestMethod.GET)
	public @ResponseBody
	List<ContentReference> showContentReferences(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = false) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {
		List<ContentReference> contentReferences = null;
		try {
			Node node = new Node();
			String parsedNodeId = nodeId.split("_")[3];
			String parsedParentNodeId = nodeId.split("_")[2];
			node.setId(Integer.valueOf(parsedNodeId));
			// node.setType(Integer.valueOf(nodeType));
			Node parent = new Node();
			parent.setId(Integer.valueOf(parsedParentNodeId));
			// parent.setType(Integer.valueOf(parentNodeType));
			node.setParent(parent);

			contentReferences = subscriptionService.getContentTOC(
					Integer.valueOf(courseId), node);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return contentReferences;
	}

	@RequestMapping(value = "/educatorhotspots", method = RequestMethod.GET)
	public @ResponseBody
	List<Hotspot> showEducatorHotspots(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "parentNodeId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {

		List<Hotspot> hotspots = null;
		try {
			Node node = new Node();
			String parsedNodeId = nodeId.split("_")[3];
			String parsedParentNodeId = parentNodeId.split("_")[1];
			node.setId(Integer.valueOf(parsedNodeId));
			// node.setType(Integer.valueOf(nodeType));
			Node parent = new Node();
			parent.setId(Integer.valueOf(parsedParentNodeId));
			// parent.setType(Integer.valueOf(parentNodeType));
			node.setParent(parent);

			// this code should be modified to call getEducatorHotspots()
			// TODO
			hotspots = subscriptionService.getEducatorHotspots(
					Integer.valueOf(courseId), node);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return hotspots;
	}

	@RequestMapping(value = "/addlearnerquestion", method = RequestMethod.POST)
	public @ResponseBody
	Integer addLearnerQuestion(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "questionTitle", required = true) String questionTitle,
			@RequestParam(value = "questionDuration", required = true) String questionDuration) {

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;

		int key = 0;
		try {
			Node node = new Node();
			String parsedNodeType = nodeId.split("_")[0];

			if (parsedNodeType.equals("LCONTENT")) {
				parsedContentId = nodeId.split("_")[3];
				parsedComponentId = nodeId.split("_")[2];

			} else if (parsedNodeType.equals("LCOMPONENT")) {
				parsedComponentId = nodeId.split("_")[1];

			} else if (parsedNodeType.equals("COURSE")) {

			}

			key = subscriptionService.addLearnerContent(
					Integer.valueOf(courseId),
					Integer.valueOf(parsedComponentId),
					Integer.valueOf(parsedContentId), questionTitle, null,
					Integer.valueOf(questionDuration), 2000);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return Integer.valueOf(key);

	}

	@RequestMapping(value = "/addlearnernote", method = RequestMethod.POST)
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

		int key = 0;
		try {
			Node node = new Node();
			String parsedNodeType = nodeId.split("_")[0];

			if (parsedNodeType.equals("LCONTENT")) {
				parsedContentId = nodeId.split("_")[3];
				parsedComponentId = nodeId.split("_")[2];

			} else if (parsedNodeType.equals("LCOMPONENT")) {
				parsedComponentId = nodeId.split("_")[1];

			} else if (parsedNodeType.equals("COURSE")) {

			}

			key = subscriptionService.addLearnerContent(
					Integer.valueOf(courseId),
					Integer.valueOf(parsedComponentId),
					Integer.valueOf(parsedContentId), noteTitle,
					noteDescription, Integer.valueOf(noteDuration), 1000);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug(" THE ERROR ....KEY IS  " + key);
		return Integer.valueOf(key);
	}

	@RequestMapping(value = "/deletelearnercontent", method = RequestMethod.POST)
	public @ResponseBody
	Integer deleteLearnerContent(
			@RequestParam(value = "contentId", required = true) String noteId) {

		int returnVal = 0;
		try {
			returnVal = Integer.valueOf(subscriptionService
					.deleteLearnerContent(Integer.valueOf(noteId)));
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return returnVal;

	}

	@RequestMapping(value = "/editlearnercontent", method = RequestMethod.POST)
	public @ResponseBody
	Integer editLearnerContent(
			@RequestParam(value = "contentId", required = true) String noteId,
			@RequestParam(value = "contentTitle", required = true) String title,
			@RequestParam(value = "contentDuration", required = true) String duration,
			@RequestParam(value = "contentDescription", required = false) String desc) {

		int returnVal = 0;
		try {
			returnVal = Integer.valueOf(subscriptionService
					.deleteLearnerContent(Integer.valueOf(noteId)));
			Integer.valueOf(subscriptionService.editLearnerContent(
					Integer.valueOf(noteId), desc, Integer.parseInt(duration),
					title));
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return returnVal;

	}

	@RequestMapping(value = "/addeducatornote", method = RequestMethod.POST)
	public @ResponseBody
	Integer addEducatorNote(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "contentType", required = true) String contentType,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "title", required = true) String noteTitle,
			@RequestParam(value = "description", required = false) String noteDescription,
			@RequestParam(value = "duration", required = true) String noteDuration,
			@RequestParam(value = "parentId", required = false) String parentId,
			@RequestParam(value = "url", required = true) String url,
			@RequestParam(value = "coordinates", required = true) String coordinates) {
		// add_educator_content(content_type, course_id, node_id, duration,
		// title, description, coordinates, url){

		String parsedContentId = null;
		String parsedComponentId = null;
		String parsedCourseId = courseId;
		int key = 0;

		try {
			Node node = new Node();
			String parsedNodeType = nodeId.split("_")[0];

			if (parsedNodeType.equals("LCONTENT")) {
				parsedContentId = nodeId.split("_")[3];
				parsedComponentId = nodeId.split("_")[2];

			} else if (parsedNodeType.equals("LCOMPONENT")) {
				parsedComponentId = nodeId.split("_")[1];

			} else if (parsedNodeType.equals("COURSE")) {

			}

			key = subscriptionService.addEducatorContent(
					Integer.valueOf(courseId),
					Integer.valueOf(parsedComponentId),
					Integer.valueOf(parsedContentId),
					Integer.valueOf(contentType), noteDescription, url,
					coordinates, Integer.valueOf(noteDuration), noteTitle,
					Integer.valueOf(parentId));

			LOGGER.debug(" THE ERROR ....KEY IS  " + key);
			LOGGER.debug(" content id is  " + parsedContentId);
			LOGGER.debug(" component id is  " + parsedComponentId);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		return Integer.valueOf(key);

	}

	@RequestMapping(value = "/deleteeducatorcontent", method = RequestMethod.POST)
	public @ResponseBody
	Integer deleteEducatoContent(
			@RequestParam(value = "eduContentEnrichId", required = true) String eduContentEnrichId,
			@RequestParam(value = "contentType", required = false) String contentType) {
		Integer response = 1, enrichId = 0, linkType = 0, resp = 0, dbresp = 1;

		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :deleteEducatorContent(String deleteEducatorContent,String contentType): eduContentEnrichId"
				+ eduContentEnrichId + "contentType" + contentType);

		try {
			enrichId = Integer.parseInt(eduContentEnrichId);
			LOGGER.debug("Class :" + getClass()
					+ "Method deleteEducatorContent(eduContentEnrichId):enrichId"
					+ enrichId);
			if (contentType.equalsIgnoreCase("TOC")) {
				linkType = 7;
				LOGGER.debug("content type is TOC and setting link type to :"+ linkType);
			}
			if (linkType == 7) {
				enrichId = Integer.parseInt(eduContentEnrichId);
				EducatorContent educatorContent = subscriptionService
						.getEducatorTOCByContentEnrichId(enrichId);
				if (enrichId > 0) {
					List<EducatorContent> tocList = subscriptionService
							.getEducatorTOCByParentEnrichId(enrichId);
					for (EducatorContent toc : tocList) {
						if (toc.getParentId() > 0) {
							List<EducatorContent> tocList1 = subscriptionService
									.getEducatorTOCByParentEnrichId(toc.getId());
							LOGGER.debug("Class :"
									+ getClass()
									+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC ParentId"
									+ toc.getId());
							for (EducatorContent toc1 : tocList1) {
								if (toc1.getParentId() > 0) {
									List<EducatorContent> tocList2 = subscriptionService
											.getEducatorTOCByParentEnrichId(toc1
													.getId());
									LOGGER.debug("Class :"
											+ getClass()
											+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC1 ParentId"
											+ toc1.getId());
									for (EducatorContent toc2 : tocList2) {
										if (toc2.getParentId() > 0) {
											List<EducatorContent> tocList3 = subscriptionService
													.getEducatorTOCByParentEnrichId(toc2
															.getId());
											LOGGER.debug("Class :"
													+ getClass()
													+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC2 ParentId"
													+ toc2.getParentId());
											for (EducatorContent toc3 : tocList3) {
												if (toc3.getParentId() > 0) {

													List<EducatorContent> tocList4 = subscriptionService
															.getEducatorTOCByParentEnrichId(toc3
																	.getId());
													LOGGER.debug("Class :"
															+ getClass()
															+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC3 ParentId"
															+ toc3.getId());

													for (EducatorContent toc4 : tocList4) {
														if (toc4.getParentId() > 0) {

															List<EducatorContent> tocList5 = subscriptionService
																	.getEducatorTOCByParentEnrichId(toc4
																			.getId());
															LOGGER.debug("Class :"
																	+ getClass()
																	+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC5 ParentId"
																	+ toc4.getId());
															for (EducatorContent toc5 : tocList5) {
																if (toc5.getParentId() > 0) {
																	resp = subscriptionService
																			.deleteEducatorContent(toc5
																					.getId());
																	LOGGER.debug("Class :"
																			+ getClass()
																			+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC5 resp"
																			+ resp
																			+ ": toc5.getId()"
																			+ toc5.getId());

																}
																LOGGER.debug("Class :"
																		+ getClass()
																		+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC5 List"
																		+ toc5);
															}

															resp = subscriptionService
																	.deleteEducatorContent(toc4
																			.getId());
															LOGGER.debug("Class :"
																	+ getClass()
																	+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC4 resp"
																	+ resp
																	+ ": toc4.getId()"
																	+ toc4.getId());
														}
														LOGGER.debug("Class :"
																+ getClass()
																+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC4 List"
																+ toc4);
													}
													resp = subscriptionService
															.deleteEducatorContent(toc3
																	.getId());

													LOGGER.debug("Class :"
															+ getClass()
															+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC3 resp"
															+ resp
															+ ": toc3.getId()"
															+ toc3.getId());
												}
												LOGGER.debug("Class :"
														+ getClass()
														+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC3 List"
														+ toc3);

											}

											resp = subscriptionService
													.deleteEducatorContent(toc2
															.getId());
											LOGGER.debug("Class :"
													+ getClass()
													+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC2 resp"
													+ resp + ": toc2.getId()"
													+ toc2.getId());
										}

										LOGGER.debug("Class :"
												+ getClass()
												+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC2 List"
												+ toc2);

									}
									resp = subscriptionService
											.deleteEducatorContent(toc1.getId());
									LOGGER.debug("Class :"
											+ getClass()
											+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC1 resp"
											+ resp + ": toc1.getId()"
											+ toc1.getId());
								}

							}

							resp = subscriptionService.deleteEducatorContent(toc
									.getId());
							LOGGER.debug("Class :"
									+ getClass()
									+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent: TOC :resp"
									+ resp + ": toc.getId()" + toc.getId());
						}
						LOGGER.debug("Class :"
								+ getClass()
								+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC List"
								+ toc);

					}
					resp = subscriptionService.deleteEducatorContent(enrichId);
					LOGGER.debug("Class :"
							+ getClass()
							+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC resp"
							+ resp);
				}
			} else {
				response = subscriptionService.deleteEducatorContent(enrichId);
			}
			LOGGER.debug("Exiting Class :"
					+ getClass()
					+ " Method Name :deleteEducatorContent(String deleteEducatorContent,String contentType): eduContentEnrichId"
					+ eduContentEnrichId + "contentType" + contentType
					+ "response :" + response);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		return dbresp;

	}

	@RequestMapping(value = "/editeducatorcontent", method = RequestMethod.POST)
	public @ResponseBody
	Integer editEducatoContent(
			@RequestParam(value = "id", required = true) String eduContentEnrichId,
			@RequestParam(value = "title", required = true) String noteTitle,
			@RequestParam(value = "description", required = false) String noteDescription,
			@RequestParam(value = "duration", required = true) String noteDuration,
			@RequestParam(value = "url", required = true) String url,
			@RequestParam(value = "parentId", required = false) String parentId,
			@RequestParam(value = "coordinates", required = true) String coordinates) {

		int returnVal = 0;
		try {
			returnVal = Integer.valueOf(subscriptionService.editEducatorContent(
					Integer.valueOf(eduContentEnrichId), noteDescription, url,
					coordinates, Integer.valueOf(noteDuration), noteTitle,
					Integer.valueOf(parentId)));
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return returnVal;

	}

	@RequestMapping(value = "/enrichplayer/{courseId}/{componentId}/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enrichPlayer(@PathVariable String courseId,
			@PathVariable String componentId, @PathVariable String contentId) {

		ModelAndView mv = new ModelAndView("courses/enrich_player");
		try {
			mv.addObject("courseId", courseId);
			mv.addObject("componentId", componentId);
			mv.addObject("contentId", contentId);

			Content content = contentService.getContent(Integer.valueOf(contentId));
			mv.addObject("content", content);
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return mv;

	}

	@RequestMapping(value = "/ev_enrichplayer/{courseId}/{componentId}/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView ev_enrichPlayer(@PathVariable String courseId,
			@PathVariable String componentId, @PathVariable String contentId) {

		ModelAndView mv = new ModelAndView("courses/ev_enrich_player");
		try {
			mv.addObject("courseId", courseId);
			mv.addObject("componentId", componentId);
			mv.addObject("contentId", contentId);

			Content content = contentService.getContent(Integer.valueOf(contentId));
			mv.addObject("content", content);
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return mv;

	}

}
