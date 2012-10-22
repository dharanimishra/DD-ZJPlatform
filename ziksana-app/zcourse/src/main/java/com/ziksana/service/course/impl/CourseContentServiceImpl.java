package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseDetails;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentContentDetails;
import com.ziksana.domain.course.LearningComponentDetails;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.exception.course.CourseException;
import com.ziksana.persistence.course.LearningComponentContentMapper;
import com.ziksana.persistence.course.LearningContentMapper;
import com.ziksana.persistence.course.LearningContentPartsMapper;
import com.ziksana.service.course.CourseContentService;

public class CourseContentServiceImpl implements CourseContentService {
	
	private static Logger logger = Logger.getLogger(CourseContentServiceImpl.class);
	
	@Autowired
	public LearningComponentContentMapper compContentMapper;
	@Autowired
	public LearningContentMapper contentMapper;
	@Autowired
	public LearningContentPartsMapper contentPartsMapper;
	
	
	public void saveOrUpdateContent(Course course,
			ContentType contentType, LearningComponentContent compContent)
			throws CourseException {
		
		CourseDetails 					courseDetails	 				= null;
		List<LearningComponent> 		learningComponentList	 		= null;
		LearningComponentDetails 		lCompDetails 					= null;
		List<LearningComponentContent> 	learningCompContentList 		= null;
		LearningComponentContentDetails contentDetails 					= null; 

		
		List<LearningComponent> 		savedLearningComponentList	 	= new ArrayList<LearningComponent>();
		LearningComponentContent 		savedlearningComponentContent 	= null;
		//LearningContentParts 			savedLearningContentParts 		= null; 
		LearningContent 				savedLearningContent 			= null;
		//List<LearningContentParts> 		savedContentParts 				= new ArrayList<LearningContentParts>();
		//List<LearningComponentContent> 	savedLearningCompContentList 	=  new ArrayList<LearningComponentContent>();
		//LearningComponent				savedLearningComponent 			= null;
		CourseDetails 					savedCourseDetails				= new CourseDetails();
		Course 							savedCourse 					= new Course();
		//LearningComponentDetails 		savedLCDetails					= new LearningComponentDetails();
		List<LearningContentParts> 		contentParts 					= null;
		courseDetails = course.getCourseDetails();
		
		if(courseDetails == null){
			throw new CourseException("CourseDetails is cannot be null");
		}

		learningComponentList = courseDetails.getLearningComponents();
			
		if(learningComponentList!=null && learningComponentList.size()>0){
			
			logger.debug("Learning Components list size ::"+learningComponentList.size());
				
			for (LearningComponent learningComponent : learningComponentList) {
				//savedLearningComponent = new LearningComponent();
				lCompDetails = learningComponent.getLearningComponentDetails();
					
				if(lCompDetails==null){
					throw new CourseException("LearningComponentDetails is cannot be null");
				}
						
				learningCompContentList = lCompDetails.getLearningCompContentList();
						
				for (LearningComponentContent learningComponentContent : learningCompContentList) {
							
					savedlearningComponentContent = new LearningComponentContent();
							
					learningComponentContent.setLearningComponent(learningComponent);
					
					logger.debug("Before saving the LearningComponentContent ...");							
					savedlearningComponentContent = compContentMapper.saveLearningComponentContent(learningComponentContent);
					logger.debug("After saving the LearningComponentContent ...: "+savedlearningComponentContent.toString());
					
					contentDetails = learningComponentContent.getLearrningComponentContentDetails();
							
					LearningContent learningContent = contentDetails.getLearningContent();
							
					if(learningContent!=null){
								
						learningContent.setBaseComponentContent(savedlearningComponentContent);
								
						logger.debug("Before saving the LearningContent ...");
						contentMapper.save(learningContent);
								
						contentParts =  learningContent.getAllLearningContentParts();
								
						if(contentParts!=null && contentParts.size()>0){
									
							logger.debug("Learning Content Parts list size ::"+contentParts.size());
							for (LearningContentParts learningContentParts : contentParts) {
										
								learningContentParts.setLearningContent(savedLearningContent);
										
								contentPartsMapper.save(learningContentParts);
										
								//savedContentParts.add(savedLearningContentParts);
							}
						}
	/*					try {
								//savedLearningContent.setLearningContentParts(savedContentParts);
						} catch (Exception e) {
						}
	*/							
					}
					//savedlearningComponentContent.setBaseLearningContent(savedLearningContent);
					//savedLearningCompContentList.add(savedlearningComponentContent);
				}
/*				try {
					//savedLCDetails.setLearningCompContentList(savedLearningCompContentList);
				} catch (Exception e) {
					throw new CourseException("Error saving");
				}
					
				//savedLearningComponent.setLearningComponentDetails(savedLCDetails);
*/			}
				
			//savedLearningComponentList.add(savedLearningComponent);
		}
		
		try {
			savedCourseDetails.setLearningComponents(savedLearningComponentList);
			savedCourse.setCourseDetails(savedCourseDetails);
			
		} catch (Exception e) {
			//error log
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
				
				contentPartsMapper.save(learningContentParts);
			}
		}
	}			
	
}
