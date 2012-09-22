package com.ziksana.persistence.polls;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PollQuestionResponseMapper {
   
    /**
     * 
     * @param pollQuestionResponseId
     * @return
     */
    int deleteByPrimaryKey(Integer pollQuestionResponseId);

    
    
    }