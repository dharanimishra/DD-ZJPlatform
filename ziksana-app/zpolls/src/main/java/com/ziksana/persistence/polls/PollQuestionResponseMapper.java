package com.ziksana.persistence.polls;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ziksana.domain.polls.PollResponse;

public interface PollQuestionResponseMapper {
   
    /**
     * 
     * @param pollQuestionResponseId
     * @return
     */
      int deleteByPrimaryKey(Integer pollQuestionResponseId);
      
      
      @UpdateProvider(type = PollSqlProvider.class, method = "updatePollResponseSql")		  
      public void  createPollResponse(PollResponse pollResponse);
      
      @InsertProvider(type = PollSqlProvider.class, method = "createPollTrackerSql")
      public void createPollTrackerEntry(@Param("pollQuestionId") Integer pollQuestionId, @Param("answeringMemberRoleId") Integer answeringMemberRoleId);
          
    
    }