package com.ziksana.persistence.polls;


import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollQuestionResult;


public interface PollQuestionResponseMapper {
   
    /**
     * 
     * @param pollQuestionResponseId
     * @return
     */
      int deleteByPrimaryKey(Integer pollQuestionResponseId);    
      
      @UpdateProvider(type = PollSqlProvider.class, method = "updatePollResponseSql")		  
      public void  createPollResponse(PollQuestionResponse pollQuestionResponse);
      
      @InsertProvider(type = PollSqlProvider.class, method = "createPollTrackerSql")
      public void createPollTrackerEntry(@Param("pollQuestionId") Integer pollQuestionId, @Param("answeringMemberRoleId") Integer answeringMemberRoleId);
      
      public PollQuestionResult getPollResultByQuestion(@Param("pollQuestionId") Integer pollQuestionId, @Param("answeringMemberRoleId") Integer answeringMemberRoleId);
      
      public PollQuestionEntity getPollQuestionById(Integer pollQuestionId);
      
    
    }