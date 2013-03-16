 
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
import com.ziksana.domain.course.Node;
import com.ziksana.domain.course.Reference;
import com.ziksana.domain.course.subscription.ContentReference;
import com.ziksana.domain.course.Hotspot;
import com.ziksana.domain.course.subscription.Note;
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

	private static final Logger logger = LoggerFactory
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

	@RequestMapping(value = "/getlearnerquestions", method = RequestMethod.GET)
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

	@RequestMapping(value = "/educatornotes", method = RequestMethod.GET)
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

	//Get Hotspot
	@RequestMapping(value = "/gethotspot", method = RequestMethod.GET)
	public @ResponseBody
	List<EducatorNote> showHotspotNotes(
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

		return subscriptionService.getHotspotNotes(Integer.valueOf(courseId),
				node);
	}
	
	
	@RequestMapping(value = "/educatorreferences", method = RequestMethod.GET)
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

	@RequestMapping(value = "/getalleducatorcontent", method = RequestMethod.GET)
	public @ResponseBody
	List<EducatorContent> getAllEducatorContent(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "nodeId", required = true) String nodeId,
			@RequestParam(value = "nodeType", required = false) String nodeType,
			@RequestParam(value = "componentId", required = true) String parentNodeId,
			@RequestParam(value = "parentNodeType", required = false) String parentNodeType) {

		Node node = new Node();
		String parsedNodeId = nodeId.split("_")[3];
		// String parsedParentNodeId = parentNodeId.split("_")[1];
		node.setId(Integer.valueOf(parsedNodeId));
		// node.setType(Integer.valueOf(nodeType));
		Node parent = new Node();
		parent.setId(Integer.valueOf(parentNodeId));
		// parent.setType(Integer.valueOf(parentNodeType));
		node.setParent(parent);

		return subscriptionService.getAllEducatorContent(
				Integer.valueOf(courseId), node);

	}

	@RequestMapping(value = "/getcontenttoc", method = RequestMethod.GET)
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

	@RequestMapping(value = "/educatorhotspots", method = RequestMethod.GET)
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

		// this code should be modified to call getEducatorHotspots()
		// TODO
		return subscriptionService.getEducatorHotspots(
				Integer.valueOf(courseId), node);
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

	@RequestMapping(value = "/deletelearnercontent", method = RequestMethod.POST)
	public @ResponseBody
	Integer deleteLearnerContent(
			@RequestParam(value = "contentId", required = true) String noteId) {

		return Integer.valueOf(subscriptionService.deleteLearnerContent(Integer
				.valueOf(noteId)));

	}

	@RequestMapping(value = "/editlearnercontent", method = RequestMethod.POST)
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
				Integer.valueOf(noteDuration), noteTitle,
				Integer.valueOf(parentId));

		System.out.println(" THE ERROR ....KEY IS  " + key);
		System.out.println(" content id is  " + parsedContentId);
		System.out.println(" component id is  " + parsedComponentId);

		return Integer.valueOf(key);

	}

	@RequestMapping(value = "/deleteeducatorcontent", method = RequestMethod.POST)
	public @ResponseBody
	Integer deleteEducatoContent(
			@RequestParam(value = "eduContentEnrichId", required = true) String eduContentEnrichId,
			@RequestParam(value = "contentType", required = false) String contentType) {
		Integer response = 1, enrichId = 0, linkType = 0, resp = 0, dbresp = 1;

		logger.debug("Entering Class :"
				+ getClass()
				+ " Method Name :deleteEducatorContent(String deleteEducatorContent,String contentType): eduContentEnrichId"
				+ eduContentEnrichId + "contentType" + contentType);

		try {
			enrichId = Integer.parseInt(eduContentEnrichId);
			logger.info("Class :"
					+ getClass()
					+ "Method deleteEducatorContent(eduContentEnrichId):enrichId"
					+ enrichId);
		} catch (NumberFormatException nfe) {
			logger.error("Class :"
					+ getClass()
					+ "Method deleteEducatorContent(eduContentEnrichId):NumberFormatException"
					+ nfe);
		}

		try {
			if (contentType.equalsIgnoreCase("TOC")) {
				linkType = 7;
				logger.info("Class :"
						+ getClass()
						+ "Method deleteEducatorContent(eduContentEnrichId):linkType"
						+ linkType);
			}

		} catch (Exception e) {
			linkType = 0;
			logger.error("Class :"
					+ getClass()
					+ "Method deleteEducatorContent(eduContentEnrichId):linkType"
					+ linkType);
		}
		if (linkType == 7) {
			enrichId = Integer.parseInt(eduContentEnrichId);
			EducatorContent educatorContent = subscriptionService
					.getEducatorTOCByContentEnrichId(enrichId);
			logger.info("Class :"
					+ getClass()
					+ "Method Name :deleteEducatorContent(eduContentEnrichId):enrichId"
					+ enrichId);
			try {
				if (enrichId > 0) {
					List<EducatorContent> tocList = subscriptionService
							.getEducatorTOCByParentEnrichId(enrichId);
					try {
						for (EducatorContent toc : tocList) {
							if (toc.getParentId() > 0) {
								List<EducatorContent> tocList1 = subscriptionService
										.getEducatorTOCByParentEnrichId(toc
												.getId());
								logger.info("Class :"
										+ getClass()
										+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC ParentId"
										+ toc.getId());
								try {
									for (EducatorContent toc1 : tocList1) {
										try {
											if (toc1.getParentId() > 0) {
												List<EducatorContent> tocList2 = subscriptionService
														.getEducatorTOCByParentEnrichId(toc1
																.getId());
												logger.info("Class :"
														+ getClass()
														+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC1 ParentId"
														+ toc1.getId());
												try {
													for (EducatorContent toc2 : tocList2) {
														if (toc2.getParentId() > 0) {
															List<EducatorContent> tocList3 = subscriptionService
																	.getEducatorTOCByParentEnrichId(toc2
																			.getId());
															logger.info("Class :"
																	+ getClass()
																	+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC2 ParentId"
																	+ toc2.getParentId());
															try {
																for (EducatorContent toc3 : tocList3) {
																	if (toc3.getParentId() > 0) {

																		List<EducatorContent> tocList4 = subscriptionService
																				.getEducatorTOCByParentEnrichId(toc3
																						.getId());
																		logger.info("Class :"
																				+ getClass()
																				+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC3 ParentId"
																				+ toc3.getId());

																		try {
																			for (EducatorContent toc4 : tocList4) {
																				if (toc4.getParentId() > 0) {

																					List<EducatorContent> tocList5 = subscriptionService
																							.getEducatorTOCByParentEnrichId(toc4
																									.getId());
																					logger.info("Class :"
																							+ getClass()
																							+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC5 ParentId"
																							+ toc4.getId());
																					try {
																						for (EducatorContent toc5 : tocList5) {
																							if (toc5.getParentId() > 0) {
																								resp = subscriptionService
																										.deleteEducatorContent(toc5
																												.getId());
																								logger.info("Class :"
																										+ getClass()
																										+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC5 resp"
																										+ resp
																										+ ": toc5.getId()"
																										+ toc5.getId());

																							}
																							logger.info("Class :"
																									+ getClass()
																									+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC5 List"
																									+ toc5);
																						}

																					} catch (Exception e) {
																						logger.info("Class :"
																								+ getClass()
																								+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent Exception TOC5"
																								+ e);
																					}

																					resp = subscriptionService
																							.deleteEducatorContent(toc4
																									.getId());
																					logger.info("Class :"
																							+ getClass()
																							+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC4 resp"
																							+ resp
																							+ ": toc4.getId()"
																							+ toc4.getId());
																				}
																				logger.info("Class :"
																						+ getClass()
																						+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC4 List"
																						+ toc4);
																			}

																		} catch (Exception e) {
																			logger.info("Class :"
																					+ getClass()
																					+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent Exception TOC4"
																					+ e);
																		}

																		resp = subscriptionService
																				.deleteEducatorContent(toc3
																						.getId());

																		logger.info("Class :"
																				+ getClass()
																				+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC3 resp"
																				+ resp
																				+ ": toc3.getId()"
																				+ toc3.getId());
																	}
																	logger.info("Class :"
																			+ getClass()
																			+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC3 List"
																			+ toc3);

																}

															} catch (Exception e) {
																logger.info("Class :"
																		+ getClass()
																		+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent Exception TOC3"
																		+ e);
															}

															resp = subscriptionService
																	.deleteEducatorContent(toc2
																			.getId());
															logger.info("Class :"
																	+ getClass()
																	+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC2 resp"
																	+ resp
																	+ ": toc2.getId()"
																	+ toc2.getId());
														}

														logger.info("Class :"
																+ getClass()
																+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC2 List"
																+ toc2);

													}
												} catch (Exception e) {
													logger.error("Class :"
															+ getClass()
															+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent Exception TOC2"
															+ e);
												}
												resp = subscriptionService
														.deleteEducatorContent(toc1
																.getId());
												logger.info("Class :"
														+ getClass()
														+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC1 resp"
														+ resp
														+ ": toc1.getId()"
														+ toc1.getId());
											}

										} catch (Exception e) {
											logger.info("Class :"
													+ getClass()
													+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent Exception :"
													+ e);
										}
										logger.info("Class :"
												+ getClass()
												+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC1 List"
												+ toc1);
									}

								} catch (Exception e) {
									logger.info("Class :"
											+ getClass()
											+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent List"
											+ e);
								}
								resp = subscriptionService
										.deleteEducatorContent(toc.getId());
								logger.info("Class :"
										+ getClass()
										+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent: TOC :resp"
										+ resp + ": toc.getId()" + toc.getId());
							}
							logger.info("Class :"
									+ getClass()
									+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent:TOC List"
									+ toc);

						}

					} catch (Exception e) {
						logger.error("Class :"
								+ getClass()
								+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent Exception :"
								+ e);
					}
					resp = subscriptionService.deleteEducatorContent(enrichId);
					logger.info("Class :"
							+ getClass()
							+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent TOC resp"
							+ resp);
				}
			} catch (Exception e) {
				logger.error("Class :"
						+ getClass()
						+ "Method Name :deleteEducatorContent(eduContentEnrichId):EducatorContent List Exception :"
						+ e);
			}

		} else {
			response = subscriptionService.deleteEducatorContent(enrichId);
		}
		logger.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :deleteEducatorContent(String deleteEducatorContent,String contentType): eduContentEnrichId"
				+ eduContentEnrichId + "contentType" + contentType
				+ "response :" + response);

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

		return Integer.valueOf(subscriptionService.editEducatorContent(
				Integer.valueOf(eduContentEnrichId), noteDescription, url,
				coordinates, Integer.valueOf(noteDuration), noteTitle,
				Integer.valueOf(parentId)));

	}

	@RequestMapping(value = "/enrichplayer/{courseId}/{componentId}/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enrichPlayer(@PathVariable String courseId,
			@PathVariable String componentId, @PathVariable String contentId) {

		ModelAndView mv = new ModelAndView("courses/enrich_player");
		mv.addObject("courseId", courseId);
		mv.addObject("componentId", componentId);
		mv.addObject("contentId", contentId);

		Content content = contentService.getContent(Integer.valueOf(contentId));
		mv.addObject("content", content);
		mediaServerURL = mediaService.getMediaContents();
		mv.addObject("ms", mediaServerURL);
		return mv;

	}

	@RequestMapping(value = "/ev_enrichplayer/{courseId}/{componentId}/{contentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView ev_enrichPlayer(@PathVariable String courseId,
			@PathVariable String componentId, @PathVariable String contentId) {

		ModelAndView mv = new ModelAndView("courses/ev_enrich_player");
		mv.addObject("courseId", courseId);
		mv.addObject("componentId", componentId);
		mv.addObject("contentId", contentId);

		Content content = contentService.getContent(Integer.valueOf(contentId));
		mv.addObject("content", content);
		mediaServerURL = mediaService.getMediaContents();
		mv.addObject("ms", mediaServerURL);
		return mv;

	}

}
