/**
 * 
 */
package com.ziksana.persistence.polls;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

import java.util.List;

import com.ziksana.domain.polls.PollQuestionResponse;


/**
 * @author prabu
 * 
 */
public class PollSqlProvider {
    
	public String updatePollResponseSql(PollQuestionResponse pollResponse) {
		
		if (null == pollResponse)
			throw new IllegalArgumentException("PollResponse object is null");
		
		
		List<Integer> answers = pollResponse.getAnswers();
		//String setString = "answer" + answerId.intValue() + "Count";
		BEGIN(); // Clears ThreadLocal variable
		UPDATE("utlzpollquestionresponse");
		
		for(Integer answerId: answers)
		{
		
			String setString = "answer" + answerId.intValue() + "Count";
			SET(setString + "=" + setString + "+1");
		}
		//SET(setString + "=" + setString + "+1");
		
		WHERE("pollQuestionId = #{pollQuestionId}");

		return SQL();

	}

	public String createPollTrackerSql() {
		BEGIN(); 
		INSERT_INTO("utlzpolltracker");
		VALUES("pollQuestionId", "#{pollQuestionId}");
		VALUES("answeringMemberRoleId","#{answeringMemberRoleId}");
		return SQL();

	}
	
	
	public String getPollResultSql() {
		BEGIN();
		SELECT("DISTINCT utlzpollquestionresponse.*");
		FROM("utlzpollquestionresponse");
		FROM("utlzpolltracker");
		WHERE("utlzpollquestionresponse.pollQuestionId=utlzpolltracker.pollQuestionId");
		WHERE("utlzpolltracker.pollQuestionId=#{pollQuestionId}");
		WHERE("utlzpolltracker.answeringMemberRoleId=#{answeringMemberRoleId}");
		return SQL();
	}
	
	
	

}
