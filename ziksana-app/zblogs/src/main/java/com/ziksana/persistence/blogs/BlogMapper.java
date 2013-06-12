package com.ziksana.persistence.blogs;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.ziksana.domain.myblogs.BlogPost;

public interface BlogMapper {
	
	List<BlogPost> getBlogs(Integer postingMemberRoleId, RowBounds rowBounds);
	
	

}
