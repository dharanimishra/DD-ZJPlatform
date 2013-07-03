/**
 * 
 */
package com.ziksana.persistence.data;

import java.util.List;

import com.ziksana.domain.utils.NameValue;

/**
 * @author prabu
 *
 */
public interface StaticDataMapper {
	
	public List<NameValue> fetchData(String category);

}
