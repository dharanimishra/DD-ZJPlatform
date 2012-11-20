package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseAdditionalProperty;
import com.ziksana.domain.course.CourseContentSecurity;
import com.ziksana.domain.course.CourseDetails;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentDetails;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningObjectDeleteType;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CourseContentSecurityMapper;
import com.ziksana.persistence.course.CourseLearningComponentMapper;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.persistence.course.CoursePlaybookMapper;
import com.ziksana.persistence.course.CourseTagcloudMapper;
import com.ziksana.persistence.course.EnrichmentMapper;
import com.ziksana.persistence.course.LearningComponentContentMapper;
import com.ziksana.persistence.course.LearningComponentMapper;
import com.ziksana.persistence.course.LearningComponentNestMapper;
import com.ziksana.persistence.course.PlannerMapper;
import com.ziksana.persistence.course.SocializeMapper;
import com.ziksana.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private static Logger logger = Logger.getLogger(CourseServiceImpl.class);
	
	@Autowired
	public CourseMapper 					courseMapper;
	@Autowired
	public CourseTagcloudMapper 			tagCloudMapper;
	@Autowired
	public CourseContentSecurityMapper 		contSecurityMapper;
	@Autowired
	public LearningComponentMapper 			learningComponentMapper;
	@Autowired
	public LearningComponentNestMapper 		componentNestMapper;
	@Autowired
	public CourseLearningComponentMapper 	courseLComponentMapper;
	@Autowired
	public LearningComponentContentMapper 	learningComponentContentMapper;
	@Autowired
	public EnrichmentMapper					enrichMapper;
	@Autowired
	public PlannerMapper					plannerMapper;
	@Autowired
	public CoursePlaybookMapper				playbookMapper;
	@Autowired
	public SocializeMapper					socializeMapper;
	
	
	@Transactional
	@Override
	public Course saveOrUpdateCourse(Course course) throws CourseException {

		CourseContentSecurity 	contSecurity 	= null;
		List<CourseTagcloud> 	tagcloudList 	= null;
	
		tagcloudList = new ArrayList<CourseTagcloud>();

		contSecurity = course.getCourseContSecurity();

		if (course.getCourseId() != null) {
			// Update Operation
			System.out.println("Course Id : "+course.getCourseId());
			logger.debug("Course Id : "+course.getCourseId());
			
			tagcloudList = course.getCourseTagClouds();
			
			logger.debug("Before updating the Course ....");
			courseMapper.updateCourse(course);
			
			if(tagcloudList!=null && tagcloudList.size()>0){
				
				logger.debug("Course Tagcloud list size  : "+tagcloudList.size());
				
				for (CourseTagcloud courseTagcloud : tagcloudList) {
					
					courseTagcloud.setCourse(course);
					courseTagcloud.setCreatingMember(course
							.getAccountableMember());
					logger.debug("Before updating the Course Tagcloud ....");
					tagCloudMapper.update(courseTagcloud);
				}
			}
				
			if(contSecurity!=null){
				logger.debug("Before updating the Course Content Security ....");
				contSecurityMapper.update(contSecurity);
			}
		} else {
			Boolean isSecurity = false;
			// Insert/Save Operation
			logger.debug("Before saving the Course ....");
			courseMapper.saveCourse(course);
			logger.debug("After saving the Course ID....: "+course.getCourseId());
			
			tagcloudList = course.getCourseTagClouds();

			if (tagcloudList != null && tagcloudList.size() > 0) {
				
				logger.debug("Cours	e Tagcloud list size  : "+tagcloudList.size());
				for (CourseTagcloud courseTagcloud : tagcloudList) {

					courseTagcloud.setCourse(course);

					courseTagcloud.setCreatingMember(course
							.getAccountableMember());

					logger.debug("Before Saving the Course Content Security ....");
					tagCloudMapper.save(courseTagcloud);
				}
			}
			isSecurity = course.getSecurityIndicator();
			if(isSecurity){
				if (contSecurity != null) {
					contSecurity.setCourse(course);
					contSecurityMapper.save(contSecurity);
				}
			}

		}

		logger.debug("Saved Course :: "+course.toString());

		return course;
	}

	@Transactional
	@Override
	public Course saveOrUpadteCourseComponents(Course course) throws CourseException
	{
		if(course == null) {
			throw new CourseException("Course cannot be null");
		}

		CourseDetails 				courseDetails 			= null;
		List<LearningComponent> 	learningComponentList 	= null;
		LearningComponentDetails 	compDetails 			= null;
		LearningComponentNest 		compNest 				= null;
		CourseLearningComponent 	courseLComponent 		= null;
		
		//Save or Updates the course 
		saveOrUpdateCourse(course);
			
		courseDetails = course.getCourseDetails();
			
			if(courseDetails == null){
				throw new CourseException("Course Details cannot be null");
			}

			learningComponentList = courseDetails.getLearningComponents();
				
			if(learningComponentList!=null && learningComponentList.size()>0){

			logger.debug("LearningComponent list size  : "+learningComponentList.size());

			for (LearningComponent learningComponent : learningComponentList) {
						
					logger.debug("Before Saving the Learning Component ....");
					learningComponentMapper.saveLearningComponent(learningComponent);
					logger.debug("After Saving the CourseLearningComponent ID..: "+learningComponent.getLearningComponentId());
						
					compDetails =  learningComponent.getLearningComponentDetails();
						
					if(compDetails == null){
						throw new CourseException("Learning Component Details cannot be null");
					}
					courseLComponent = compDetails.getCourseLearningComponent();
						
					if(courseLComponent!=null){
						courseLComponent.setCourse(course);
							
						courseLComponent.setLearningComponent(learningComponent);
								
						logger.debug("Before Saving the CourseLearningComponent ....");
						courseLComponentMapper.save(courseLComponent);
					}
							
					compNest = compDetails.getLearningComponentNest();
					
					compNest.setNestLearningComponent(learningComponent);
							
					logger.debug("Before Saving the LearningComponentNest ....");

					componentNestMapper.save(compNest);
					
					logger.debug("After Saving the LearningComponentNest ....");
				}
		}
		return course;
	
	}

	
	@Override
	public Course getBaseCourseDetails(ZID courseId) throws CourseException {
		
		Course course = null;
	
		if(courseId == null){
			throw new CourseException("Course Id cannot be null");
		}
		
		logger.debug("Before retrieving the base course details ");
		
		course = courseMapper.getBaseCourseDetails(new Integer(courseId.getStorageID()));
		
		if(course!=null){
			
			logger.debug("Got the course details : "+course.toString());
		}

		return course;
	}

	
	@Override
	public List<Course> getListOfCourses(Integer memberPersonaId) throws CourseException {

		List<Course> 				courseList 					= null;
		courseList 		= new		ArrayList<Course>();
		Integer 					memberRoleId				= null;
		

		if(memberPersonaId==null){
			throw new CourseException(" MemberRoleID cannot be null");
		}
		
		logger.debug("MemberRoleID : "+memberPersonaId);
		
		courseList = courseMapper.getListOfCourses(memberRoleId);
		
		//newCourseList = getCourseProgress(courseList, memberPersonaId);
		
		return courseList;
	}

	/**
	 * construct the course progress based on the various steps(course component, content, enrich, assignment, planner, playbook and socialize)
	 * @param courseList
	 * @param memberRoleId
	 * @return
	 */
	private List<Course> getCourseProgress(List<Course> courseList, Integer memberRoleId){
		
		List<Course> newCourseList = null;
		Integer 					componentContentId 			= null;
		Integer 					learningContentId 			= null;
		Integer 					enrichId 					= null;
		int 						courseProgress 				= 0;
		Integer 					assignmentId	 			= null;
		List<CourseLearningComponent> couseCompList				= null;
		Boolean 					isContentExists				= false;
		Boolean 					isEnriched 					= false;
		Boolean 					isAssignmentExist			= false;
		Boolean 					isPlannerExists				= false;
		Boolean 					isPlaybookExists			= false;
		Boolean 					isSocialized				= false;
		Integer 						lCompId 					= null;
		Integer 					courseId 					= null;
		Integer 					learningPlannerId 			= null;
		Integer 					coursePlaybookId 			= null;
		Integer 					reviewProgressId 			= null;
		newCourseList 	= new 		ArrayList<Course>();
		
		if(courseList!=null && courseList.size()>0){
			
			logger.debug("Courses  size : "+courseList.size());
			logger.debug("Courses  size : "+courseList);
			LearningComponent component = null;
		
			for (Course course : courseList) {
				logger.debug("Courses   : "+course.toString());
				logger.debug("Courses   : "+course.getCourseId());
				courseId = course.getCourseId();

				couseCompList =courseLComponentMapper.getComponentByCourse(courseId);
				logger.debug("Course components size : "+couseCompList.size());
				if(couseCompList!=null){
					courseProgress = courseProgress +15;
					
					for (CourseLearningComponent courseLearningComp : couseCompList) {
						
						learningPlannerId = plannerMapper.isPlannerExists(null,new Integer(courseLearningComp.getCourseLearningComponentId().getStorageID()));
						
						if(learningPlannerId!=null){
							isPlannerExists = true;	
						}
						
						component = courseLearningComp.getLearningComponent();

						lCompId = component.getLearningComponentId();
						
						componentContentId = learningComponentContentMapper.getCompContentByLComponentId(lCompId);
						
						if(componentContentId != null){
							
							isContentExists = true;
							
							learningContentId = learningComponentContentMapper.getContentByLComponentId(lCompId);
							
							if(learningContentId!=null){
								
								enrichId = enrichMapper.getEnrichByContentIdOrComponentId(lCompId, learningContentId);
								
								if(enrichId!=null){
									
									isEnriched = true;
									assignmentId = courseMapper.checkAssignment(lCompId);
									
									if(assignmentId!=null){
										isAssignmentExist = true;
									}
								}
							}
						}
					}
						
					learningPlannerId = plannerMapper.isPlannerExists(courseId,null);
										if(learningPlannerId!=null){
						isPlannerExists = true;	
					}
					
					coursePlaybookId = playbookMapper.isPlaybookExists(courseId);
										if(coursePlaybookId!=null){
						isPlaybookExists = true;	
					}
										
					reviewProgressId = socializeMapper.isSocializeExists(courseId,memberRoleId);
					if(reviewProgressId!=null){
						isSocialized = true;	
					}
					
					if(isContentExists){
						courseProgress = courseProgress +15;
					}
					if(isEnriched){
						courseProgress = courseProgress +15;
					}
					if(isAssignmentExist){
						courseProgress = courseProgress +15;
					}
					if(isPlannerExists){
						courseProgress = courseProgress +15;
					}
					if(isPlaybookExists){
						courseProgress = courseProgress +15;
					}
					if(isSocialized){
						courseProgress = courseProgress +10;
					}
				}
				
				course.setCourseProgress(courseProgress);
				
				newCourseList.add(course);
				
			}
		}
		return newCourseList;
		
	}
	
	@Override
	public HashMap<String, List<String>> getCourseComponents(ZID courseId) {
		return null;
	}

	@Transactional
	@Override
	public void saveAdditionalCourseProperty(
			CourseAdditionalProperty courseAdditionalProperty)
			throws CourseException {
		
		if(courseAdditionalProperty == null){
			throw new CourseException("Course Additional Property cannot be null");
		}
		
		logger.debug("Before saving the Course Additional Information ... ");
		courseMapper.saveAddnlInfo(courseAdditionalProperty);
		
	}

	@Override
	public Course getCourseDetails(ZID courseId) throws CourseException {
		
		Course course = null;
		if(courseId == null){
			throw new CourseException("Course Id cannot be null");
		}
		
		course = courseMapper.getBaseCourseDetails(new Integer(courseId.getStorageID()));
		
		return course;
	}

	@Override
	public void removeCourse(Course course) {

	}

	@Override
	public List<LearningComponent> getLearningObjects(Integer memberRoleId)
			throws CourseException {
		List<LearningComponent> learningObjectList 	= null;
		Boolean 				isLearningObject 	= true;
		
		if(memberRoleId == null){
			throw new CourseException("Member Role ID cannot be null ");
		}
		
		logger.debug("Member role ID : "+memberRoleId);

		learningObjectList = learningComponentMapper.getLearningObjects(isLearningObject, memberRoleId);
		
		return learningObjectList;
	}

	@Override
	public LearningComponent getLearningObject(ZID learningComponentId)
			throws CourseException {
		
		LearningComponent 	learningObject 		= null;
		Boolean 			isLearningObject 	= true;
		if(learningComponentId == null){
			throw new CourseException("learningComponent ID cannot be null ");
		}
		
		learningObject = learningComponentMapper.getLearningObjectById(isLearningObject, new Integer(learningComponentId.getStorageID()));
		
		return learningObject;
	}

	@Transactional
	@Override
	public void deleteLearningObject(ZID learningComponentId,
			LearningObjectDeleteType deleteType) throws CourseException {
		
		Boolean 			isDelete 	= true;
		List<Integer> learningComponentContentIdList = null;
		if(LearningObjectDeleteType.LEARNINGOBJECT.equals(new Integer(1))){
			
			learningComponentMapper.delete(isDelete, new Integer(learningComponentId.getStorageID()));
			
		}else if(LearningObjectDeleteType.LEARNINGOBJECT_AND_CONTENTS.equals(new Integer(2))){
			isDelete = false;
			
			learningComponentContentIdList = learningComponentContentMapper.getLearningComponentContentByComponentId(new Integer(learningComponentId.getStorageID()),isDelete );
			
			for (Integer learningComponentContentId : learningComponentContentIdList) {
				
				learningComponentContentMapper.delete(learningComponentContentId,isDelete);
				
			}
			
			learningComponentMapper.delete(isDelete, new Integer(learningComponentId.getStorageID()));
			
		}
	}

	@Override
	public Map<Object, Object> getCourseComponentsToPublish(
			Integer memberRoleId) throws CourseException {
		
		
	/*	 Map componentsMap = null;
		 
		 componentsMap = new HashMap();
		 
		List<LearningComponent> learningObjectList =  getLearningObjects(memberRoleId);
		
		componentsMap.put(CourseComponentType.LEARNING_OBJECT, learningObjectList);
*/		
		return null;
	}

}
