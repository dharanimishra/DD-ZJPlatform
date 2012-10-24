/**
 * 
 */
package com.ziksana.service.blogs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.myblogs.BlogPost;
import com.ziksana.persistence.blogs.BlogMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.blogs.BlogService;

/**
 * @author prabu
 *
 */

public class BlogServiceImpl implements BlogService {

	
	@Autowired
	public BlogMapper blogMapper;
	
	/* (non-Javadoc)
	 * @see com.ziksana.service.blogs.BlogService#getBlogs()
	 */
	@Override
	public List<BlogPost> getBlogs() {
		// TODO Auto-generated method stub
		
		Integer postingMemberRoleId = Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID());
		return blogMapper.getBlogs(postingMemberRoleId);
	}
	
	
	

}
