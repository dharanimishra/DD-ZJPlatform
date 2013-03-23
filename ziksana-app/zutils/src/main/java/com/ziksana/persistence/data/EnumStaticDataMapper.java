/**
 * 
 */
package com.ziksana.persistence.data;

import java.util.List;

import com.ziksana.domain.common.NameValue;

/**
 * @author Ratnesh Kumar
 *
 */
public interface EnumStaticDataMapper {
	
	public List<NameValue> fetchData(String category);

}
