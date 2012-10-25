package com.ziksana.persistence.knowmebetter;

import java.util.List;

import com.ziksana.domain.common.Question;

public interface PersonalityTestMapper {
	
	public List<Question> getUnansweredQuestions(Integer memberRoleId);

}
