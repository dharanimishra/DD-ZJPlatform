package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
import com.ziksana.domain.course.ContentEnrichment;
import com.ziksana.domain.course.ContentStatus;
import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.EnrichmentType;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LinkSource;
import com.ziksana.domain.course.LinkType;
import com.ziksana.domain.course.json.JSONLearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.EnrichContentService;
import com.ziksana.service.security.MediaService;
import com.ziksana.util.JSONUtil;

@Controller
@RequestMapping("/zcourse")
public class EnrichContentController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnrichContentController.class);
	
	@Value("#{pagination['associate_content_items_per_page']}")
	private String itemsPerPage;

	@Autowired
	EnrichContentService enrichContentService;

	@Autowired
	MediaService mediaService;

	MediaServerURL mediaServerURL = new MediaServerURL();
	@RequestMapping(value = "/1/enrichcontents/{courseId}", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showEnrichContent(@PathVariable Integer courseId) {
		LOGGER.debug("Entered showEnrichContent(): ");
		ModelAndView modelView = new ModelAndView("enrichcontent");
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

	
	@RequestMapping(value = "1/enrich", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	void createContent(
			@RequestParam(value = "previousLearningContentId", required = true) Integer previousLearningContentId,
			@RequestParam(value = "learningComponentId", required = true) Integer learningComponentId,
			@RequestParam(value = "contentPath", required = true) String contentPath,
			@RequestParam(value = "decorationTypeName", required = true) String decorationTypes,
			@RequestParam(value = "thumbnailPath", required = true) String thumbnailPath,
			@RequestParam(value = "contentType", required = true) String contentType,
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
				ContentType contentTypeObject = ContentType.getValueOf(contentType.toUpperCase());
				learningContent.setContentTypeId(contentTypeObject.getID());
				learningContent.setContentType(contentTypeObject);
				learningContent.setThumbnailPicturePath(thumbnailPath);
				learningContent.setNumberOfThumbnails(noOfThumbnails);
				learningContent.setRightsOwningMember(creator);
				learningContent.setLinkedLearningContent(previousLearningContent);
				learningContent.setContentFormat(previousLearningContent.getContentFormat());
				learningContent.setContentFormatId(previousLearningContent.getContentFormatId());
				learningContent.setContentDescription(previousLearningContent.getContentDescription());
				learningContent.setScreenshotPath(previousLearningContent.getScreenshotPath());
				enrichContentService.createLearningContent(learningContent, 
						getDecorationTypeList(decorationTypes), creator, 
						learningComponentId, previousLearningContent);
				
				LOGGER.debug("RecordContentController.createContent() new learning content created for " + decorationTypes);
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
			//for now putting it as recorded but this is not full proof
			//decorationTypeList.add(ContentDecorationType.getValueOf("Annotated".toUpperCase()));
			decorationTypeList.add(ContentDecorationType.getValueOf("Recorded".toUpperCase()));
		}
		return decorationTypeList;
	}
	
	
	@RequestMapping(value = "/1/enricher/{courseId}/{learningComponentId}/{learningContentId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enrichContent(
			@PathVariable  Integer courseId,
			@PathVariable Integer learningComponentId,
			@PathVariable Integer learningContentId
			) {
		ModelAndView modelAndView = new ModelAndView("courses/enricher");
		Course course = enrichContentService.getCourse(courseId);
		LearningComponentContent learningComponentContent = enrichContentService.getLearningComponentContent(learningComponentId, learningContentId);
		MemberPersona creator = new MemberPersona();
		creator.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
				.getToken().getMemberPersonaId().getStorageID()));
		List<ContentEnrichment> contentEnrichmentList = enrichContentService.getEnrichments(course, learningComponentContent, creator);
		String jsonString = JSONUtil.objectToJSONString(contentEnrichmentList);
		modelAndView.addObject("enrichmentList", jsonString);
		return modelAndView;
	}

	@RequestMapping(value = "/1/enrichment/3", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	Boolean deleteEnrichment(
			@RequestParam(value = "jsonResponse", required = true) String jsonResponse,
			@RequestParam(value = "courseId", required = true) Integer courseId,
			@RequestParam(value = "learningContentId", required = true) Integer learningContentId,
			@RequestParam(value = "learningComponentId", required = true) Integer learningComponentId
			) {
		
		Boolean success = false;
		try {
			
			LearningComponentContent learningComponentContent = enrichContentService.getLearningComponentContent(learningComponentId, learningContentId);
			JSONObject jsonObject = new JSONObject(jsonResponse);
			String strEnrichmentID = jsonObject.getString("id");
			Integer contentEnrichmentId = -1;
			try {
				contentEnrichmentId = Integer.parseInt(strEnrichmentID);
			} catch (Exception e) {
				// TODO Log it
				e.printStackTrace();
			}
			if(contentEnrichmentId > 0){
				enrichContentService.deleteContentEnrichment(learningComponentContent, contentEnrichmentId);
				success = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	@RequestMapping(value = "/1/enrichment", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	Integer saveEnrichment(
			@RequestParam(value = "jsonResponse", required = true) String jsonResponse,
			@RequestParam(value = "courseId", required = true) Integer courseId,
			@RequestParam(value = "learningContentId", required = true) Integer learningContentId,
			@RequestParam(value = "learningComponentId", required = true) Integer learningComponentId
			) {
		
		Integer contentEnrichmentId = -1;
		try {
			
			Course course = enrichContentService.getCourse(courseId);
			LearningComponentContent learningComponentContent = enrichContentService.getLearningComponentContent(learningComponentId, learningContentId);
			MemberPersona creator = new MemberPersona();
			creator.setMemberRoleId(Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID()));
			ContentEnrichment contentEnrichment = getContentEnrichment(jsonResponse);
			if(contentEnrichment.getId() < 0){
				enrichContentService.saveContentEnrichment(course, learningComponentContent, contentEnrichment, creator);
			}
			else{
				enrichContentService.updateContentEnrichment(learningComponentContent, contentEnrichment);
			}
			contentEnrichmentId = contentEnrichment.getId();
		} catch (Exception e) {
			// TODO remove this later
			e.printStackTrace();
		}
		return contentEnrichmentId;
	}
	
	private ContentEnrichment getContentEnrichment(String jsonString) throws JSONException{

		JSONObject jsonObject = new JSONObject(jsonString);
		
		ContentEnrichment contentEnrichment = new ContentEnrichment();
		String strEnrichmentID = jsonObject.getString("id");
		Integer enrichmentId = -1;
		if(strEnrichmentID != null && !"".equals(strEnrichmentID.trim())){
			try {
				enrichmentId = Integer.parseInt(strEnrichmentID);
			} catch (NumberFormatException e) {
				// TODO remove this later
				e.printStackTrace();
			}
		}
		
		contentEnrichment.setId(enrichmentId);
		contentEnrichment.setActive(true);
		if(jsonObject.getString("coordinates") != null && !"".equals(jsonObject.getString("coordinates").trim()) ){
			contentEnrichment.setCoordinates(jsonObject.getString("coordinates"));
		}
		//contentEnrichment.setDuration(jsonObject.getString("duration"));
		if(jsonObject.getString("EndTime") != null && !"".equals(jsonObject.getString("EndTime").trim()) ){
			try {
				contentEnrichment.setEndTime(Double.parseDouble(jsonObject.getString("EndTime")));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				contentEnrichment.setEndTime(00.00d);
			}
		}
		if(jsonObject.getString("EnrichmentType") != null && !"".equals(jsonObject.getString("EnrichmentType").trim()) ){
			contentEnrichment.setEnrichmentType(EnrichmentType.getValueOf(jsonObject.getString("EnrichmentType").toUpperCase()));	
		}
		
		//contentEnrichment.setInternalIndicator(Boolean.parseBoolean(jsonObject.getString("InternalIndicator")));
		contentEnrichment.setIsDelete(false);
		if(jsonObject.getString("LinkDescription") != null && !"".equals(jsonObject.getString("LinkDescription").trim()) ){
			contentEnrichment.setLinkDescription(jsonObject.getString("LinkDescription"));
		}
		if(jsonObject.getString("LinkElement") != null && !"".equals(jsonObject.getString("LinkElement").trim()) ){
			contentEnrichment.setLinkElement(jsonObject.getString("LinkElement"));
		}
		//contentEnrichment.setLinkItemAuthor("");
		
		if(jsonObject.getString("LinkName") != null && !"".equals(jsonObject.getString("LinkName").trim()) ){
			contentEnrichment.setLinkName(jsonObject.getString("LinkName"));
		}
		//TODO what should be set here?
		contentEnrichment.setLinkSource(LinkSource.ZIKSANA_INTERNAL);
		contentEnrichment.setLinkType(LinkType.getValueOf("REFERENCE"));
		if(jsonObject.getString("StartTime") != null && !"".equals(jsonObject.getString("StartTime").trim()) ){
			try {
				contentEnrichment.setStartTime(Double.parseDouble(jsonObject.getString("StartTime")));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				contentEnrichment.setStartTime(00.00d);
			}
		}
		//contentEnrichment.setZeniSuggestedIndicator(null);
		return contentEnrichment;
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
