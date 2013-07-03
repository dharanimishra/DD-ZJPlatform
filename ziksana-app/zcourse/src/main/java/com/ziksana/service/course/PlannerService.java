/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.Planner;

/**
 * @
 *
 */
public interface PlannerService {

	public void savePlanner(List<Planner> plannerList);

	public List<Planner> getPlannerByCourseId(Integer courseId);

	public void savePlannerPojo(Planner planner);

	public int updatePlanner(Planner updatePlanner);
}
