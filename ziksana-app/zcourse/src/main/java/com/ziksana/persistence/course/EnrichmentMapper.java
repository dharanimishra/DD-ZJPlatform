package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.ContentEnrichment;
import com.ziksana.domain.course.Enrichment;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.ReferenceSearchCriteria;

/**
 * This holds the operations for Enrichment and ContentEnrichment.
 * 
 * @author bhashasp
 */
public interface EnrichmentMapper {

	/**
	 * This method saves the Course information to corcourse table
	 */
	Integer saveReference(Enrichment enrich);

	/**
	 * updates delete indicator to remove the association with content
	 * 
	 * @param enrichment
	 */
	@Update({ "update corenrichment set isdelete = #{isDelete,jdbcType=BOOLEAN} where enrichmentid = #{enrichmentId,jdbcType=INTEGER}" })
	void deleteEnrichment(Enrichment enrichment);

	/**
	 * Retrieves the enrichment and its contenterichments
	 * 
	 * @param memberRoleId
	 * @return
	 */
	@Select({
			"select enrichentid, active, visibility, overrideat, creatormemberroleid, courseid from ",
			"corenrichment where creatormemberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "enrichmentId", column = "enrichmentid"),
			@Result(property = "active", column = "active"),
			@Result(property = "visibility", column = "visibility"),
			@Result(property = "overrideAt", column = "overrideat"),
			@Result(property = "creatorMemberPersona.memberRoleId", column = "creatormemberroleid"),
			@Result(property = "course.courseId", column = "courseid"),
			@Result(property = "contentEnrich", column = "enrichmentId", javaType = ContentEnrichment.class, one = @One(select = "getContentEnrichment")) })
	List<Enrichment> getAllEnrichments(Integer memberRoleId);

	@Select({
			" select contentenrichmentid, starttime, endtime, linktype, linkelement, internalindicator,linkdescription, ",
			" linkitemauthor, linkitemcost, linksource, active, deleteindicator, enrichmentid from corcontentenrichment ",
			" where enrichmentid = #{enrichmentId,jdbcType.INTEGER}" })
	@Results(value = {
			@Result(property = "contentEnrichmentId", column = "contentenrichmentid"),
			@Result(property = "startTime", column = "starttime"),
			@Result(property = "endTime", column = "endtime"),
			@Result(property = "linkType", column = "linktype"),
			@Result(property = "linkElement", column = "linkelement"),
			@Result(property = "lnternalIndicator", column = "internalindicator"),
			@Result(property = "linkDescription", column = "linkdescription"),
			@Result(property = "linkItemAuthor", column = "linkitemauthor"),
			@Result(property = "linkItemCost", column = "linkitemcost"),
			@Result(property = "linkSource", column = "linksource"),
			@Result(property = "active", column = "active"),
			@Result(property = "enrichment.enrichmentId", column = "enrichmentid") })
	ContentEnrichment getContentEnrichment(Integer enrichmentId);

	/**
	 * Retrieves the enrchimentid by providing the componentid
	 * @param lCompId
	 * @param learningContentId
	 * @return
	 */
	@Select({
			"select count(*) from corenrichment where learningcomponentid = #{learningcomponentid,jdbctype=INTEGER} ",
			" or learningcontentid = #{learningContentId,jdbcType=INTEGER}" })
	int getEnrichByContentIdOrComponentId(Integer lCompId,
			Integer learningContentId);

	/**
	 * Saves thee refence content.
	 * @param contentEnrichment
	 */
	Integer saveRefenceContent(ContentEnrichment contentEnrichment);

	/**
	 * Removes the association of contentenrichment with content.
	 */
	@Update({
			"update corcontentenrichment set  isDelete = #{isDelete,jdbctype=BOOLEAN} where ",
			" contentenrichmentid = #{contentEnrichmentId,jdbcType=INTEGER}" })
	void deleteContentEnrichment(ContentEnrichment contentEnrichment);

	/**
	 * Modifies the content enrichment
	 * @param contentEnrichment
	 */
	void updateContentEnrichment(ContentEnrichment contentEnrichment);

	
	
	/**
	 * Searches the provide advanced search criteria
	 * @param searchCriteria
	 * @return
	 */
	@Select({
			"select learningcontenid, contenttype, contentname, contentdescription,authoringmemberroleid, rightsowningmemberroleid ",
			" from corlearningcontent where contentname like where linktype = #{linkType,jdbcType=INTEGER} and  contentname like  % #{tags,jdbcType.VARCHAR} %  ",
			"and contenttype=#{contentType,jdbcType=INTEGER} "
			})
	@Results(value = {
			@Result(property = "learningcontenid", column = "learningcontenid"),
			@Result(property = "contenttype", column = "contenttype"),
			@Result(property = "contentname", column = "contentname"),
			@Result(property = "contentDescription", column = "contentdescription"),
			@Result(property = "authoringMember.memberRoleId", column = "authoringmemberroleid"),
			@Result(property = "rightsOwningMember.memberRoleId", column = "rightsowningmemberroleid") })
	List<LearningContent> advanceSearchReferenceMaterial(
			ReferenceSearchCriteria searchCriteria);

	/**
	 * Searches the provide basic search criteria 
	 * @param searchCriteria
	 * @return
	 */
	@Select({
			"select learningcontenid, contenttype, contentname, contentdescription,authoringmemberroleid, rightsowningmemberroleid ",
			" from corlearningcontent where linktype = #{linkType,jdbcType=INTEGER} and contentname like  % #{name,jdbcType.VARCHAR} % " })
	@Results(value = {
			@Result(property = "learningcontenid", column = "learningcontenid"),
			@Result(property = "contenttype", column = "contenttype"),
			@Result(property = "contentname", column = "contentname"),
			@Result(property = "contentDescription", column = "contentdescription"),
			@Result(property = "authoringMember.memberRoleId", column = "authoringmemberroleid"),
			@Result(property = "rightsOwningMember.memberRoleId", column = "rightsowningmemberroleid") })
	List<LearningContent> basicSearchReferenceMaterial(
			ReferenceSearchCriteria searchCriteria);

}
