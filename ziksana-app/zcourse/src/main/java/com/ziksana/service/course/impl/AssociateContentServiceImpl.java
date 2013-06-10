package com.ziksana.service.course.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.service.course.AssociateContentService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.LearningComponentContentService;
import com.ziksana.service.course.LearningComponentService;
import com.ziksana.service.course.LearningContentService;


@Service
public class AssociateContentServiceImpl implements AssociateContentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(AssociateContentServiceImpl.class);
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	LearningComponentContentService learningComponentContentService;
	
	@Autowired
	LearningContentService learningContentService;
	
	@Autowired
	LearningComponentService learningComponentService;
	
	
	
	public List<LearningContent> getLearningContents(Integer authMemberRoleId) {
		return learningContentService.getUserContent(authMemberRoleId);
	}

	public LearningContent getLearningContent(Integer learningContentId) {
		return learningContentService.getLearningContent(learningContentId);
	}


	public void associateContents(Integer authMemberRoleId, Integer courseId, Integer learningComponentId, String learningContentsToBeAssociated) {
		List<LearningComponentContent> learningComponentContents = getLearningComponentContents(authMemberRoleId, courseId, learningComponentId, learningContentsToBeAssociated);
		learningComponentContentService.saveLearningComponentContents(learningComponentContents);
		
	}

	public Course getCourse(Integer courseId) {
		return courseService.getCourseByCourseId(courseId);
	}
	/**
	 * A helper method to get learning component content objects
	 * @param courseId
	 * @param learningComponentId
	 * @param learningContentsToBeAssociated
	 * @return
	 */
	private List<LearningComponentContent> getLearningComponentContents(Integer authMemberRoleId, Integer courseId, Integer learningComponentId, String learningContentsToBeAssociated){
		
		String[] contentIdArray = learningContentsToBeAssociated.split(",");
		
		List<LearningComponentContent> learningComponentContentList = new ArrayList<LearningComponentContent>();
		
		Course course = getCourse(courseId);
		LearningComponent learningComponent = learningComponentService.getLearningComponent(learningComponentId);
		
		for (String stringContentId : contentIdArray) {
			
			LearningContent learningContent = getLearningContent(Integer.parseInt(stringContentId));
			LearningComponentContent learningComponentContent = new LearningComponentContent();
			learningComponentContent.setActive(true);
			//learningComponentContent.setCompContentType(ComponentContentType.PREVIEW_CONTENT);
			//learningComponentContent.setCompContentTypeId(ComponentContentType.PREVIEW_CONTENT.getID());
			//TODO how we will insert the component content description. Inserting content description is wrong as the length of the column for content is 4800 and for learningcomponentcontent is 45.
			//learningComponentContent.setContentDescription(learningContent.getContentDescription());
			learningComponentContent.setCourseStatus(course.getCourseStatus());
			//learningComponentContent.setCourseStatusId(course.getCourseStatus().getID());
			
			//componentContent.setCreatedBy(memberId);
			learningComponentContent.setCreatedOn(new Date());
			learningComponentContent.setCreationDate(new Date());
			learningComponentContent.setLearningComponent(learningComponent);
			learningComponentContent.setBaseLearningContent(learningContent);
			//set learning component content details
			//componentContent.setModifiedBy(modifiedBy);
			learningComponentContent.setModifiedOn(new Date());
			//componentContent.setSynchronizeWithVideo(synchronizeWithVideo);
			learningComponentContentList.add(learningComponentContent);
		}
		
		
		
		return learningComponentContentList;
	}

	public void unAssociateContent(Integer learningComponentId, Integer learningContentId) {
		LearningComponentContent learningComponentContent = learningComponentContentService.getLearningComponentContent(learningComponentId, learningContentId);
		learningComponentContent.setDeleted(true);
		learningComponentContentService.deleteLearningComponentContent(learningComponentContent);
	}

	public boolean isModuleExist(Integer courseId) {
		Integer result = courseService.isModuleExists(courseId);
		Boolean exists = false;
		if(result > 0){
			exists = true;
		}
		else{
			exists = false;
		}
		return exists;
	}

	public void updateAssociation(
			Integer learningComponentId, Integer previousLearningContentId,
			Integer newLearningContentId) {
		
		LearningComponentContent oldLearningComponentContent = learningComponentContentService.getLearningComponentContent(learningComponentId, previousLearningContentId);
		learningComponentContentService.deleteLearningComponentContent(oldLearningComponentContent);
		
		LearningContent newlearningContent = learningContentService.getLearningContent(newLearningContentId);
		LearningComponentContent newLearningComponentContent = (LearningComponentContent) copy(oldLearningComponentContent);
		newLearningComponentContent.setId(null);
		newLearningComponentContent.setBaseLearningContent(newlearningContent);
		learningComponentContentService.saveLearningComponentContent(newLearningComponentContent);
		LOGGER.debug("AssociateContentServiceImpl.updateAssociation() - associating updated successfully for learning component id " + learningComponentId + " old content id was " + previousLearningContentId + " and new learning content id is " + newLearningContentId);
	}
	
	/**
     * Returns a copy of the object, or null if the object cannot
     * be serialized.
     */
	//TODO move to a utility class
    public static Object copy(Object orig) {
        Object obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(orig);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return obj;
    }
    
      
}
