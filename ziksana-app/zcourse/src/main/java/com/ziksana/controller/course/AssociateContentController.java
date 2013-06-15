package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.CourseJsonResponse;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.json.JSONLearningContent;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.AssociateContentService;
import com.ziksana.service.security.MediaService;
import com.ziksana.util.JSONUtil;

/**
 * @author Arvind Rathod
 */
@Controller
@RequestMapping("/zcourse")
public class AssociateContentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AssociateContentController.class);

	@Value("#{pagination['associate_content_items_per_page']}")
	private String itemsPerPage;

	@Autowired
	AssociateContentService associateContentService;

	@Autowired
	MediaService mediaService;

	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "/1/repositorycontents/{courseId}", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showAssociateContent(@PathVariable Integer courseId) {
		LOGGER.debug("Entering showAssociateCourse(): ");
		ModelAndView modelView = new ModelAndView("associatecontent");
		modelView.addObject("itemsPerPage", itemsPerPage);
		try {

			if (courseId > 0) { 
				modelView.addObject("courseId", courseId);
				associateContentService.getCourse(courseId);
				Boolean isModuleExists = associateContentService
						.isModuleExist(courseId);
				LOGGER.debug("Module Size= >" + isModuleExists);
				if (isModuleExists) {
					Integer memberId = Integer.valueOf(SecurityTokenUtil
							.getToken().getMemberPersonaId().getStorageID());
					List<LearningContent> learningContents = associateContentService
							.getLearningContents(memberId);
					List<JSONLearningContent> jsonLearningContentlList = getJSONLearningContentObjects(learningContents);
					String jsonString = JSONUtil
							.objectToJSONString(jsonLearningContentlList);

					modelView.addObject("learningContentAsJSONString",
							jsonString);

					mediaServerURL = mediaService.getMediaContents();
					modelView.addObject("ms", mediaServerURL);
				} else {
					return new ModelAndView("redirect:/zcourse/createmodule/COURSE_"
							+ courseId);
				}
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
		}
		return modelView;
	}

	@RequestMapping(value = "/1/associatecontent", method = { RequestMethod.POST })
	public @ResponseBody
	CourseJsonResponse associateContents(
			@RequestParam(value = "courseId", required = true) Integer courseId,
			@RequestParam(value = "learningComponentId", required = true) Integer learningComponentId,
			@RequestParam(value = "learningContentsToBeAssociated", required = true) String learningContentsToBeAssociated) {
		CourseJsonResponse courseJsonResponse = new CourseJsonResponse();
		Integer authMemberRoleId = Integer.valueOf(SecurityTokenUtil.getToken()
				.getMemberPersonaId().getStorageID());
		try {
			associateContentService.associateContents(authMemberRoleId, courseId, learningComponentId, learningContentsToBeAssociated);
			courseJsonResponse.setResponse("success");
	} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
			courseJsonResponse.setResponse("failed");
		}
		return courseJsonResponse;
	}



	@RequestMapping(value = "/1/unassociatecontent", method = RequestMethod.POST)
	public @ResponseBody
	CourseJsonResponse unAssociateContent(
			@RequestParam(value = "contentId", required = true) Integer contentId,
			@RequestParam(value = "courseId", required = true) Integer courseId,
			@RequestParam(value = "componentId", required = true) Integer componentId) {
		CourseJsonResponse jsonResponse = new CourseJsonResponse();
		try {
			associateContentService.unAssociateContent(componentId, contentId);
			LOGGER.debug("Un-Associated course " + courseId + " component "
					+ componentId + " content for " + contentId);
			jsonResponse.setId(courseId.toString());
			jsonResponse.setResponse("success");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
			jsonResponse.setResponse("Failed");
		}
		//showAssociateContent(courseId);
		return jsonResponse;

	}

	/**
	 * This method converts collection of {@link LearningContent} objects into
	 * {@link JSONLearningContent} objects
	 * 
	 * @param learningContentList
	 * @return
	 */
	private List<JSONLearningContent> getJSONLearningContentObjects(
			List<LearningContent> learningContentList) {
		List<JSONLearningContent> jsonLearningContentList = new ArrayList<JSONLearningContent>();
		for (LearningContent learningContent : learningContentList) {
			jsonLearningContentList
					.add(new JSONLearningContent(learningContent));
		}
		return jsonLearningContentList;

	}
}
