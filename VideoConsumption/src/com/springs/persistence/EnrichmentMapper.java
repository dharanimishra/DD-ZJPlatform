package com.springs.persistence;

import java.util.List;

import com.springs.domain.Enrichment;
import com.springs.domain.PlayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Bean;

public interface EnrichmentMapper {
	/**
	 * This method corresponds to the database table enrichment
	 */
	@Delete({ "delete from enrichment",
			"where enrichmentid = #{enrichmentid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer enrichmentid);

	/**
	 * This method corresponds to the database table enrichment
	 */
	@Insert({
			"insert into enrichment (enrichmentid, title, ",
			"description, starttime, ",
			"endtime, videoid, videoname, componenttypeid, ",
			"nestparentid, componentnestid)",
			"values (#{enrichmentid,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
			"#{description,jdbcType=VARCHAR}, #{starttime,jdbcType=TIME}, ",
			"#{endtime,jdbcType=TIME}, #{videoid,jdbcType=INTEGER}, #{videoname,jdbcType=VARCHAR}, #{componenttypeid,jdbcType=INTEGER}, ",
			"#{nestparentid,jdbcType=INTEGER}, #{componentnestid,jdbcType=INTEGER})" })
	int insert(Enrichment record);

	/**
	 * This method corresponds to the database table enrichment
	 */
	int insertSelective(Enrichment record);

	/**
	 * This method corresponds to the database table enrichment
	 */
	@Select({
			"select",
			"enrichmentid, title, description, starttime, endtime, videoid, videoname, componenttypeid, ",
			"nestparentid, componentnestid", "from enrichment",
			"where enrichmentid = #{enrichmentid,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	Enrichment selectByPrimaryKey(Integer enrichmentid);

	/**
	 * This method corresponds to the database table enrichment
	 */
	int updateByPrimaryKeySelective(Enrichment record);

	/**
	 * This method corresponds to the database table enrichment
	 */
	@Update({ "update enrichment", "set title = #{title,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR},",
			"starttime = #{starttime,jdbcType=TIME},",
			"endtime = #{endtime,jdbcType=TIME},",
			"videoid = #{videoid,jdbcType=INTEGER},",
			"videoname = #{videoName,jdbcType=INTEGER},",
			"componenttypeid = #{componenttypeid,jdbcType=INTEGER},",
			"nestparentid = #{nestparentid,jdbcType=INTEGER},",
			"componentnestid = #{componentnestid,jdbcType=INTEGER}",
			"where enrichmentid = #{enrichmentid,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Enrichment record);
	
	@Select({"select",
		"enrichmentid, title, description, starttime, endtime, videoid, videoname, componenttypeid, ",
		"nestparentid, componentnestid", "from enrichment",
		" where videoid = #{videoId,jdbcType=INTEGER} and componenttypeid!=3 order by starttime;" })
	@ResultMap("BaseResultMap")
	public List<Enrichment> getEnrichmentList(Integer videoId);

	
	List<Enrichment> getEnrichment(@Param("videoid") Integer videoid,@Param("starttime")  String starttime);
	
	@Select({"select",
		"enrichmentid, title, description, starttime, endtime, videoid, componenttypeid, ",
		"nestparentid, componentnestid", "from enrichment where componenttypeid=3 order by nestparentid"
		})
	@ResultMap("BaseResultMap")
	public List<Enrichment> getTree();
}