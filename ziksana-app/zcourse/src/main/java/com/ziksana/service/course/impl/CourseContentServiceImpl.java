package com.ziksana.service.course.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentContentDetails;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDeleteType;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.LearningComponentContentMapper;
import com.ziksana.persistence.course.LearningContentMapper;
import com.ziksana.service.course.CourseContentService;

public class CourseContentServiceImpl implements CourseContentService {
	
	private static Logger logger = Logger.getLogger(CourseContentServiceImpl.class);
	
	@Autowired
	public LearningComponentContentMapper compContentMapper;
	@Autowired
	public LearningContentMapper contentMapper;
	
	
	@Transactional
	@Override
	public void saveOrUpdateContent(LearningComponentContent learningComponentContent) throws CourseException {
		
		LearningComponentContentDetails contentDetails 					= null; 
		LearningComponentContent 		savedlearningComponentContent 	= null;
		LearningContent 				savedLearningContent 			= null;
		List<LearningContentParts> 		contentParts 					= null;
		
		if(learningComponentContent == null){
			throw new CourseException("LearningComponentContent cannot be null");
		}
						
		if(learningComponentContent.getLearningComponent() == null){
			throw new CourseException("Parent LearningComponent cannot be null");
		}

		
		savedlearningComponentContent = new LearningComponentContent();
							
		logger.debug("Before saving the LearningComponentContent ...");							
		savedlearningComponentContent = compContentMapper.saveLearningComponentContent(learningComponentContent);
		logger.debug("After saving the LearningComponentContent ...: "+savedlearningComponentContent.toString());
					
		contentDetails = learningComponentContent.getLearrningComponentContentDetails();
					
		if(contentDetails == null){
				throw new CourseException("LearningContentDetails cannot be null");
		}
							
		LearningContent learningContent = contentDetails.getLearningContent();
							
		if(learningContent == null){
			throw new CourseException("Learning Content cannot be null");
		}
								
		learningContent.setBaseComponentContent(savedlearningComponentContent);
								
		logger.debug("Before saving the LearningContent ...");
		contentMapper.save(learningContent);
								
		contentParts =  learningContent.getAllLearningContentParts();
								
		if(contentParts!=null && contentParts.size()>0){
									
		logger.debug("Learning Content Parts list size ::"+contentParts.size());
		for (LearningContentParts learningContentParts : contentParts) {
							
				learningContentParts.setLearningContent(savedLearningContent);
										
				contentMapper.save(learningContentParts);
										
		}
	}
}

	@Override
	public LearningComponentContent getLearningComponentContent(Course course)
			throws CourseException {
		return null;
	}

	@Override
	public List<LearningComponentContent> searchLearningComponentContent(
			String searchCriteria, LearningComponentContent compContent)
			throws CourseException {
		return null;
	}

	@Transactional
	@Override
	public void enhaceContent(
			LearningComponentContent compContent) throws CourseException {
		
		LearningComponentContentDetails compContentDetails 			= null;
		LearningContent					learningContent				= null;
		LearningContent 				linkedLearningContent 		= null;
		List<LearningContentParts> 		contentPartsList 			= null;
		
		if(compContent == null){
			throw new CourseException("Learning Component Content cannot be null");
		}
		
		compContentDetails = compContent.getLearrningComponentContentDetails();
			
		if(compContentDetails == null){
			throw new CourseException("Learning Component ContentDetails cannot be null");
		}
				
		//Enhanced LearningContent
		learningContent = compContentDetails.getLearningContent();

		if(learningContent==null){
			throw new CourseException("Learning Content cannot be null");
		}
		
		//Parent content which is enhanced
		linkedLearningContent =  learningContent.getLinkedLearningContent();
			
		//associate parent content as a linked content
		learningContent.setLinkedLearningContent(linkedLearningContent);
		
		logger.debug("Before saving the LearningContent ");
		
		contentMapper.save(learningContent);
		
		contentPartsList = learningContent.getAllLearningContentParts();
				
		if(contentPartsList!=null && contentPartsList.size()>0){
			
			logger.debug("Learning Content Parts list size : "+contentPartsList.size());
					
			for (LearningContentParts learningContentParts : contentPartsList) {
				
				logger.debug("Before saving the LearningContentParts ");
				
				contentMapper.save(learningContentParts);
			}
		}
	}

	@Override
	public List<LearningContent> getLearningContent(Integer memberRoleId)
			throws CourseException {
		
		List<LearningContent> contentList = null;
		
		if(memberRoleId == null){
			throw new CourseException("Member Role ID cannot be null ");
		}
		
		logger.debug("Member role ID : "+memberRoleId);

		contentList = contentMapper.getListOfContentsByMemberRoleId(memberRoleId);
		
		return contentList;
	}

	@Transactional
	@Override
	public void deleteContent(LearningContentDeleteType deleteType,
			ZID learningContentId) throws CourseException {
		
		Boolean 			isDelete 				= true;
		List<Integer>       learningContentIdList  	= null;
		
		if(LearningContentDeleteType.LEARNINGCONTENT.equals(new Integer(1))){
			
			contentMapper.deleteContent(isDelete, new Integer(learningContentId.getStorageID()));
			
		}else if(LearningContentDeleteType.LEARNINGCONTENT_PARTS.equals(new Integer(2))){
			
			learningContentIdList = contentMapper.getLearningContetPartsByContentId(new Integer(learningContentId.getStorageID()));
			
			for (Integer learningContentPartsId : learningContentIdList) {
				
				contentMapper.deleteContentParts(isDelete,learningContentPartsId);
				
			}
			contentMapper.deleteContent(isDelete, new Integer(learningContentId.getStorageID()));
		}
		
	}			
	
}
