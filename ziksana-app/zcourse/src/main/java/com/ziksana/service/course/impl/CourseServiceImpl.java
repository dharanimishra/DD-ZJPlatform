package com.ziksana.service.course.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.member.MemberRole;
import com.ziksana.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Override
	public Course getBaseCourseDetails(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getListOfCourses(MemberRole memberRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, List<String>> getCourseCatalog(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveOrUpdateCourse(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveOrUpdateCourseComponents(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Course modifyCourseProperties(Course course) {
		// TODO Auto-generated method stub
		return null;
	}/*

	@Autowired
	public CourseMapper corCourseMapper;
	@Autowired
	public ProgrammCurriculumMapper corProgCurrMapper;
	@Autowired
	public LearningProgramMapper corAcademicProgramMapper;
	@Autowired
	public InstitutionMapper corInstitutionMapper;
	@Autowired
	public MemberRoleMapper memberRoleMapper;
	@Autowired
	public MemberMapper memberMapper;
	@Autowired
	public CoursePlaybookMapper corCoursePlaybookMapper;

	public void setCorCourseMapper(CourseMapper corCourseMapper) {
		this.corCourseMapper = corCourseMapper;
	}

	public void setCorProgCurrMapper(ProgrammCurriculumMapper corProgCurrMapper) {
		this.corProgCurrMapper = corProgCurrMapper;
	}

	public void setCorAcademicProgramMapper(
			LearningProgramMapper corAcademicProgramMapper) {
		this.corAcademicProgramMapper = corAcademicProgramMapper;
	}

	public void setCorInstitutionMapper(InstitutionMapper corInstitutionMapper) {
		this.corInstitutionMapper = corInstitutionMapper;
	}

	public void setMemberRoleMapper(MemberRoleMapper memberRoleMapper) {
		this.memberRoleMapper = memberRoleMapper;
	}

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}


	public List<Course> getListOfCourses(MemberRole memberRole) {
		
		List<Course> courseList = null;
		
		Integer memberRoleId = null;

		memberRoleId = memberRole.getMemberRoleId();

		courseList = new ArrayList<Course>();

		corCourseMapper.getListOfCourses(memberRoleId);

		return courseList;
	}

	
	public Course getBaseCourseDetails(Course course) {

		Course courseDetails = null;

		Integer courseId = null;

		courseId = course.getCourseId();

		courseDetails = corCourseMapper.selectByPrimaryKey(courseId);

		return courseDetails;
	}

	
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "corCourseMapper")
	public int createCourse(Course course) {
		System.out.println("Entering into createm method in service ");
		int status = 0;
		CoursePlaybook playbook = new CoursePlaybook();

		System.out.println("got the mapper : " + corCourseMapper);

		status = corCourseMapper.insert(course);

		if (status > 0) {
			System.out.println("********inserted Course record status : "
					+ status);
		}

		playbook.setCourseId(course.getCourseId());

		int playbookStatus = createPlaybook(playbook);

		System.out.println("********inserted Course record status : "
				+ playbookStatus);

		return status;
	}

	public int createPlaybook(CoursePlaybook playbook) {

		int status = 0;

		status = corCoursePlaybookMapper.insert(playbook);

		if (status > 0) {
			System.out.println("********inserted Playbookrecord status : "
					+ status);
		}

		return status;
	}

	@SuppressWarnings("unused")
	private int saveMembeRole(MemberRole memberRole) {
		int status = 0;
		memberRole = new MemberRole();
		memberRole.setMemberId(10000);
		memberRole.setActive(true);
		memberRole.setRoleType(3576);

		// Member memberRecord = memberMapper.selectByPrimaryKey(memberId);

		status = memberRoleMapper.insert(memberRole);

		return status;
	}

	@SuppressWarnings("unused")
	private int saveMember(Member member) {
		// Member member = null;
		// courseDTO = constructCourseDTO(courseDTO);
		
		 * //Member member = null; Integer memberRoleId = null;
		 * //List<MemberRole> membeRoleList = null; List<Member> membeList =
		 * null; //membeRoleList = new ArrayList<MemberRole>(); membeList = new
		 * ArrayList<Member>(); courseDTO = constructCourseDTO(courseDTO);
		 * 
		 * //member = new Member();
		 * 
		 * membeList = memberMapper.getMemberDetails();
		 * 
		 * 
		 * //membeRoleList = member.getMemberRoles();
		 * 
		 * if(membeList.size()>0){ for (Member membr : membeList) { memberRoleId
		 * = membr.getMemberRoleId(); } courseDTO.setMemberRoleId(memberRoleId);
		 * System.out.println("member role id from the db ::"+memberRoleId); }
		 

		// status = saveMember(member);

		int status = 0;
		int memStatus = 0;
		MemberRole memberRole = null;

		member = new Member();
		member.setMemberId(200);
		member.setFirstName("Hen");
		member.setLastName("Perry");
		member.setActive(true);
		member.setMemberType(650);
		member.setGender(750);
		member.setRelationshipStatus(677);

		// status = saveMembeRole(memberRole);

		System.out.println("MemberRole record insert status :: " + status);

		memStatus = memberMapper.insert(member);

		System.out.println("Member record insert status :: " + memStatus);

		return status;

	}

	
	 * private CourseDTO constructCourseDTO(CourseDTO courseDTO) { courseDTO =
	 * new CourseDTO(); courseDTO.setDescription("Course Descriptio220");
	 * courseDTO.setCourseIdentifier("CD0220");
	 * courseDTO.setName("Course Name220"); courseDTO.setMemberRoleId(10000);
	 * 
	 * return courseDTO; }
	 
	
	public HashMap<String, List<String>> getCourseCatalog(Integer courseId) {
		Course corCourse = null;
		CoursePlaybook playbook = null;
		HashMap<String, List<String>> catalogMap = null;
		CourseCatalog catalog = new CourseCatalog();
		// List<CorCourseComponentContent> pbComponentContentList = null;
		catalogMap = new HashMap<String, List<String>>();

		corCourse = corCourseMapper.getCourseCatalog(courseId);

		catalog.setCourse(corCourse.getCourseIdentifier() + " - "
				+ corCourse.getName());
		catalog.setStartDate(corCourse.getValidFrom());
		catalog.setEndDate(corCourse.getValidTo());

		// playbook = corCourse.getCorCoursePlaybook();

		List<LearningComponent> courseComponentList = null;

		// courseComponentList = corCourse.getCourseComponents();

		// List<CorCourseComponent> pbComponentsList =
		// playbook.getCorCourseComponents();

		for (LearningComponent courseComponent : courseComponentList) {
			catalog.setCatalogItemId(courseComponent
					.getLearningComponentTypeId());

			// pbComponentContentList = new
			// ArrayList<CorCourseComponentContent>();

			
			 * pbComponentContentList =
			 * corPlaybookComponent.getComponentContentList();
			 * 
			 * for (CorCourseComponentContent corPBComponentContent :
			 * pbComponentContentList) {
			 * if(corPlaybookComponent.getCourseComponentTypeId
			 * ().equals("2868")){
			 * catalog.setModule(corPBComponentContent.getContentDescription());
			 * }else
			 * if(corPlaybookComponent.getCourseComponentTypeId().equals("2866"
			 * )){
			 * catalog.setChapter(corPBComponentContent.getContentDescription
			 * ()); }else{
			 * 
			 * // //catalog.setTopicsList(topicsList)(corPBComponentContent.
			 * getContentDescription()); }
			 * 
			 * }
			 
		}

		return catalogMap;
	}

	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	public int saveOrUpdateCourse(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int saveOrUpdateCourseComponents(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Course modifyCourseProperties(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

*/}
