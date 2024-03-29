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
import com.ziksana.domain.course.ContentDecorationType;
import com.ziksana.domain.course.ContentStatus;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.json.JSONLearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.EnrichContentService;
import com.ziksana.service.security.MediaService;
import com.ziksana.util.JSONUtil;

@Controller
@RequestMapping("/zcourse")
public class AnnotateContentController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AnnotateContentController.class);
	
	@Value("#{pagination['associate_content_items_per_page']}")
	private String itemsPerPage;

	@Autowired
	EnrichContentService enrichContentService;

	@Autowired
	MediaService mediaService;

	MediaServerURL mediaServerURL = new MediaServerURL();
	@RequestMapping(value = "/1/annotatecontents/{courseId}", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showEnrichContent(@PathVariable Integer courseId) {
		LOGGER.debug("Entered showEnrichContent(): ");
		ModelAndView modelView = new ModelAndView("annotatecontent");
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
					return new ModelAndView("redirect:/zcourse/createmodule/COURSE_"
							+ courseId);
				}
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
		}
		return modelView;
	}

	@RequestMapping(value = "1/annotate", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	void createContent(
			@RequestParam(value = "previousLearningContentId", required = true) Integer previousLearningContentId,
			@RequestParam(value = "learningComponentId", required = true) Integer learningComponentId,
			@RequestParam(value = "contentPath", required = true) String contentPath,
			@RequestParam(value = "decorationTypeName", required = true) String decorationTypeName,
			@RequestParam(value = "thumbnailPath", required = true) String thumbnailPath,
			@RequestParam(value = "noOfThumbnails", required = true) Integer noOfThumbnails) {


		try {
			MemberPersona creator = new MemberPersona();
			creator.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));

			LearningContent previousLearningContent = enrichContentService.getLearningContent(previousLearningContentId);
				LearningContent learningContent = new LearningContent();
				learningContent.setAuthoringMember(creator);
				learningContent.setContentName(previousLearningContent.getContentName());
				learningContent.setContentPath(contentPath);
				//TODO need to pass the correct value here
				learningContent.setStatusId(ContentStatus.UNDER_CONSTRUCTION.getID());
				learningContent.setActive(true);
				learningContent.setContentTypeId(previousLearningContent.getContentTypeId());
				learningContent.setContentType(previousLearningContent.getContentType());
				learningContent.setThumbnailPicturePath(thumbnailPath);
				learningContent.setNumberOfThumbnails(noOfThumbnails);
				learningContent.setRightsOwningMember(creator);
				learningContent.setLinkedLearningContent(previousLearningContent);
				learningContent.setContentFormat(previousLearningContent.getContentFormat());
				learningContent.setContentFormatId(previousLearningContent.getContentFormatId());
				learningContent.setContentDescription(previousLearningContent.getContentDescription());
				learningContent.setScreenshotPath(previousLearningContent.getScreenshotPath());
				enrichContentService.createLearningContent(learningContent, 
						getDecorationTypeList(decorationTypeName.toUpperCase()), creator, 
						learningComponentId, previousLearningContent);
				
				LOGGER.debug("AnnotateContentController.createContent() new learning content created for " + decorationTypeName);
		} catch (ZiksanaException  exception) {
			LOGGER.error(exception.getMessage(), exception);	
		}
	}
	
	private List<ContentDecorationType> getDecorationTypeList(String decorationTypesAsString){
		List<ContentDecorationType> decorationTypeList = new ArrayList<ContentDecorationType>();
		if(decorationTypesAsString != null && !"".equals(decorationTypesAsString.trim())){
			String[] types = decorationTypesAsString.split(",");
			for (String decorationType : types) {
				if(decorationType != null && !"".equals(decorationType.trim())){
					decorationTypeList.add(ContentDecorationType.getValueOf(decorationType.toUpperCase()));
				}
				else{
					LOGGER.debug("RecordContentController.getDecorationTypeList() wrong value received for decoration type");
				}
			}
		}
		else{
			LOGGER.error("The decoration type is required to save the content");
			//for now putting it as annotated
			decorationTypeList.add(ContentDecorationType.getValueOf("Annotated".toUpperCase()));
		}
		return decorationTypeList;
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
	@RequestMapping(value = "/1/annotator", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView annotateContent() {
		ModelAndView modelAndView = new ModelAndView("courses/annotator"); 
		return modelAndView;

	}

}
