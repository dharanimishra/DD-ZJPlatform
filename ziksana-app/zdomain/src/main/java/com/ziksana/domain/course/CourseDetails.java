package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.List;
import com.ziksana.domain.assessment.Assignment;



/**
 * This contains the association/compositions and course tree construction behavious
 * 
 * @author bhashasp
 */
public class CourseDetails{

	@Override
	public String toString() {
		return "CourseDetails [learningComponents=" + learningComponents 
				+ "<br>, learningContent=" + learningContent
				+ ", assignmentTestList=" + assignmentTestList + "]";
	}

	private List<CourseAdditionalProperty> 			courseAdditionalPropertyList 		= null;
	List<LearningComponent> 						learningComponents 					= null;
	private List<CourseLearningComponent> 			courseLearningComponentsList 		= null;
	private LearningComponent 						learningComponent 					= null;
	private LearningComponentContent 				learningComponentContent 			= null;
	private LearningComponentNest 					learningComponentNest 				= null;
	private LearningContent 						learningContent 					= null;
	private List<Assignment> 					assignmentTestList					= null;
	// TODO: below associations/compositions will uncomment later.
	//private List<LearningElementWall> 			learningElementWalls 				= null;
	//private List<CurriculumCourseCalendar> 		currCourseCalendarEntries 			= null;
	//private CurriculumCourse 						curriculumCourse 					= null;
	//private List<LearningContentReviewProgress> 	learningContentReviewProgressList 	= null;
	//private List<Announcement> 					announcements 						= null;
	// private List<Engagement> 					engagements 						= null;

	
	/**
	 * @param index
	 * @return
	 */
	public Assignment getAssignmentTest(int index){
		if(assignmentTestList == null){
			throw new IllegalArgumentException("AssignmentTest cannot set to null");
		}
		
		try{
			return assignmentTestList.get(index);
		}catch(Exception e){
			throw new IllegalStateException("AssignmentTest at index ["+index+"]  not found");
		}
	}
	
	/**
	 * @param playbook
	 */
	public void addAssignmentTest(Assignment test){
		if(assignmentTestList == null){
			assignmentTestList = new ArrayList<Assignment>();
		}
		test.setLearningComponent(learningComponent);
		
		assignmentTestList.add(test);
	}

	
	/**
	 * @param list
	 */
	public void setAssignmentTestList(List<Assignment> list) {
		this.assignmentTestList = list;
	}

	
	/**
	 * Add LearningComponent to a course tree.
	 * @param learningComponent
	 */
	public void addLearningComponent(LearningComponentType learningCompType, LearningComponent learningComponent)
			 {

		if (learningComponents == null) {
			learningComponents = new ArrayList<LearningComponent>();
		}

		if(learningComponent==null){
			learningComponent = new LearningComponent(learningCompType);
		}
		
		// Setting the component nest { parentlearningcomp=null, nestlearncomp=learningComponent }
		learningComponentNest = new LearningComponentNest(null,
				learningComponent);

		learningComponent.getLearningComponentDetails()
				.addLearningComponentNest(learningComponentNest);

		learningComponents.add(learningComponent);
	}

	/**
	 * Adds a child(Learningcomponent/LearningComponentContent) to
	 * parent(LearningComponent) learningcomponent.
	 * 
	 * @param parentLearningCompIndex
	 * @param childLearningCompIndex
	 * @param learningCompContent
	 * @throws CourseException
	 */
	public void addChildNodeToLearningComponent(int parentLearningCompIndex,int childLearningCompIndex, 
			LearningComponentType learningCompType, int learningCompContentIndex,
			LearningComponentContent learningCompContent)
			throws Exception {
		LearningComponent childLearningComponent = null;

		try {
			if (learningComponents == null) {
				throw new IllegalArgumentException("Cannot set to Null");
			}
			
			// Adding a Learning component as a child to another
			// learningcomponent
			if (learningCompContent == null && childLearningCompIndex > 0) {

				childLearningComponent = new LearningComponent(learningCompType);

	/*			childLearningComponent
						.setLearningComponentId(childLearningCompIndex);
*/
				learningComponentNest = new LearningComponentNest(
						learningComponent, childLearningComponent);

				// parent learning component nest
				learningComponentNest
						.setLearningComponentParent(learningComponent);

				// learning component as a child
				learningComponentNest
						.setLearningComponentNest(childLearningComponent);

				childLearningComponent.getLearningComponentDetails()
						.addLearningComponentNest(learningComponentNest);
				
				addLearningComponent(learningCompType, childLearningComponent);

			}

			// Adding a Learning caomponentcontent as a child to
			// learningcomponent
			if (learningCompContent != null) {
				
				learningContent = new LearningContent();
				
				List<LearningContentParts> learningContentParts = null;
				
				learningContent.setLearningContentParts(learningContentParts);
				
				learningCompContent = new LearningComponentContent(childLearningComponent, learningContent);
				
				learningCompContent.getLearrningComponentContentDetails().addLearningContent(learningContent);
				
				learningComponent.getLearningComponentDetails()
						.addLearningComponentContent(learningCompContent);

				learningComponents.add(learningComponent);

			}

		} catch (Exception e) {
			throw new IllegalStateException("Error adding a chlild to learning component ID [ "+parentLearningCompIndex+" ]");
		}

	}

	/**
	 * @param learningComponentId
	 */
	public void removeLearningComponent(Integer learningComponentId)
			throws Exception {

		if (learningComponents == null) {
			throw new IllegalStateException(
					"LearningComponents not set in Course ");
		}

		for (LearningComponent learningComponent : learningComponents) {

			if (learningComponent.getLearningComponentId().equals(
					learningComponentId)) {
				learningComponents.remove(learningComponent);
			}
		}
	}

	/**
	 * @param learningComponent
	 */
	public LearningComponent getLearningComponent(int index)
			throws Exception {

		if (learningComponents == null) {
			throw new IllegalArgumentException("LearningComponent is set as a null");
		}
		try {
			return learningComponents.get(index);
		} catch (Exception e) {
			throw new IllegalStateException("Learning Component at index [" + index
					+ "] at not found");
		}
	}

	/**
	 * @param learningComponent
	 */
	public LearningComponent getLearningComponent()
			throws Exception {

			return learningComponent;
	}

	/**
	 * @return the learningComponents
	 */
	public List<LearningComponent> getLearningComponents() {
		return learningComponents;
	}

	/**
	 * @param learningComponents
	 *            the learningComponents to set
	 */
	public void setLearningComponents(List<LearningComponent> learningComponents)
			throws Exception {

		if (learningComponents == null) {
			throw new IllegalArgumentException(
					"Cannot set LearningComponents, Course is null");
		}
		this.learningComponents = learningComponents;

	}
/*
	*//**
	 * @return the curriculumCourse
	 *//*
	public CurriculumCourse getCurriculumCourse() {
		return curriculumCourse;
	}

	*//**
	 * @param curriculumCourse
	 *            the curriculumCourse to set
	 *//*
	public void setCurriculumCourse(CurriculumCourse curriculumCourse) {
		this.curriculumCourse = curriculumCourse;
	}
*/
	/**
	 * @return the courseLearningComponentsList
	 */
	public List<CourseLearningComponent> getCourseLearningComponentsList() {
		return courseLearningComponentsList;
	}

	/**
	 * @param courseLearningComponentsList
	 *            the courseLearningComponentsList to set
	 */
	public void setCourseLearningComponentsList(
			List<CourseLearningComponent> courseLearningComponentsList) {
		this.courseLearningComponentsList = courseLearningComponentsList;
	}

/*	*//**
	 * @return the coursePlaybook
	 *//*
	public CoursePlaybook getCoursePlaybook() {
		return coursePlaybook;
	}

	*//**
	 * @param coursePlaybook
	 *            the coursePlaybook to set
	 *//*
	public void setCoursePlaybook(CoursePlaybook coursePlaybook) {
		this.coursePlaybook = coursePlaybook;
	}

*/	/**
	 * @return the courseAdditionalPropertyList
	 */
	public List<CourseAdditionalProperty> getCourseAdditionalPropertyList() {
		return courseAdditionalPropertyList;
	}

	/**
	 * @param courseAdditionalPropertyList
	 *            the courseAdditionalPropertyList to set
	 */
	public void setCourseAdditionalPropertyList(
			List<CourseAdditionalProperty> courseAdditionalPropertyList) {
		this.courseAdditionalPropertyList = courseAdditionalPropertyList;
	}
	
	/**
	 * @return the learningComponentContent
	 */
	public LearningComponentContent getLearningComponentContent() {
		return learningComponentContent;
	}

	/**
	 * @param learningComponentContent
	 *            the learningComponentContent to set
	 */
	public void setLearningComponentContent(
			LearningComponentContent learningComponentContent) {
		this.learningComponentContent = learningComponentContent;
	}
	
	
}
