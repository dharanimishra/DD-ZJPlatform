package com.ziksana.service.subscription.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Content;
import com.ziksana.persistence.subscription.SubscriptionContentMapper;
import com.ziksana.service.subscription.SubscriptionContentService;

@Service
public class SubscriptionContentServiceImpl implements
		SubscriptionContentService {

	@Autowired
	SubscriptionContentMapper subscriptionContentMapper;

	@Override
	public Content getContent(Integer contentId) {
		// TODO Auto-generated method stub
		return subscriptionContentMapper.getContent(contentId);
	}

}
