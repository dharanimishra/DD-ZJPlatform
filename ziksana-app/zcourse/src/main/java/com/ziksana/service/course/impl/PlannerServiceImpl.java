/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Planner;
import com.ziksana.persistence.course.PlannerMapper;
import com.ziksana.service.course.PlannerService;

/**
 * @author vtg-p13
 *
 */
@Service
public class PlannerServiceImpl implements PlannerService {

	@Autowired
	PlannerMapper plannerMapper;
	
	
	/* 
	 * To Save Planner
	 */
	public void savePlanner(List<Planner> plannerList) {
		
			
		for(Planner planner :plannerList){
			plannerMapper.savePlanner(planner);
		}
		
		
	}


	public List<Planner> getPlannerByCourseId(Integer courseId) {
		
		return plannerMapper.getPlannerByCourseId(courseId);
	}


	public void savePlannerPojo(Planner planner) {
		plannerMapper.savePlanner(planner);
		
	}


	public int updatePlanner(Planner planner) {
		return plannerMapper.updatePlanner(planner);
		
	}


}
