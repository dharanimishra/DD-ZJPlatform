package com.ziksana.service.course.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Enrichment;
import com.ziksana.persistence.course.EnrichmentMapper;
import com.ziksana.service.course.CourseEnrichmentService;

@Service
public class CourseEnrichmentServiceImpl implements CourseEnrichmentService {

	private final static Logger LOGGER = Logger
			.getLogger(CourseEnrichmentServiceImpl.class);

	@Autowired
	public EnrichmentMapper enrichMapper;

	@Override
	public Integer saveReference(Enrichment enrichment) {

		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :saveReference(Enrichment enrichment)");
		Integer value = enrichMapper.saveReference(enrichment);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :saveReference(Enrichment enrichment) : Updated Rows :value:"
				+ value);

		return value;
	}

}
