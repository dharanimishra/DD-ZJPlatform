package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.NestTreeNode;
import com.ziksana.domain.course.Planner;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.course.CourseNestTreeService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.PlannerService;

@Controller
@RequestMapping("/zcourse/")
public class CoursePlannerController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CoursePlannerController.class);

	@Autowired
	CourseNestTreeService courseNestTreeService;

	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private CourseService courseService;

	private String courseIcon = "/ziksana-web/resources/images/tree_icons/course.png";
	private String chapterIcon = "/ziksana-web/resources/images/tree_icons/chapter.png";
	private String parentIcon = "/ziksana-web/resources/images/tree_icons/chapter.png";
	private String videoIcon = "/ziksana-web/resources/images/tree_icons/video.png";
	private String audioIcon = "/ziksana-web/resources/images/tree_icons/audio.png";
	private String folderClosed = "/ziksana-web/resources/images/tree_icons/folderClosed.gif";
	private String folderOpen = "/ziksana-web/resources/images/tree_icons/folderOpen.gif";
	private String pptIcon = "/ziksana-web/resources/images/tree_icons/powerpoint.png";
	private String docIcon = "/ziksana-web/resources/images/tree_icons/word.png";
	private String excelIcon = "/ziksana-web/resources/images/tree_icons/excel.png";
	private String pdfIcon = "/ziksana-web/resources/images/tree_icons/pdf.png";
	private String imageIcon = "/ziksana-web/resources/images/tree_icons/image.png";
	private String noteIcon = "/ziksana-web/resources/images/tree_icons/note.png";
	private String linkIcon = "/ziksana-web/resources/images/tree_icons/link.png";

	@RequestMapping(value = "1/planner/{courseId}", method = { RequestMethod.GET })
	public @ResponseBody
	ModelAndView getCoursePlannerDetails(@PathVariable String courseId) {
		LOGGER.debug("Entering showTreenode(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("mastercourseplanner");

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.debug("showTreenode():  courseIds :" + courseIds);
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
				break;
			}
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			Course course = courseService.getCourseByCourseId(courseIds);
			
			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);
			modelView.addObject("courseIds", courseIds);
			modelView.addObject("course", course);
			modelView.addObject("parentIcon", parentIcon);
			modelView.addObject("courseIcon", courseIcon);
			modelView.addObject("chapterIcon", chapterIcon);
			modelView.addObject("docIcon", docIcon);
			modelView.addObject("pdfIcon", pdfIcon);
			modelView.addObject("pptIcon", pptIcon);
			modelView.addObject("videoIcon", videoIcon);
			modelView.addObject("linkIcon", linkIcon);
			modelView.addObject("noteIcon", noteIcon);
			modelView.addObject("imageIcon", imageIcon);
			modelView.addObject("audioIcon", audioIcon);
			modelView.addObject("excelIcon", excelIcon);
			modelView.addObject("folderClosed", folderClosed);
			modelView.addObject("folderOpen", folderOpen);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showMyTreenode(): " + courseId);
		return modelView;

	}

	@RequestMapping(value = "1/{courseId}/viewplanner", method = { RequestMethod.GET })
	public @ResponseBody
	ModelAndView getCoursePlannerChartDetails(@PathVariable String courseId) {
		LOGGER.debug("Entering showTreenode(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("masterviewplanner");

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.debug("showTreenode():  courseIds :" + courseIds);
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
				break;
			}
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			List<Planner> plannerList = plannerService
					.getPlannerByCourseId(Integer.parseInt(courseId));

			for (Planner planner : plannerList) {
				String course_id = (planner.getCourseId() != null) ? planner
						.getCourseId().toString() : "";
				String component_id = (planner.getLearningComponentId() != null) ? planner
						.getLearningComponentId().toString() : "";
				String content_id = (planner.getLearningContentId() != null) ? planner
						.getLearningContentId().toString() : "";
				planner.setNodeUniqueId(construct_node_unique_id(course_id,
						component_id, content_id));
			}

			modelView.addObject("parentList", treeNodeList);
			modelView.addObject("courseIds", courseIds);
			modelView.addObject("plannerList", plannerList);
			modelView.addObject("parentIcon", parentIcon);
			modelView.addObject("courseIcon", courseIcon);
			modelView.addObject("chapterIcon", chapterIcon);
			modelView.addObject("docIcon", docIcon);
			modelView.addObject("pdfIcon", pdfIcon);
			modelView.addObject("pptIcon", pptIcon);
			modelView.addObject("videoIcon", videoIcon);
			modelView.addObject("linkIcon", linkIcon);
			modelView.addObject("noteIcon", noteIcon);
			modelView.addObject("imageIcon", imageIcon);
			modelView.addObject("audioIcon", audioIcon);
			modelView.addObject("excelIcon", excelIcon);
			modelView.addObject("folderClosed", folderClosed);
			modelView.addObject("folderOpen", folderOpen);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showMyTreenode(): " + courseId);
		return modelView;

	}

	public String construct_node_unique_id(String course_id,
			String componenet_id, String content_id) {

		String node_unique_id = "";
		if (course_id != "") {
			node_unique_id += "course-" + course_id;
		}
		if (componenet_id != "") {
			node_unique_id += "_component-" + componenet_id;
		}
		if (content_id != "") {
			node_unique_id += "_content-" + content_id;
		}

		return node_unique_id;
	}

	@RequestMapping(value = "1/getplannerlist/{courseId}", method = { RequestMethod.GET })
	public @ResponseBody
	List<Planner> getPlanner(@PathVariable String courseId) {
		List<Planner> plannerList = new ArrayList<Planner>();
		try {
			plannerList = plannerService.getPlannerByCourseId(Integer
					.parseInt(courseId));
			for (Planner planner : plannerList) {
				String course_id = (planner.getCourseId() != null) ? planner
						.getCourseId().toString() : "";
				String component_id = (planner.getLearningComponentId() != null) ? planner
						.getLearningComponentId().toString() : "";
				String content_id = (planner.getLearningContentId() != null) ? planner
						.getLearningContentId().toString() : "";
				planner.setNodeUniqueId(construct_node_unique_id(course_id,
						component_id, content_id));
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return plannerList;
	}

	@RequestMapping(value = "1/submitplanner")
	public String submitCoursePlannerDetails(HttpServletRequest request) {

		String response = null;

		String nodeId = null;
		String startWeek = null;
		String startday = null;
		String startsAt = null;
		String duration = null;
		String note = null;
		String courseId = request.getParameter("course_id");
		LOGGER.info("courseId==>" + courseId);
		// course_"+node.getCourseId()+"_component'
		String components[] = request.getParameterValues("course_" + courseId
				+ "_component");
		
		List<Planner> plannerList = new ArrayList<Planner>();
		Planner planner = new Planner();
		
		if (courseId != null) {

			planner.setNodeId(courseId);

			planner.setCourseId(Integer.parseInt(courseId));

			plannerList.add(planner);
			if (components != null) {

				for (String component : components) {
					planner = new Planner();

					LOGGER.info("Component==>" + component);
					planner.setCourseId(Integer.parseInt(courseId));
					planner.setLearningComponentId(Integer.parseInt(component));

					// 0_course_"+course_id+"_component_"+component_id+"";
					nodeId = request.getParameter("0_course_" + courseId
							+ "_component_" + component + "");
					System.out.println(nodeId);
					if (nodeId != null) {
						if ("".equals(nodeId)) {
							planner.setId(0);

						} else {
							planner.setId(Integer.parseInt(nodeId));
						}
					}

					startWeek = request.getParameter("course_" + courseId
							+ "_component_" + component + "_startweek");
					if (!"".equals(startWeek) && startWeek != null) {

						planner.setStartWeek(startWeek);
					}

					startday = request.getParameter("course_" + courseId
							+ "_component_" + component + "_startday");
					if (!"".equals(startday) && startday != null) {

						planner.setStartDay(startday);
					}
					duration = request.getParameter("course_" + courseId
							+ "_component_" + component + "_duration");
					if (!"".equals(duration) && duration != null) {

						planner.setDuration(Integer.parseInt(duration));
					}
					startsAt = request.getParameter("course_" + courseId
							+ "_component_" + component + "_starts_at");
					if (!"".equals(startsAt) && startsAt != null) {

						planner.setStartsAt(startsAt);
					}

					note = request.getParameter("course_" + courseId
							+ "_component_" + component + "_note");
					if (!"".equals(note) && note != null) {

						planner.setNote(note);
					}
					plannerList.add(planner);
				
					String contents[] = request
							.getParameterValues("course_" + courseId
									+ "_component_" + component + "_content");
					if (contents != null) {
						for (String content : contents) {
							planner = new Planner();
							LOGGER.info("Content==>" + content);
							planner.setCourseId(Integer.parseInt(courseId));
							planner.setLearningComponentId(Integer
									.parseInt(component));
							planner.setLearningContentId(Integer
									.parseInt(content));

							// 0_course_"+course_id+"_component_"+component_id+"";
							nodeId = request.getParameter("0_course_"
									+ courseId + "_component_" + component
									+ "_content_" + content + "");
							System.out.println(nodeId);
							if (nodeId != null) {
								if ("".equals(nodeId)) {
									planner.setId(0);

								} else {
									planner.setId(Integer.parseInt(nodeId));
								}
							}

							startWeek = request.getParameter("course_"
									+ courseId + "_component_" + component
									+ "_content_" + content + "_startweek");
							if (!"".equals(startWeek) && startWeek != null) {
								planner.setStartWeek(startWeek);
							}

							startday = request.getParameter("course_"
									+ courseId + "_component_" + component
									+ "_content_" + content + "_startday");
							if (!"".equals(startday) && startday != null) {
								planner.setStartDay(startday);
							}
							duration = request.getParameter("course_"
									+ courseId + "_component_" + component
									+ "_content_" + content + "_duration");
							if (!"".equals(duration) && duration != null) {
								planner.setDuration(Integer.parseInt(duration));
							}
							startsAt = request.getParameter("course_"
									+ courseId + "_component_" + component
									+ "_content_" + content + "_starts_at");
							if (!"".equals(startsAt) && startsAt != null) {

								planner.setStartsAt(startsAt);
							}
							note = request.getParameter("course_" + courseId
									+ "_component_" + component + "_content_"
									+ content + "_note");
							if (!"".equals(note) && note != null) {
								planner.setNote(note);
							}
							plannerList.add(planner);
							
						}
					}
				}
				// Save or Update Operation
				List<Planner> updatePlannerList = plannerService
						.getPlannerByCourseId(Integer.parseInt(courseId));
				if (updatePlannerList.size() == 0) {
					plannerService.savePlanner(plannerList);
					response = "redirect:/zcourse/1/"
							+ Integer.parseInt(courseId) + "/viewplanner";

				} else {

					for (Planner currentList : plannerList) {

						if (currentList.getId() != null
								&& currentList.getId() == 0) {

							plannerService.savePlannerPojo(currentList);

						} else {
							plannerService.updatePlanner(currentList);
						}

					}

					response = "redirect:/zcourse/1/"
							+ Integer.parseInt(courseId) + "/viewplanner";
				}

				
			}
		}

		return response;

	}

}