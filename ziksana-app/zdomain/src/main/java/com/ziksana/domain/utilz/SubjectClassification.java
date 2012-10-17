package com.ziksana.domain.utilz;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.common.Topic;

/**
 * @author bhashasp
 */
public class SubjectClassification extends AuditHistory {

	// classification is a Map of Area vs SubjectMap
	// SubjectMap is a Map of Subject vs TopicList
	// TopicList is a List of Topics
	private Map<String, Map<String, List<Topic>>> classification = null;

	public SubjectClassification() {
		
	}

	public SubjectClassification(String area, String subject, Topic topic) {
		
		topic.setArea(area);
		topic.setSubject(subject);
		add(topic);
	}
	
	public SubjectClassification(Topic topic) {
		add(topic);
	}
	
	public void add(Topic topic) {
		if (classification == null) {
			List<Topic> topicList = new ArrayList<Topic>();
			Map<String, List<Topic>> subjectMap = new HashMap<String, List<Topic>>();
			classification = new HashMap<String, Map<String, List<Topic>>>();
			
			topicList.add(topic);
			subjectMap.put(topic.getSubject(), topicList);
			classification.put(topic.getArea(), subjectMap);
			
			return;
		}
		
		Map<String, List<Topic>>  subjectMap = null;
		List<Topic>               topicList  = null;
		
		subjectMap = classification.get(topic.getArea());
		if (subjectMap == null) {
			topicList = new ArrayList<Topic>();
			topicList.add(topic);
			
			subjectMap = new HashMap<String, List<Topic>>();
			subjectMap.put(topic.getSubject(), topicList);
			
			classification.put(topic.getArea(), subjectMap);
			return;
		}

		topicList = subjectMap.get(topic.getSubject());
		if (topicList == null) {
			topicList = new ArrayList<Topic>();
			topicList.add(topic);
			
			subjectMap.put(topic.getSubject(), topicList);
		}
		
		topicList.add(topic);
		
		return;
	}
	
	public Set<String> getAreaSet() {
		if (classification == null) {
			return null;
		}
		return classification.keySet();
	}
	
	public Set<String> getSubjectSet(String area) {
		if (classification == null || classification.get(area) == null) {
			return null;
		}
		return classification.get(area).keySet();
	}

	public List<Topic> getTopicList(String area, String subject) {
		if (classification == null || classification.get(area) == null) {
			return null;
		}
		return classification.get(area).get(subject);
	}

	@Override
	public String toString() {
		return "SubjectClassification [subject=" + subject + ", area=" + area
				+ ", topic=" + topic + ", active=" + active + "]";
	}
}