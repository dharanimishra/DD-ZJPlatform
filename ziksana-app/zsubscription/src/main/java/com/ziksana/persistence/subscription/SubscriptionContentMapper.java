/**
 * 
 */
package com.ziksana.persistence.subscription;

import com.ziksana.domain.course.Content;

/**
 * @author prabu
 *
 */
public interface SubscriptionContentMapper {
	
	public Content getContent(Integer contentId);

}
