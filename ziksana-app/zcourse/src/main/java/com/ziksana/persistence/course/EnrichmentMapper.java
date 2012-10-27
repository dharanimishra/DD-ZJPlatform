package com.ziksana.persistence.course;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
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
	@Insert({
			"insert into corapplyenrichment ( creationdate, active, visibility, overrideat, learningcontentid, learningcomponentid, ",
			"courseid, creatormemberroleid) ",
			"values (sysdate(), ",
			"#{active,jdbcType=BIT}, ",
			"#{visibility,jdbcType=INTEGER}, ",
			"#{overrideAt,jdbcType=INTEGER}, ",
			"#{learningContent.learningContentId,jdbcType=INTEGER}, ",
			"#{learningcomponent.learningComponentId,jdbcType=INTEGER}, ",
			"#{course.courseId,jdbcType=BIT}, #{creatorMemberPersona.memberRoleId,jdbcType=VARCHAR})" })
	@Results(value = {
			@Result(property = "enrichentId", column = "enrichentid"),
			@Result(property = "active", column = "active"),
			@Result(property = "visibility", column = "visibility"),
			@Result(property = "overrideAt", column = "overrideat"),
			@Result(property = "creatorMemberPersona.memberroleId", column = "creatormemberroleid"),
			@Result(property = "course.courseId", column = "courseid"), })
	Enrichment saveReference(Enrichment enrich);

	/**
	 * updates delete indicator to remove the association with content
	 * 
	 * @param enrichment
	 */
	@Update({ "update corApplyEnrichment set isDelete = #{isDelete,jdbcType=BIT} where enrichmentid = #{enrichId,jdbcType=INTEGER}" })
	void delete(Enrichment enrichment);

	/**
	 * Retrieves the enrichment and its contenterichments
	 * 
	 * @param memberRoleId
	 * @return
	 */
	@Select({
			"select enrichentid, active, visibility, overrideat, creatormemberroleid, courseid from ",
			"corapplyenrichment where creatormemberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "enrichentId", column = "enrichentid"),
			@Result(property = "active", column = "active"),
			@Result(property = "visibility", column = "visibility"),
			@Result(property = "overrideAt", column = "overrideat"),
			@Result(property = "creatorMemberPersona.memberRoleId", column = "creatormemberroleid"),
			@Result(property = "course.courseId", column = "courseid"),
			@Result(property = "contentEnrich", column = "enrichentId", javaType = ContentEnrichment.class, one = @One(select = "getContentEnrichment")) })
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
			"select enrichmentid from corapplyenrichment where learningcomponentid = #{learningcomponentid,jdbctype=INTEGER} ",
			" or learningcontentid = #{learningContentId,jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "enrichentId", column = "enrichentid") })
	Integer getEnrichByContentIdOrComponentId(Integer lCompId,
			Integer learningContentId);

	/**
	 * Saves thee refence content.
	 * @param contentEnrichment
	 */
	@Insert({
			"insert into corcontentenrichment (starttime, endtime, linktype, linkelement, internalindicator,linkdescription, ",
			"linkitemauthor, linkitemcost, linksource, active, isdelete, enrichmentid ) values (#{startTime,jdbcType.TIMESTAMP},",
			"#{endTime,jdbcType.TIMESTAMP},  #{linkType,jdbcType.INTEGER}, #{linkElement,jdbcType.VARCHAR}, #{linkItemCost,jdbcType.INTEGER}, #{linkSource,jdbcType.INTEGER},",
			" #{active,jdbcType.BIT}, #{isDelete,jdbcType.BOOLEAN}, #{enrichment.enrichmentId,jdbcType.INTEGER})" })
	void saveRefenceContent(ContentEnrichment contentEnrichment);

	/**
	 * Removes the association of contentenrichment with content.
	 */
	@Update({
			"update corcontentenrichment set  isDelete = #{isDelete,jdbctype=BOOLEAN} where ",
			" contentenrichmentid = #{contentEnrichmentId,jdbcType=INTEGER}" })
	void delete(ContentEnrichment contentEnrichment);

	/**
	 * Modifies the content enrichment
	 * @param contentEnrichment
	 */
	@Update({
			"update corContentEnrichment set starttime =#{startTime,jdbcType.TIMESTAMP},",
			"endtime = #{endTime,jdbcType.TIMESTAMP},  linktype = #{linkType,jdbcType.INTEGER}, linkelement=#{linkElement,jdbcType.VARCHAR},",
			" linkitemcost = #{linkItemCost,jdbcType.INTEGER}, linksouce = #{linkSource,jdbcType.INTEGER},",
			" active = #{active,jdbcType.BIT} where contentenrichmentid = #{contentEnrichmentId,jdbcType.INTEGER}" })
	void update(ContentEnrichment contentEnrichment);

	
	
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
