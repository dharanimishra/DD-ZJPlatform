package com.ziksana.service.course.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Enrichment;
import com.ziksana.persistence.course.EnrichmentMapper;
import com.ziksana.service.course.CourseEnrichmentService;

@Service
public class CourseEnrichmentServiceImpl implements CourseEnrichmentService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseEnrichmentServiceImpl.class);

	@Autowired
	public EnrichmentMapper enrichMapper;

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
