package com.ziksana.service.course.impl;

import java.sql.Timestamp;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.ContentEnrichment;
import com.ziksana.domain.course.Enrichment;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LinkType;
import com.ziksana.domain.course.Visibility;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.service.course.CourseContentEnrichmentService;

/**
 * @author ratneshkumar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CourseEnrichmentServiceTest extends BaseTest {

	@Autowired
	public CourseContentEnrichmentService enrichmentService;

	@Test
	public void testSaveReferenceOrTopicOrNotes() throws Exception {
		System.out
				.println("******** Inside testSaveReferenceOrTopicOrNotes *********");
		Enrichment enrichment = null;
		LinkType linkType = null;

		enrichment = constructEnrichment(enrichment, linkType.REFERENCE);

		enrichmentService.saveReference(enrichment, LinkType.REFERENCE);

		Assert.assertNotNull(enrichment != null);

	}

	private Enrichment constructEnrichment(Enrichment enrichment,
			LinkType linkType) {

		MemberPersona authoredMember = new MemberPersona();
		authoredMember.setMemberRoleId(100);

		enrichment = new Enrichment();

		LearningContent content = new LearningContent();
		content.setLearningContentId(7);

		enrichment.setLearningContent(content);
		enrichment.setVisibilityId(Visibility.ALL.getID());
		enrichment.setCreatorMemberPersona(authoredMember);
		enrichment.setOverrideAt(100);
		enrichment.setActive(true);

		ContentEnrichment contEnrichment = new ContentEnrichment();

		contEnrichment.setActive(true);
		contEnrichment.setStartTime(new Timestamp(System.currentTimeMillis()));
		contEnrichment.setEndTime(new Timestamp(
				System.currentTimeMillis() + 10000));
		contEnrichment.setLinkTypeId(linkType.getID());
		contEnrichment.setLinkDescription("Enrichment 1");
		//contEnrichment.setApplyEnrichment(enrichment);

		enrichment.setContentEnrich(contEnrichment);

		return enrichment;
	}

}
