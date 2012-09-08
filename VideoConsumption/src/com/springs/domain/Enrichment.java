package com.springs.domain;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

public class Enrichment {
	/**
	 * This field corresponds to the database column enrichment.enrichmentid
	 */
	private Integer enrichmentid;

	/**
	 * This field corresponds to the database column enrichment.title
	 */
	private String title;

	/**
	 * This field corresponds to the database column enrichment.description
	 */
	private String description;

	/**
	 * This field corresponds to the database column enrichment.starttime
	 */
	private String starttime;

	/**
	 * This field corresponds to the database column enrichment.endtime
	 */
	private String endtime;

	/**
	 * This field corresponds to the database column enrichment.videoid
	 */
	private Integer videoid;
	
	/**
	 * This field corresponds to the database column enrichment.videoname
	 */
	private String videoName;

	/**
	 * This field corresponds to the database column enrichment.componenttypeid
	 */
	private Integer componenttypeid;

	/**
	 * This field corresponds to the database column enrichment.nestparentid
	 */
	private Integer nestparentid;

	/**
	 * This field corresponds to the database column enrichment.componentnestid
	 */
	private Integer componentnestid;

	
	transient String componetType;

	/**
	 * This method returns the value of the database column
	 * enrichment.enrichmentid
	 * 
	 * @return the value of enrichment.enrichmentid
	 */
	public Integer getEnrichmentid() {
		return enrichmentid;
	}

	/**
	 * This method sets the value of the database column enrichment.enrichmentid
	 * 
	 * @param enrichmentid
	 *            the value for enrichment.enrichmentid
	 */
	public void setEnrichmentid(Integer enrichmentid) {
		this.enrichmentid = enrichmentid;
	}

	/**
	 * This method returns the value of the database column enrichment.title
	 * 
	 * @return the value of enrichment.title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method sets the value of the database column enrichment.title
	 * 
	 * @param title
	 *            the value for enrichment.title
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * This method returns the value of the database column
	 * enrichment.description
	 * 
	 * @return the value of enrichment.description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the database column enrichment.description
	 * 
	 * @param description
	 *            the value for enrichment.description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the database column enrichment.starttime
	 * 
	 * @return the value of enrichment.starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * This method sets the value of the database column enrichment.starttime
	 * 
	 * @param starttime
	 *            the value for enrichment.starttime
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * This method returns the value of the database column enrichment.endtime
	 * 
	 * @return the value of enrichment.endtime
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * This method sets the value of the database column enrichment.endtime
	 * 
	 * @param endtime
	 *            the value for enrichment.endtime
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * This method returns the value of the database column enrichment.videoid
	 * 
	 * @return the value of enrichment.videoid
	 */
	public Integer getVideoid() {
		return videoid;
	}

	/**
	 * This method sets the value of the database column enrichment.videoid
	 * 
	 * @param videoid
	 *            the value for enrichment.videoid
	 */
	public void setVideoid(Integer videoid) {
		this.videoid = videoid;
	}

	/**
	 * This method returns the value of the database column
	 * enrichment.componenttypeid
	 * 
	 * @return the value of enrichment.componenttypeid
	 */
	public Integer getComponenttypeid() {
		return componenttypeid;
	}

	/**
	 * This method sets the value of the database column
	 * enrichment.componenttypeid
	 * 
	 * @param componenttypeid
	 *            the value for enrichment.componenttypeid
	 */
	public void setComponenttypeid(Integer componenttypeid) {
		this.componenttypeid = componenttypeid;
	}

	/**
	 * This method returns the value of the database column
	 * enrichment.nestparentid
	 * 
	 * @return the value of enrichment.nestparentid
	 */
	public Integer getNestparentid() {
		return nestparentid;
	}

	/**
	 * This method sets the value of the database column enrichment.nestparentid
	 * 
	 * @param nestparentid
	 *            the value for enrichment.nestparentid
	 */
	public void setNestparentid(Integer nestparentid) {
		this.nestparentid = nestparentid;
	}

	/**
	 * This method returns the value of the database column
	 * enrichment.componentnestid
	 * 
	 * @return the value of enrichment.componentnestid
	 */
	public Integer getComponentnestid() {
		return componentnestid;
	}

	/**
	 * This method sets the value of the database column
	 * enrichment.componentnestid
	 * 
	 * @param componentnestid
	 *            the value for enrichment.componentnestid
	 */
	public void setComponentnestid(Integer componentnestid) {
		this.componentnestid = componentnestid;
	}
    
	public String getComponetType() {
		return componetType;
	}

	public void setComponetType(String componetType) {
		this.componetType = componetType;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	
	
	public String getVideoname() {
		return videoName;
	}
}