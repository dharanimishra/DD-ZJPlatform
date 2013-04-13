/**
 * 
 */
package com.ziksana.service.blogs.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.myblogs.BlogPost;
import com.ziksana.persistence.blogs.BlogMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.blogs.BlogService;

/**
 * @author prabu
 * 
 */

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	public BlogMapper blogMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.blogs.BlogService#getBlogs()
	 */

	public List<BlogPost> getBlogs() {

		List<BlogPost> blogList = new ArrayList<BlogPost>();
		Integer postingMemberRoleId = Integer.valueOf(SecurityTokenUtil
				.getToken().getMemberPersonaId().getStorageID());
		int offset = 0;
		int limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		blogList = blogMapper.getBlogs(postingMemberRoleId, rowBounds);
		return blogList;
	}

}
