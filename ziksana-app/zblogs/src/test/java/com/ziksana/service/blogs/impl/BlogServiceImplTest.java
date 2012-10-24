package com.ziksana.service.blogs.impl;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.alerts.Alert;
import com.ziksana.domain.myblogs.BlogPost;
import com.ziksana.domain.myblogs.Comment;
import com.ziksana.domain.myblogs.Tag;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.blogs.BlogService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class BlogServiceImplTest {

	@Autowired
    private BlogService blogService;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBlogs() {
        
		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");
		
		
		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);
			
		
		List<BlogPost> blogs = blogService.getBlogs();
		
        BlogPost blogPost = (BlogPost)blogs.iterator().next();
        
        List<Comment> comments = blogPost.getComments();
        List<Tag> tags = blogPost.getTags();
        
        
        Assert.assertTrue(comments.size() == 2);
        Assert.assertFalse(blogs.isEmpty());
		Assert.assertTrue(blogs.size() == 2);
		Assert.assertTrue(tags.size() == 1);
		
	}

}
