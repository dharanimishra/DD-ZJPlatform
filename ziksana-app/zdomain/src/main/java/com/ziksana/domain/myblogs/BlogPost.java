/**
 * 
 */
package com.ziksana.domain.myblogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.domain.common.Question.Builder;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author prabu
 * 
 */
public class BlogPost implements Comparable<BlogPost> {

	private ZID blogPostId;

	private String title;

	private String content;

	private MemberPersona postingMember;

	private Date createDate;

	private Integer viewCount;

	private List<Comment> comments = new ArrayList<Comment>();

	private List<Tag> tags = new ArrayList<Tag>();
	
	

	public BlogPost(Integer blogPostId, String title, String content,
			MemberPersona postingMember, Date createDate, Integer viewCount) {
		super();
		this.blogPostId = new IntegerZID(blogPostId);
		this.title = title;
		this.content = content;
		this.postingMember = postingMember;
		this.createDate = createDate;
		this.viewCount = viewCount;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public Integer getResponseCount() {
		return comments.size();
	}

	public ZID getBlogPostId() {
		return blogPostId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public MemberPersona getPostingMember() {
		return postingMember;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = new ArrayList<Comment>(comments);
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = new ArrayList<Tag>(tags);
	}
	

	@Override
	public int compareTo(BlogPost o) {
		// TODO Auto-generated method stub
		return createDate.compareTo(o.createDate);

	}

}
