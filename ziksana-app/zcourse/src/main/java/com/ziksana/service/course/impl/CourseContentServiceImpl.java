package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDeleteType;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.exception.course.CourseException;
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
		
		List<LearningContentParts> 		contentParts 					= null;
		
		if(learningComponentContent == null){
			throw new CourseException("LearningComponentContent cannot be null");
		}
						
		if(learningComponentContent.getLearningComponent() == null){
			throw new CourseException("Parent LearningComponent cannot be null");
		}

		LearningContent learningContent = learningComponentContent.getBaseLearningContent();
							
		if(learningContent == null){
			throw new CourseException("Learning Content cannot be null");
		}
								
		logger.debug("Before saving the LearningContent ...");
		contentMapper.save(learningContent);
		logger.debug("After saving the LearningContent ID...:"+learningContent.getLearningContentId());
		
		contentParts =  learningContent.getAllLearningContentParts();
								
		if(contentParts!=null && contentParts.size()>0){
									
			logger.debug("Learning Content Parts list size ::"+contentParts.size());
			
			for (LearningContentParts learningContentParts : contentParts) {
								
					learningContentParts.setLearningContent(learningContent);
											
					contentMapper.save(learningContentParts);
			}
		}
		
		learningComponentContent.setBaseLearningContent(learningContent);
		
		logger.debug("Before saving the LearningComponentContent ...");							
		compContentMapper.saveLearningComponentContent(learningComponentContent);
		logger.debug("After saving the LearningComponentContent ...: "+learningComponentContent.getLearningComponentContentId());
					
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
		
		LearningContent					learningContent				= null;
		List<LearningContentParts> 		contentPartsList 			= null;
		
		if(compContent == null){
			throw new CourseException("Learning Component Content cannot be null");
		}
		
				
		//Enhanced LearningContent
		learningContent = compContent.getBaseLearningContent();

		if(learningContent==null){
			throw new CourseException("Learning Content cannot be null");
		}
		
		//associate parent content as a linked content
		learningContent.setLinkedLearningContent(learningContent);
		
		logger.debug("Before saving the LearningContent ");
		
		contentMapper.save(learningContent);
		
		logger.debug("After saving the LearningContent ID:"+learningContent.getLearningContentId());
		
		contentPartsList = learningContent.getAllLearningContentParts();
				
		if(contentPartsList!=null && contentPartsList.size()>0){
			
			logger.debug("Learning Content Parts list size : "+contentPartsList.size());
					
			for (LearningContentParts learningContentParts : contentPartsList) {
				
				logger.debug("Before saving the LearningContentParts ");
				
				learningContentParts.setLearningContent(learningContent);
				
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
		contentList = new ArrayList<LearningContent>();
		
		logger.debug("Member role ID : "+memberRoleId);

		contentList = contentMapper.getListOfContentsByMemberRoleId(memberRoleId);
		
		logger.debug("Learning Content List : "+contentList.size());
		
		return contentList;
	}

	@Transactional
	@Override
	public void deleteContent(LearningContentDeleteType deleteType,
			Integer learningContentId) throws CourseException {
		
		Boolean 			isDelete 				= true;
		List<Integer>       learningContentIdList  	= null;
		
		logger.debug("Learning Content Delete Params {:DeleteType :"+deleteType+" , LearningContent ID : "+learningContentId);
		
		if(deleteType.getID() == 1){
			
			contentMapper.updateContent(isDelete, learningContentId);
			
		}else if(deleteType.getID() == 2){
			
			learningContentIdList = contentMapper.getLearningContetPartsByContentId(learningContentId);
			
			for (Integer learningContentPartsId : learningContentIdList) {
				
				contentMapper.updateContentParts(isDelete,learningContentPartsId);
				
			}
			
		}else if(deleteType.getID() == 3){
			
			learningContentIdList = contentMapper.getLearningContetPartsByContentId(learningContentId);
			
			for (Integer learningContentPartsId : learningContentIdList) {
				
				contentMapper.updateContentParts(isDelete,learningContentPartsId);
				
			}
			contentMapper.updateContent(isDelete, learningContentId);
		}
		
	}			
	
}
