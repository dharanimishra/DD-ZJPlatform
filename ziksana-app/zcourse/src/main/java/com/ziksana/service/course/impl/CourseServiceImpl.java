package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.ziksana.domain.course.LearningProgram;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CourseContentSecurityMapper;
import com.ziksana.persistence.course.CourseLearningComponentMapper;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.persistence.course.CourseTagcloudMapper;
import com.ziksana.persistence.course.LearningComponentMapper;
import com.ziksana.persistence.course.LearningComponentNestMapper;
import com.ziksana.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private static Logger logger = Logger.getLogger(CourseServiceImpl.class);
	
	@Autowired
	public CourseMapper courseMapper;
	@Autowired
	public CourseTagcloudMapper tagCloudMapper;
	@Autowired
	public CourseContentSecurityMapper contSecurityMapper;
	@Autowired
	public LearningComponentMapper learningComponentMapper;
	@Autowired
	public LearningComponentNestMapper componentNestMapper;
	@Autowired
	public CourseLearningComponentMapper courseLComponentMapper;
	
	@Transactional
	@Override
	public Course saveOrUpdateCourse(Course course) throws CourseException {

		Course 					savedCourse 	= null;
		CourseContentSecurity 	contSecurity 	= null;
		ZID 					courseId 		= null;
		savedCourse = new Course();

		Course newCourse = new Course(course.getName(),
				course.getDescription(), course.getCourseStatus(),
				course.getCourseDuration(), course.getAccountableMember());

		courseId = course.getCourseId();

		List<CourseTagcloud> tagcloudList = null;
		contSecurity = course.getCourseContSecurity();

		if (courseId != null) {
			logger.debug("Course Id : "+courseId);
			// Update Operation
			tagcloudList = new ArrayList<CourseTagcloud>();
			
			logger.debug("Before updating the Course ....");
			savedCourse = courseMapper.updateCourse(course);
			
			if(tagcloudList!=null && tagcloudList.size()>0){
				
				logger.debug("Course Tagcloud list size  : "+tagcloudList.size());
				tagcloudList = tagCloudMapper.getCourseTagClouds(savedCourse.getCourseId()); 
				
				for (CourseTagcloud courseTagcloud : tagcloudList) {
					
					courseTagcloud.setCourse(course);
					courseTagcloud.setCreatingMember(course
							.getAccountableMember());
					
					logger.debug("Before updating the Course Tagcloud ....");
					tagCloudMapper.update(courseTagcloud);
				}
			}
				
			contSecurity = course.getCourseContSecurity();
			
			if(contSecurity!=null){
				logger.debug("Before updating the Course Content Security ....");
				contSecurityMapper.update(contSecurity);
			}
			
			logger.debug("Before updating the Course Indicators and associations ....");
			savedCourse = courseMapper.updateCourseInfo(savedCourse);

		} else {
			// Insert/Save Operation
			logger.debug("Before saving the Course ....");
			savedCourse = courseMapper.saveCourse(newCourse);

			tagcloudList = course.getCourseTagClouds();

			if (tagcloudList != null && tagcloudList.size() > 0) {
				
				logger.debug("Course Tagcloud list size  : "+tagcloudList.size());
				for (CourseTagcloud courseTagcloud : tagcloudList) {

					courseTagcloud.setCourse(savedCourse);

					courseTagcloud.setCreatingMember(newCourse
							.getAccountableMember());
					logger.debug("Before Saving the Course Content Security ....");
					tagCloudMapper.save(courseTagcloud);
				}
			}

			if (contSecurity != null) {
				contSecurityMapper.save(contSecurity);
			}

			if(savedCourse.getCourseId()!=null){
				logger.debug("Before updating the Course Indicators and associations ....");
				savedCourse = courseMapper.updateCourseInfo(savedCourse);
			}
		}

		logger.debug("Saved Course :: "+course.toString());

		return savedCourse;
	}

	@Override
	public Course saveOrUpadteCourseComponents(Course course) throws CourseException
	{
		if(course == null) {
			throw new CourseException("Course cannot be null");
		}

		Course 						savedCourse 			= null;
		CourseDetails 				courseDetails 			= null;
		LearningComponent 			savedComponent 			= null;
		List<LearningComponent> 	learningComponentList 	= null;
		LearningComponentDetails 	compDetails 			= null;
		ZID 						courseId 				= null;
		List<CourseTagcloud> 		tagcloudList 			= null;
		CourseContentSecurity 		contSecurity 			= null;
		LearningComponentNest 		compNest 				= null;
		CourseLearningComponent 	courseLComponent 		= null;
		savedComponent 				= new LearningComponent();
		
		Course newCourse = new Course(course.getName(),
				course.getDescription(), course.getCourseStatus(),
				course.getCourseDuration(), course.getAccountableMember());
		
		courseId = course.getCourseId();

		if (courseId != null) {
			// Update Operation
				logger.debug("Course Id : "+courseId);
			courseMapper.saveCourse(course);

		} else {
			// Insert/Save Operation
			savedCourse = new Course();

			logger.debug("Before Saving the Course ....");
			savedCourse = courseMapper.saveCourse(newCourse);

			tagcloudList = course.getCourseTagClouds();

			if (tagcloudList != null && tagcloudList.size() > 0) {

				logger.debug("Course Tagcloud list size  : "+tagcloudList.size());
				for (CourseTagcloud courseTagcloud : tagcloudList) {

					courseTagcloud.setCourse(savedCourse);

					courseTagcloud.setCreatingMember(course
							.getAccountableMember());
					
					logger.debug("Before Saving the Course Tagcloud ....");
					tagCloudMapper.save(courseTagcloud);
				}
			}
			contSecurity = course.getCourseContSecurity();

			if (contSecurity != null) {
				logger.debug("Before Saving the Course Content Security....");
				contSecurityMapper.save(contSecurity);
			}
			
			courseDetails = course.getCourseDetails();
			
			if(courseDetails == null){
				throw new CourseException("Course Details cannot be null");
			}

			learningComponentList = courseDetails.getLearningComponents();
				
			if(learningComponentList!=null && learningComponentList.size()>0){

				logger.debug("LearningComponent list size  : "+learningComponentList.size());

				for (LearningComponent learningComponent : learningComponentList) {
						
						logger.debug("Before Saving the Learning Component ....");
						savedComponent = learningComponentMapper.saveLearningComponent(learningComponent);
						
						compDetails =  learningComponent.getLearningComponentDetails();
						
						if(compDetails == null){
							throw new CourseException("Learning Component Details cannot be null");
						}
						courseLComponent = compDetails.getCourseLearningComponent();
							
						courseLComponent.setCourse(savedCourse);
							
						courseLComponent.setLearningComponent(savedComponent);
							
						logger.debug("Before Saving the CourseLearningComponent ....");
						courseLComponentMapper.save(courseLComponent);
							
						compNest = compDetails.getLearningComponentNest();
							
						logger.debug("Before Saving the LearningComponentNest ....");
						componentNestMapper.save(compNest);
					}
				}
			
			
			if(savedCourse.getCourseId()!=null){
				savedCourse = courseMapper.updateCourseInfo(savedCourse);
			}
		}
 
		return savedCourse;
	
	}

	
	@Override
	public Course getBaseCourseDetails(Course course) {
		Course courseDetails = null;

		ZID courseId = null;

		courseId = course.getCourseId();

		courseDetails = courseMapper.getBaseCourseDetails(courseId);

		return courseDetails;
	}

	@Override
	public List<Course> getListOfCourses(ZID memberPersonaId) {

		List<Course> courseList = null;

		courseList = new ArrayList<Course>();

		courseList = courseMapper.getListOfCourses(memberPersonaId);

		return courseList;
	}

	@Override
	public HashMap<String, List<String>> getCourseComponents(ZID courseId) {
		return null;
	}

	@Override
	public CourseAdditionalProperty saveAdditionalCourseProperty(
			CourseAdditionalProperty courseAdditionalProperty)
			throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourseDetails(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCourse(Course course) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Course> getListOfCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LearningProgram> getLearningPrograms(Member member)
			throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName =
	 * "courseMapper") public int createCourse(Course course) {
	 * System.out.println("Entering into createm method in service "); int
	 * status = 0; CoursePlaybook playbook = new CoursePlaybook();
	 * 
	 * System.out.println("got the mapper : " + courseMapper);
	 * 
	 * status = courseMapper.insert(course);
	 * 
	 * if (status > 0) {
	 * System.out.println("********inserted Course record status : " + status);
	 * }
	 * 
	 * playbook.setCourseId(course.getCourseId());
	 * 
	 * int playbookStatus = createPlaybook(playbook);
	 * 
	 * System.out.println("********inserted Course record status : " +
	 * playbookStatus);
	 * 
	 * return status; }
	 * 
	 * public int createPlaybook(CoursePlaybook playbook) {
	 * 
	 * int status = 0;
	 * 
	 * status = corCoursePlaybookMapper.insert(playbook);
	 * 
	 * if (status > 0) {
	 * System.out.println("********inserted Playbookrecord status : " + status);
	 * }
	 * 
	 * return status; }
	 * 
	 * @SuppressWarnings("unused") private int saveMembeRole(MemberRole
	 * memberRole) { int status = 0; memberRole = new MemberRole();
	 * memberRole.setMemberId(10000); memberRole.setActive(true);
	 * memberRole.setRoleType(3576);
	 * 
	 * // Member memberRecord = memberMapper.selectByPrimaryKey(memberId);
	 * 
	 * status = memberRoleMapper.insert(memberRole);
	 * 
	 * return status; }
	 * 
	 * @SuppressWarnings("unused") private int saveMember(Member member) { //
	 * Member member = null; // courseDTO = constructCourseDTO(courseDTO);
	 * 
	 * //Member member = null; Integer memberRoleId = null; //List<MemberRole>
	 * membeRoleList = null; List<Member> membeList = null; //membeRoleList =
	 * new ArrayList<MemberRole>(); membeList = new ArrayList<Member>();
	 * courseDTO = constructCourseDTO(courseDTO);
	 * 
	 * //member = new Member();
	 * 
	 * membeList = memberMapper.getMemberDetails();
	 * 
	 * 
	 * //membeRoleList = member.getMemberRoles();
	 * 
	 * if(membeList.size()>0){ for (Member membr : membeList) { memberRoleId =
	 * membr.getMemberRoleId(); } courseDTO.setMemberRoleId(memberRoleId);
	 * System.out.println("member role id from the db ::"+memberRoleId); }
	 * 
	 * 
	 * // status = saveMember(member);
	 * 
	 * int status = 0; int memStatus = 0; MemberRole memberRole = null;
	 * 
	 * member = new Member(); member.setMemberId(200);
	 * member.setFirstName("Hen"); member.setLastName("Perry");
	 * member.setActive(true); member.setMemberType(650); member.setGender(750);
	 * member.setRelationshipStatus(677);
	 * 
	 * // status = saveMembeRole(memberRole);
	 * 
	 * System.out.println("MemberRole record insert status :: " + status);
	 * 
	 * memStatus = memberMapper.insert(member);
	 * 
	 * System.out.println("Member record insert status :: " + memStatus);
	 * 
	 * return status;
	 * 
	 * }
	 * 
	 * 
	 * private CourseDTO constructCourseDTO(CourseDTO courseDTO) { courseDTO =
	 * new CourseDTO(); courseDTO.setDescription("Course Descriptio220");
	 * courseDTO.setCourseIdentifier("CD0220");
	 * courseDTO.setName("Course Name220"); courseDTO.setMemberRoleId(10000);
	 * 
	 * return courseDTO; }
	 * 
	 * 
	 * public HashMap<String, List<String>> getCourseCatalog(Integer courseId) {
	 * Course corCourse = null; CoursePlaybook playbook = null; HashMap<String,
	 * List<String>> catalogMap = null; CourseCatalog catalog = new
	 * CourseCatalog(); // List<CorCourseComponentContent>
	 * pbComponentContentList = null; catalogMap = new HashMap<String,
	 * List<String>>();
	 * 
	 * corCourse = courseMapper.getCourseCatalog(courseId);
	 * 
	 * catalog.setCourse(corCourse.getCourseIdentifier() + " - " +
	 * corCourse.getName()); catalog.setStartDate(corCourse.getValidFrom());
	 * catalog.setEndDate(corCourse.getValidTo());
	 * 
	 * // playbook = corCourse.getCorCoursePlaybook();
	 * 
	 * List<LearningComponent> courseComponentList = null;
	 * 
	 * // courseComponentList = corCourse.getCourseComponents();
	 * 
	 * // List<CorCourseComponent> pbComponentsList = //
	 * playbook.getCorCourseComponents();
	 * 
	 * for (LearningComponent courseComponent : courseComponentList) {
	 * catalog.setCatalogItemId(courseComponent .getLearningComponentTypeId());
	 * 
	 * // pbComponentContentList = new //
	 * ArrayList<CorCourseComponentContent>();
	 * 
	 * 
	 * pbComponentContentList = corPlaybookComponent.getComponentContentList();
	 * 
	 * for (CorCourseComponentContent corPBComponentContent :
	 * pbComponentContentList) {
	 * if(corPlaybookComponent.getCourseComponentTypeId ().equals("2868")){
	 * catalog.setModule(corPBComponentContent.getContentDescription()); }else
	 * if(corPlaybookComponent.getCourseComponentTypeId().equals("2866" )){
	 * catalog.setChapter(corPBComponentContent.getContentDescription ());
	 * }else{
	 * 
	 * // //catalog.setTopicsList(topicsList)(corPBComponentContent.
	 * getContentDescription()); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return catalogMap; }
	 * 
	 * 
	 * public int saveOrUpdateCourse(Course course) { return 0; }
	 * 
	 * public int saveOrUpdateCourseComponents(Course course) { return 0; }
	 */
}
