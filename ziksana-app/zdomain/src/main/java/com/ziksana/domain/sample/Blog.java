package com.ziksana.domain.sample;

import java.util.List;

public class Blog {
	
	String blogDate;
	String blogId;
	String blogTitle;
	String blogDetail;
	List<String> blogTags;
	

	
	/**
	 * @return the blogDate
	 */
	public String getBlogDate() {
		return blogDate;
	}


	/**
	 * @param blogDate the blogDate to set
	 */
	public void setBlogDate(String blogDate) {
		this.blogDate = blogDate;
	}


	public String getBlogId() {
		return blogId;
	}


	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}


	public String getBlogTitle() {
		return blogTitle;
	}


	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}


	public String getBlogDetail() {
		return blogDetail;
	}


	public void setBlogDetail(String blogDetail) {
		this.blogDetail = blogDetail;
	}


	public List<String> getBlogTags() {
		return blogTags;
	}


	public void setBlogTags(List<String> blogTags) {
		this.blogTags = blogTags;
	}


	public Blog() {
		// TODO Auto-generated constructor stub
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlogList [blogDate=" + blogDate + ", blogId=" + blogId
				+ ", blogTitle=" + blogTitle + ", blogDetail=" + blogDetail
				+ ", blogTags=" + blogTags + "]";
	}

}
