package com.ziksana.service.subjectclassification.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.jsontype.SubtypeResolver;

import com.ziksana.domain.utilz.SubjectClassification;
import com.ziksana.exception.subjectclassification.SubjectClassificationException;
import com.ziksana.service.subjectclassification.SubjectClassificationService;

public class MockSubjectClassificationServiceImpl implements SubjectClassificationService{

	SubjectClassification sClassification = null;
	static List<String> areaList = null;
	//static List<String> subjectList = null;
	static List<String> subjectComputer = null;
	static List<String> subjectPhilosophy = null;
	static List<String> subjectReligion = null;

	static List<String> topicBibliography = null;
	static List<String> topicLibInfo = null;
	static List<String> topicMetaphysics = null;
	static List<String> topicEpistemology = null;
	static List<String> topicTheology= null;
	static List<String> topicReligion= null;

	//static List<String> topicList = null;
	static Map<String,List> subjectMap = new HashMap<String,List>();
	static Map<String,List> topicMap = new HashMap<String,List>();
	
	
	public MockSubjectClassificationServiceImpl() {

		
		areaList = new ArrayList<String>();
		subjectMap = new HashMap<String,List>();
		topicMap = new HashMap<String,List>();
		sClassification = new SubjectClassification();
		// Sample list of areas
		
		areaList.add("Computer science, knowledge & systems");
		areaList.add("Philosophy and psychology");
		areaList.add("Religion");
		
		subjectComputer = new ArrayList<String>();
		// Subjects related to Computer science, knowledge & systems
		subjectComputer.add("Bibliography");
		subjectComputer.add("Library & information sciences");
		subjectMap.put("Computer science, knowledge & systems", subjectComputer);
		
		subjectPhilosophy = new ArrayList<String>();
		// Subjects related to Philosophy and psychology
		subjectPhilosophy.add("Metaphysics");
		subjectPhilosophy.add("Epistemology");
		subjectMap.put("Philosophy and psychology", subjectPhilosophy);
		
		subjectReligion = new ArrayList<String>();
		// Subjects related to Religion
		subjectReligion.add("Natural theology");
		subjectReligion.add("Bible");
		subjectMap.put("Religion", subjectReligion);
		
		// topics related to Bibliography
		topicBibliography = new ArrayList<String>();
		topicBibliography.add("Data processing & computer science");
		topicBibliography.add("Bibliographies of individuals");
		topicMap.put("Bibliography",topicBibliography);
		
		// topics related to Library & information sciences
		topicLibInfo = new ArrayList<String>();
		topicLibInfo.add("Library relationships");
		topicLibInfo.add("Personnel management");
		topicMap.put("Library & information sciences",topicLibInfo);
		
		// topics related to Metaphysics
		topicMetaphysics = new ArrayList<String>();
		topicMetaphysics.add("Ontology");
		topicMetaphysics.add("Space");
		topicMap.put("Metaphysics",topicMetaphysics);
		
		// topics related to Epistemology
		topicEpistemology = new ArrayList<String>();
		topicEpistemology .add("Epistemology, causation, and humankind");
		topicEpistemology .add("Causation");
		topicMap.put("Epistemology",topicEpistemology);
		
		// topics related to Natural theology
		topicTheology = new ArrayList<String>();
		topicTheology.add("Concepts of God");
		topicTheology.add("Existence, attributes of God");
		topicMap.put("Natural theology",topicTheology);
		
		topicReligion = new ArrayList<String>();
		topicReligion.add("Old Testament");
		topicReligion.add("New Testament");
		topicMap.put("Bible",topicReligion);
		
	}

	@Override
	public List<String> getAreaList()
			throws SubjectClassificationException {
		sClassification.setAreaList(areaList);
		
		return sClassification.getAreaList();
	}
	
	@Override
	public List<String> getSubjectList()
			throws SubjectClassificationException {
		List<String> subjectList = new ArrayList<String>();
		for (List<ArrayList> list : subjectMap.values()) {
				Iterator it = list.iterator(); 
				while(it.hasNext()){
					//System.out.println(" iterator "+it.next());
					subjectList.add((String)it.next());
				}
		} 
		sClassification.setSubjectList(subjectList);
		return sClassification.getSubjectList();
	}

	@Override
	public List<String> getTopicList()
			throws SubjectClassificationException {
		
		List<String> topicList = new ArrayList<String>();
		for (List<ArrayList> list : topicMap.values()) {
				Iterator it = list.iterator();
				while(it.hasNext()){
					topicList.add((String)it.next());
				}
		} 
		
		sClassification.setTopicList(topicList);
		return sClassification.getTopicList();
		
	}

	@Override
	public SubjectClassification getSubjectList(
			SubjectClassification subjectClassification)
			throws SubjectClassificationException {
		sClassification.setArea(subjectClassification.getArea());
		sClassification.setSubjectList(subjectMap.get(subjectClassification.getArea()));
		
		return sClassification;
	}

	@Override
	public SubjectClassification getTopicList(
			SubjectClassification subjectClassification)
			throws SubjectClassificationException {
		sClassification.setTopicList(topicMap.get(subjectClassification.getSubject()));
		return sClassification;
	}
}