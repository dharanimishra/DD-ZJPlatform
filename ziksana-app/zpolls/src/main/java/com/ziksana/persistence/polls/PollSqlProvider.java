/**
 * 
 */
package com.ziksana.persistence.polls;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

import java.util.List;

import com.ziksana.domain.polls.PollResponse;

/**
 * @author prabu
 * 
 */
public class PollSqlProvider {
    
	public String updatePollResponseSql(PollResponse pollResponse) {
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

}
