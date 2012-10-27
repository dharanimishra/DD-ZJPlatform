package com.ziksana.persistence.knowmebetter;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.domain.common.QuestionResponse;

public interface PersonalityTestMapper {
	
	public List<Question> getUnansweredQuestions(Integer memberRoleId);
	
	public void saveAnswer(@Param("question") Question question, @Param("answer") Choice userChoice);
	
	public List<QuestionResponse> answeredQuestions(Integer memberRoleId);

}
