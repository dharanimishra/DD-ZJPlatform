package com.ziksana.persistence.polls;

import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResult;
import com.ziksana.domain.polls.PollResult;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PollQuestionMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	// int countByExample(PollQuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	// int deleteByExample(PollQuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	int deleteByPrimaryKey(Integer pollQuestionId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	int insert(PollQuestion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	int insertSelective(PollQuestion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	// List<PollQuestion> selectByExample(PollQuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	PollQuestion selectByPrimaryKey(Integer pollQuestionId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	// int updateByExampleSelective(@Param("record") PollQuestion record,
	// @Param("example") PollQuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	// int updateByExample(@Param("record") PollQuestion record,
	// @Param("example") PollQuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	int updateByPrimaryKeySelective(PollQuestion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table utlzpollquestion
	 * 
	 * @mbggenerated Mon Sep 10 17:04:28 IST 2012
	 */
	int updateByPrimaryKey(PollQuestion record);

	/**
	 * 
	 * @param pollId
	 * @return
	 */
	// @Select("select utlzpollquestion.* from utlzpoll NATURAL JOIN utlzpollquestion where   CURDATE()<utlzpoll.pollEndDate and  ID = #{ID}")

	@Select({ "Select utlzpollquestion.*", " from ",
			" utlzpollquestion,polltracker,utlzpoll ", " where ",
			" utlzpoll.ID=utlzpollquestion.pollId and ",
			" polltracker.answeringMemberRoleId= #{memberRoleId} and ",
			" utlzpollquestion.ID!=polltracker.pollQuestionId  and ",
			" curdate() < utlzpoll.PollEndDate " })
	List<PollQuestion> getPoll(Integer memberRoleId);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select({ "Select count(*) ", " from ",
			" utlzpollquestion,polltracker,utlzpoll ", " where ",
			" utlzpoll.ID=utlzpollquestion.pollId and ",
			" polltracker.answeringMemberRoleId= #{memberRoleId} and ",
			" utlzpollquestion.ID!=polltracker.pollQuestionId  and ",
			" curdate() < utlzpoll.PollEndDate " })
	int getTotalQuestions(Integer id);

	
	
	
	
	@Select({
		"SELECT ",
		"utlzpollquestion.ID AS pollQuestionId,", 
		"utlzpollquestion.QuestionType,",
		"utlzpollquestion.QuestionText,",
		"utlzpollquestion.Answer1,",
		"utlzpollquestion.Answer2,",
		"utlzpollquestion.Answer3,",
		"utlzpollquestion.Answer4,",
		"utlzpollquestion.Answer5,",
		"utlzpollquestionresponse.Answer1Count,",
		"utlzpollquestionresponse.Answer2Count,",
		"utlzpollquestionresponse.Answer3Count,",
		"utlzpollquestionresponse.Answer4Count,",
		"utlzpollquestionresponse.Answer5Count,",
		"utlzpolltracker.answeringMemberRoleId ",
		"FROM ",
		"utlzpoll ",
		"JOIN utlzpollquestion ON utlzpoll.ID = utlzpollquestion.PollId ",
		"LEFT JOIN utlzpollquestionresponse ON utlzpollquestion.ID = utlzpollquestionresponse.pollQuestionID ",
		"LEFT JOIN utlzpolltracker ON utlzpollquestionresponse.pollQuestionId=utlzpolltracker.pollQuestionId ",
		"WHERE CURDATE() < utlzpoll.PollEndDate AND ",
		"utlzpoll.Active=1 AND ",
		"utlzpollquestion.Active=1 AND ",
		"utlzpolltracker.answeringMemberRoleId=#{userMemberRoleId} "

	})
	List<PollQuestionResult> getPollResults(Integer userMemberRoleId);
	
	
	
	
	
	@Select({
		"select ",
		"ID,", 
		"QuestionType,",
		"QuestionText,",
		"pollQuestionDate,",
		"Answer1,",
		"Answer2,",
		"Answer3,",
		"Answer4,",
		"Answer5 ",
		"from ",
		"utlzpollquestion ",
		"where ",
		"utlzpollquestion.ID  not in (select pollquestionid from utlzpolltracker where answeringmemberroleid=#{userMemberRoleId}) "
		
	})
	List<PollQuestionEntity> getPollQuestions(Integer userMemberRoleId);
	
	
	PollResult getPollResultByQuestion(Integer userMemberRoleId);
	
	List<PollQuestionEntity> getPollQuestionsByDate ( @Param("startDate") Date startDate, @Param("endDate") Date endDate);

	List<PollQuestionEntity> getPollQuestion(Integer userMemberRoleId);
	
	
	

}