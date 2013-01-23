package com.ziksana.service.course.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.course.Enrichment;
import com.ziksana.persistence.course.EnrichmentMapper;
import com.ziksana.service.course.CourseEnrichmentService;

public class CourseEnrichmentServiceImpl implements CourseEnrichmentService {

	private final static Logger LOGGER = Logger
			.getLogger(CourseEnrichmentServiceImpl.class);

	@Autowired
	public EnrichmentMapper enrichMapper;

	@Override
	public Integer saveReference(Enrichment enrichment) {
		// TODO Auto-generated method stub
		return null;
	}

}
