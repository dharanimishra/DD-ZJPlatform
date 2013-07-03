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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.json.JSONLearningContent;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.EnrichContentService;
import com.ziksana.service.security.MediaService;
import com.ziksana.util.JSONUtil;

@Controller
@RequestMapping("/zcourse")
public class EnhanceContentController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnhanceContentController.class);
	
	@Value("#{pagination['associate_content_items_per_page']}")
	private String itemsPerPage;

	@Autowired
	EnrichContentService enrichContentService;

	@Autowired
	MediaService mediaService;

	MediaServerURL mediaServerURL = new MediaServerURL();
	@RequestMapping(value = "/1/enhancecontents/{courseId}", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showEnrichContent(@PathVariable Integer courseId) {
		LOGGER.debug("Entered showEnrichContent(): ");
		ModelAndView modelView = new ModelAndView("enhancecontent");
		modelView.addObject("itemsPerPage", itemsPerPage);
		try {

			if (courseId > 0) { 
				modelView.addObject("courseId", courseId);
				enrichContentService.getCourse(courseId);
				Boolean isModuleExists = enrichContentService
						.isModuleExist(courseId);
				LOGGER.debug("Module Size= >" + isModuleExists);
				if (isModuleExists) {
					Integer memberId = Integer.valueOf(SecurityTokenUtil
							.getToken().getMemberPersonaId().getStorageID());
					List<LearningContent> learningContents = enrichContentService
							.getLearningContents(memberId);
					List<JSONLearningContent> jsonLearningContentlList = getJSONLearningContentObjects(learningContents);
					String jsonString = JSONUtil
							.objectToJSONString(jsonLearningContentlList);

					modelView.addObject("learningContentAsJSONString",
							jsonString);

					mediaServerURL = mediaService.getMediaContents();
					modelView.addObject("ms", mediaServerURL);
				} else {
					return new ModelAndView("redirect:/zcourse/createcourse/"
							+ courseId + "");
				}
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
		}
		return modelView;
	}

	public ModelAndView annotateContent(){
		LOGGER.debug("In AnnotateContentController.annotateContent()");
		return null;
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
