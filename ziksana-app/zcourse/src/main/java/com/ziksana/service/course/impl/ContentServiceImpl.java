package com.ziksana.service.course.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Content;
import com.ziksana.persistence.course.ContentMapper;
import com.ziksana.service.course.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
     
	@Autowired
	ContentMapper contentMapper;
	
	@Override
	public Content getContent(Integer contentId) {
		// TODO Auto-generated method stub
		return  contentMapper.getContent(contentId);
	}

}
